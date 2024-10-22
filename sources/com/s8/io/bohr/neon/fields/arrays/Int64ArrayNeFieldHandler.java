package com.s8.io.bohr.neon.fields.arrays;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.BuildScope;
import com.s8.io.bohr.neon.core.NeObjectTypeFieldsBlock;
import com.s8.io.bohr.neon.fields.NeFieldHandler;
import com.s8.io.bohr.neon.fields.NeFieldUpdate;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class Int64ArrayNeFieldHandler extends PrimitiveNeFieldHandler {

	public final static long SIGNATURE =  BOHR_Types.ARRAY << 8 & BOHR_Types.INT64;

	public @Override long getSignature() { return SIGNATURE; }


	public Int64ArrayNeFieldHandler(NeObjectTypeFieldsBlock prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.ARRAY);
		outflow.putUInt8(BOHR_Types.INT64);
	}

	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public NeFieldUpdate createUpdate(long[] value) {
		return new Update(value);
	}

	
	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends PrimitiveNeFieldHandler.Update {
		
		private long[] value;
	
		public Update(long[] value) {
			super();
			this.value = value;
		}
		
		private boolean checkIfHasDelta(long[] value) {
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
						if(this.value[i] != value[i]) { return true; }
					}
					return false;
				}
			}
		}
		
		public boolean setValue(long[] value) {
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
					outflow.putInt64(value[i]);		
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
				value = new long[length];
				for(int i=0; i<length; i++) {
					value[i] = inflow.getInt64();
				}
			}
			else {
				value = null;
			}
		}

		@Override
		public NeFieldHandler getFieldHandler() {
			return Int64ArrayNeFieldHandler.this;
		}
	}
}
