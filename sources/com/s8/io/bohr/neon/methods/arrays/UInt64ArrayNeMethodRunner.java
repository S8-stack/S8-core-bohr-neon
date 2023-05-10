package com.s8.io.bohr.neon.methods.arrays;

import java.io.IOException;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeHandler;
import com.s8.io.bohr.neon.functions.NeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt64ArrayNeFunction;
import com.s8.io.bohr.neon.methods.NeMethod;
import com.s8.io.bytes.alpha.ByteInflow;

/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class UInt64ArrayNeMethodRunner extends NeMethod {


	public final static long SIGNATURE = (BOHR_Types.ARRAY << 8) & BOHR_Types.UINT64;
	public @Override long getSignature() { return SIGNATURE; }


	/**
	 * 
	 * @param prototype
	 * @param name
	 */
	public UInt64ArrayNeMethodRunner(NeObjectTypeHandler prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}


	@Override
	public void run(NeBranch branch, Object context, ByteInflow inflow, NeFunction function) throws IOException {
		long[] arg = null;
		int length = (int) inflow.getUInt7x();
		if(length >= 0) {
			arg = new long[length];
			for(int i=0; i<length; i++) { arg[i] = inflow.getUInt64(); }
		}
		((UInt64ArrayNeFunction) function).run(context, arg);
	}
}
