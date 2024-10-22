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
public class Bool8NeFieldHandler extends PrimitiveNeFieldHandler {

	
	public final static long SIGNATURE = BOHR_Types.BOOL8;

	public @Override long getSignature() { return SIGNATURE; }



	/**
	 * 
	 * @param name
	 */
	public Bool8NeFieldHandler(NeObjectTypeFieldsBlock prototype, String name) {
		super(prototype, name);
	}
	


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.BOOL8);
	}
	

	/**
	 * 
	 * @param values
	 * @return
	 */
	public boolean get(NeFieldUpdate wrapper) {
		return ((Value) wrapper).value;
	}
	
	
	/**
	 * 
	 * @param values
	 * @param value
	 */
	public Value createUpdate(boolean value) {
		return new Value(value);
	}
	

	/***
	 * 
	 * @param inflow
	 * @return
	 * @throws IOException
	 */
	public static Boolean parse(ByteInflow inflow) throws IOException {
		return inflow.getBool8();
	}
	


	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Value extends PrimitiveNeFieldHandler.Update {
		
		@Override
		public NeFieldHandler getFieldHandler() {
			return Bool8NeFieldHandler.this;
		}
		

		private boolean value;

		public Value(boolean value) {
			super();
			this.value = value;
		}

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			outflow.putBool8(value);
		}
		
		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			value = inflow.getBool8();
		}
	}
}
