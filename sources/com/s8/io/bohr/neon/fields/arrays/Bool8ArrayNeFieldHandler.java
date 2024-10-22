package com.s8.io.bohr.neon.fields.arrays;

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
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class Bool8ArrayNeFieldHandler extends PrimitiveNeFieldHandler {

	
	public final static long SIGNATURE =  BOHR_Types.ARRAY << 8 & BOHR_Types.BOOL8;

	public @Override long getSignature() { return SIGNATURE; }



	/**
	 * 
	 * @param name
	 */
	public Bool8ArrayNeFieldHandler(NeObjectTypeFieldsBlock prototype, String name) {
		super(prototype, name);
	}
	


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.ARRAY);
		outflow.putUInt8(BOHR_Types.BOOL8);
	}
	

	/**
	 * 
	 * @param values
	 * @param value
	 */
	public Update createUpdate(boolean[] value) {
		return new Update(value);
	}
	


	/***
	 * 
	 * @param inflow
	 * @return
	 * @throws IOException
	 */
	public static boolean[] parse(ByteInflow inflow) throws IOException {
		int n = (int) inflow.getUInt7x();
		if(n >= 0) {
			boolean[] value = new boolean[n];
			for(int i = 0; i<n; i++) { value[i] = inflow.getBool8(); }
			return value;
		}
		else {
			return null;
		}
	}
	


	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends PrimitiveNeFieldHandler.Update {

		private boolean[] value;

		/**
		 * 
		 * @param value
		 */
		public Update(boolean[] value) {
			super();
			this.value = value;
		}
		
		
		
		

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			if(value != null) {
				int n = value.length;
				outflow.putUInt7x(n);
				for(int i = 0; i<n; i++) { outflow.putBool8(value[i]); }
			}
			else {
				outflow.putUInt7x(-1);
			}
		}
		
		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			int n = (int) inflow.getUInt7x();
			if(n >= 0) {
				value = new boolean[n];
				for(int i = 0; i<n; i++) { value[i] = inflow.getBool8(); }
			}
			else {
				value = null;
			}
		}


		@Override
		public NeFieldHandler getFieldHandler() {
			return Bool8ArrayNeFieldHandler.this;
		}
	}



}
