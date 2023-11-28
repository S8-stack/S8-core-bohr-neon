package com.s8.io.bohr.neon.fields.primitives;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.BuildScope;
import com.s8.io.bohr.neon.core.NeObjectTypeFields;
import com.s8.io.bohr.neon.fields.NeFieldValue;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class UInt64NeFieldHandler extends PrimitiveNeFieldHandler {

	
	public final static long SIGNATURE = BOHR_Types.UINT64;

	public @Override long getSignature() { return SIGNATURE; }



	public UInt64NeFieldHandler(NeObjectTypeFields prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.UINT64);
	}

	/**
	 * 
	 * @param values
	 * @return
	 */
	public long get(NeFieldValue wrapper) {
		return ((Value) wrapper).value;
	}
	
	
	/**
	 * 
	 * @param values
	 * @param value
	 */
	public boolean set(NeFieldValue wrapper, long value) {
		return ((Value) wrapper).setValue(value);
	}
	
	

	@Override
	public NeFieldValue createValue() {
		return new Value();
	}

	
	
	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public static class Value extends PrimitiveNeFieldHandler.Value {
		
		private long value;
	
		public Value() {
			super();
		}
		
		public boolean setValue(long value) {
			if(this.value != value) {
				this.value = value;
				this.hasDelta = true;	
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			outflow.putUInt64(value);
		}

		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			value = inflow.getUInt64();
		}
	}
}
