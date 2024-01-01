package com.s8.io.bohr.neon.fields.arrays;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
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
public class StringUTF8ArrayNeFieldHandler extends PrimitiveNeFieldHandler {

	public final static long SIGNATURE =  BOHR_Types.ARRAY << 8 & BOHR_Types.STRING_UTF8;

	public @Override long getSignature() { return SIGNATURE; }


	public StringUTF8ArrayNeFieldHandler(NeObjectTypeFields prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.ARRAY);
		outflow.putUInt8(BOHR_Types.STRING_UTF8);
	}


	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public NeFieldUpdate createValue(String[] value) {
		return new Update(value);
	}



	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends PrimitiveNeFieldHandler.Update {

		private String[] value;

		public Update(String[] value) {
			super();
			this.value = value;
		}

		
		/**
		 * 
		 * @param value
		 * @return
		 */
		private boolean checkIfHasDelta(String[] value) {
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
						String left = this.value[i], right = value[i];
						if((left == null && right != null) || 
								(left != null && right == null) ||
								(left != null && right != null && !left.equals(right))) {
							return true;
						}
					}
					return false;
				}
			}
		}

		
		/**
		 * 
		 * @param value
		 */
		public boolean setValue(String[] value) {
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
					outflow.putStringUTF8(value[i]);		
				}
			}
			else {
				outflow.putUInt7x(-1);
			}
		}

		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			int length = (int) inflow.getUInt7x();
			if(length >=0 ) {
				value = new String[length];
				for(int i=0; i<length; i++) {
					value[i] = inflow.getStringUTF8();
				}
			}
			else {
				value = null;
			}
		}


		@Override
		public NeFieldHandler getFieldHandler() {
			return StringUTF8ArrayNeFieldHandler.this;
		}
	}
}
