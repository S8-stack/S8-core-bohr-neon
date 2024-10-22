package com.s8.io.bohr.neon.fields.primitives;

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
public class Float32NeFieldHandler extends PrimitiveNeFieldHandler {

	
	
	public final static long SIGNATURE = BOHR_Types.FLOAT32;

	public @Override long getSignature() { return SIGNATURE; }



	public Float32NeFieldHandler(NeObjectTypeFieldsBlock prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.FLOAT32);
	}
	
	
	/**
	 * 
	 * @param values
	 * @return
	 */
	public float get(NeFieldUpdate wrapper) {
		return ((Value) wrapper).value;
	}
	
	
	/**
	 * 
	 * @param values
	 * @param value
	 */
	public Value createValue(float value) {
		return new Value(value);
	}
	

	
	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Value extends PrimitiveNeFieldHandler.Update {
		
		@Override
		public NeFieldHandler getFieldHandler() {
			return Float32NeFieldHandler.this;
		}
		
		private float value;
	
		public Value(float value) {
			super();
			this.value = value;
		}
		

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			outflow.putFloat32(value);
		}

		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			value = inflow.getFloat32();
		}
		
	}
}
