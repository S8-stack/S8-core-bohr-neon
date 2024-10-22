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
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class Float32ArrayNeFieldHandler extends PrimitiveNeFieldHandler {

	public final static long SIGNATURE =  BOHR_Types.ARRAY << 8 & BOHR_Types.FLOAT32;

	public @Override long getSignature() { return SIGNATURE; }


	public Float32ArrayNeFieldHandler(NeObjectTypeFieldsBlock prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.ARRAY);
		outflow.putUInt8(BOHR_Types.FLOAT32);
	}
	
	
	/**
	 * 
	 * @param values
	 * @param value
	 */
	public NeFieldUpdate createUpdate(float[] value) {
		return new Update(value);
	}
	
	
	
	
	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends PrimitiveNeFieldHandler.Update {
		
		private float[] value;
	
		private Update(float[] value) {
			super();
			this.value = value;
		}
		
		private boolean checkIfHasDelta(float[] value) {
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
		
		public boolean setValue(float[] value) {
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
					outflow.putFloat32(value[i]);		
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
				value = new float[length];
				for(int i=0; i<length; i++) {
					value[i] = inflow.getFloat32();
				}
			}
			else {
				value = null;
			}
		}

		@Override
		public NeFieldHandler getFieldHandler() {
			return Float32ArrayNeFieldHandler.this;
		}
	}
}
