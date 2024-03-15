package com.s8.io.bohr.neon.methods.objects;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.flow.S8AsyncFlow;
import com.s8.api.web.S8WebObject;
import com.s8.api.web.S8WebVertex;
import com.s8.api.web.functions.NeFunction;
import com.s8.api.web.functions.objects.ObjectNeFunction;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeMethods;
import com.s8.io.bohr.neon.methods.NeMethod;

/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class ObjectNeMethod<T extends S8WebObject> extends NeMethod {




	public final static long SIGNATURE = BOHR_Types.S8OBJECT;

	public @Override long getSignature() { return SIGNATURE; }


	/**
	 * 
	 * @param prototype
	 * @param name
	 */
	public ObjectNeMethod(NeObjectTypeMethods prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}



	@SuppressWarnings("unchecked")
	@Override
	public void run(NeBranch branch, S8AsyncFlow flow, ByteInflow inflow, NeFunction function) throws IOException {
		String index = inflow.getStringUTF8();
		S8WebVertex arg = index != null ? branch.getVertex(index) : null;
		T object = (T) arg.getAttachedObject();
		((ObjectNeFunction<T>) function).run(flow, object);
	}
}
