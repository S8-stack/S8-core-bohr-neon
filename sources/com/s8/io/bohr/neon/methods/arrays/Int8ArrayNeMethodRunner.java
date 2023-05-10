package com.s8.io.bohr.neon.methods.arrays;

import java.io.IOException;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeHandler;
import com.s8.io.bohr.neon.functions.NeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt8ArrayNeFunction;
import com.s8.io.bohr.neon.methods.NeMethod;
import com.s8.io.bytes.alpha.ByteInflow;

/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class Int8ArrayNeMethodRunner extends NeMethod {


	public final static long SIGNATURE = (BOHR_Types.ARRAY << 8) & BOHR_Types.INT8;
	public @Override long getSignature() { return SIGNATURE; }


	/**
	 * 
	 * @param prototype
	 * @param name
	 */
	public Int8ArrayNeMethodRunner(NeObjectTypeHandler prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}


	@Override
	public void run(NeBranch branch, Object context, ByteInflow inflow, NeFunction function) throws IOException {
		int[] arg = null;
		int length = (int) inflow.getUInt7x();
		if(length >= 0) {
			arg = new int[length];
			for(int i=0; i<length; i++) { arg[i] = inflow.getInt8(); }
		}
		((UInt8ArrayNeFunction) function).run(context, arg);
	}
}
