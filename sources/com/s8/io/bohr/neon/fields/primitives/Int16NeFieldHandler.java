package com.s8.io.bohr.neon.fields.primitives;

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
public class Int16NeFieldHandler extends PrimitiveNeFieldHandler {


	public final static long SIGNATURE = BOHR_Types.INT16;

	public @Override long getSignature() { return SIGNATURE; }




	public Int16NeFieldHandler(NeObjectTypeFields prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.INT16);
	}



	/**
	 * 
	 * @param value
	 * @return
	 */
	public NeFieldUpdate createValue(int value) {
		return new Update(value);
	}




	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends PrimitiveNeFieldHandler.Update {

		@Override
		public NeFieldHandler getFieldHandler() {
			return Int16NeFieldHandler.this;
		}
		
		private int value;

		public Update(int value) {
			super();
			this.value = value;
		}

		

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			outflow.putInt16((short) value);
		}

		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			value = inflow.getInt16();
		}
	}
}
