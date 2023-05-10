package com.s8.io.bohr.neon.methods.objects;

import java.io.IOException;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObject;
import com.s8.io.bohr.neon.core.NeObjectTypeHandler;
import com.s8.io.bohr.neon.core.NeVertex;
import com.s8.io.bohr.neon.functions.NeFunction;
import com.s8.io.bohr.neon.functions.objects.ObjectNeFunction;
import com.s8.io.bohr.neon.methods.NeMethodRunner;
import com.s8.io.bytes.alpha.ByteInflow;

/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class ObjectNeMethod<T extends NeObject<?>> extends NeMethodRunner {




	public final static long SIGNATURE = BOHR_Types.S8OBJECT;

	public @Override long getSignature() { return SIGNATURE; }


	/**
	 * 
	 * @param prototype
	 * @param name
	 */
	public ObjectNeMethod(NeObjectTypeHandler prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}



	@SuppressWarnings("unchecked")
	@Override
	public void run(NeBranch<?> branch, ByteInflow inflow, NeFunction function) throws IOException {
		String index = inflow.getStringUTF8();
		NeVertex<?> arg = index != null ? branch.getVertex(index) : null;
		T object = (T) arg.getAttachedObject();
		((ObjectNeFunction<T>) function).run(object);
	}
}
