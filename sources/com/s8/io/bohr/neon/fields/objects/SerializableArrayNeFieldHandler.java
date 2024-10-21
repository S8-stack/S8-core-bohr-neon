package com.s8.io.bohr.neon.fields.objects;

import java.io.IOException;
import java.lang.reflect.Array;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.api.serial.S8SerialPrototype;
import com.s8.api.serial.S8Serializable;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.BuildScope;
import com.s8.io.bohr.neon.core.NeObjectTypeFields;
import com.s8.io.bohr.neon.fields.NeFieldHandler;
import com.s8.io.bohr.neon.fields.NeFieldUpdate;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class SerializableArrayNeFieldHandler<S extends S8Serializable> extends NeFieldHandler {

	public final static long SIGNATURE =  BOHR_Types.ARRAY << 8 & BOHR_Types.SERIAL;

	public @Override long getSignature() { return SIGNATURE; }


	public SerializableArrayNeFieldHandler(NeObjectTypeFields prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.ARRAY);
		outflow.putUInt8(BOHR_Types.SERIAL);
	}


	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public NeFieldUpdate createValue(S[] value) {
		return new Update(value);
	}



	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends NeFieldUpdate {

		private S[] value;
		
		private S8SerialPrototype<S> proto;

		public Update(S[] value) {
			super();
			this.value = value;
		}
		
		public Update(S8SerialPrototype<S> proto) {
			super();
			this.proto = proto;
		}

		
		/**
		 * 
		 * @param value
		 * @return
		 */
		@SuppressWarnings("unchecked")
		private boolean checkIfHasDelta(S[] value) {
			if(this.value == null && value == null) {
				return false;
			}
			else if((this.value != null && value == null) || (this.value == null && value != null)) {
				return true;
			}
			else { /* this.value != null && value != null */
				int nLeft = this.value.length, nRight = value.length;
				if(nLeft != nRight) {
					return true;
				}
				else {
					for(int i= 0; i<nLeft; i++) {
						S left = this.value[i], right = value[i];
						if((left == null && right != null) || (left != null && right == null)) {
							return true;
						}
						else if(left != null && right != null) {
							if(proto == null) { proto = (S8SerialPrototype<S>) left.getSerialPrototype(); }
							if(proto.hasDelta(left, right)) {
								return true;
							}
						}
						// else -> false
					}
					return false;
				}
			}
		}

		
		/**
		 * 
		 * @param value
		 */
		public boolean setValue(S[] value) {
			if(checkIfHasDelta(value)) {
				this.value = value;
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			if(value != null) {
				int length = value.length;
				outflow.putUInt7x(length);
				for(int i=0; i<length; i++) {
					value[i].serialize(outflow);
				}
			}
			else {
				outflow.putUInt7x(-1);
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			int length = (int) inflow.getUInt7x();
			if(length >=0 ) {
				value = (S[]) Array.newInstance(proto.getSerialType(), length);
				Array.newInstance(getClass(), length);
				for(int i=0; i<length; i++) {
					value[i] = proto.deserialize(inflow);
				}
			}
			else {
				value = null;
			}
		}


		@Override
		public NeFieldHandler getFieldHandler() {
			return SerializableArrayNeFieldHandler.this;
		}
	}
}
