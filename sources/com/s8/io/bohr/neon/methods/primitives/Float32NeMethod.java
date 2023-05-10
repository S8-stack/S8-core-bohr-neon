package com.s8.io.bohr.neon.methods.primitives;

import java.io.IOException;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeHandler;
import com.s8.io.bohr.neon.functions.NeFunction;
import com.s8.io.bohr.neon.functions.primitives.Float32NeFunction;
import com.s8.io.bohr.neon.methods.NeMethodRunner;
import com.s8.io.bytes.alpha.ByteInflow;

/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class Float32NeMethod extends NeMethodRunner {

	public final static long SIGNATURE = BOHR_Types.FLOAT32;
	public @Override long getSignature() { return SIGNATURE; }


	public Float32NeMethod(NeObjectTypeHandler prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}

	@Override
	public void run(NeBranch<?> branch, ByteInflow inflow, NeFunction function) throws IOException {
		float arg =  inflow.getFloat32();
		((Float32NeFunction) function).run(arg);
	}
}

