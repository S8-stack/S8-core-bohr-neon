package com.s8.io.bohr.neon.fields.primitives;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.BuildScope;
import com.s8.io.bohr.neon.core.NeObjectTypeFieldsBlock;
import com.s8.io.bohr.neon.fields.NeFieldHandler;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class Int64NeFieldHandler extends PrimitiveNeFieldHandler {


	public final static long SIGNATURE = BOHR_Types.INT64;

	public @Override long getSignature() { return SIGNATURE; }



	public Int64NeFieldHandler(NeObjectTypeFieldsBlock prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.INT64);
	}


	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public Update createUpdate(long value) {
		return new Update(value);
	}




	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends PrimitiveNeFieldHandler.Update {

		private long value;

		public Update(long value) {
			super();
			this.value = value;
		}


		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			outflow.putInt64(value);
		}

		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			value = inflow.getInt64();
		}

		@Override
		public NeFieldHandler getFieldHandler() {
			return Int64NeFieldHandler.this;
		}
	}
}
