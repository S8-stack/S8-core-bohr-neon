package com.s8.io.bohr.neon.methods.primitives;

import java.io.IOException;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObject;
import com.s8.io.bohr.neon.core.NeObjectTypeHandler;
import com.s8.io.bohr.neon.methods.NeMethodRunner;
import com.s8.io.bytes.alpha.ByteInflow;



/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class StringUTF8NeMethodRunner extends NeMethodRunner {


	public interface Lambda {

		public void operate(String arg);

	}


	public final static long SIGNATURE = BOHR_Types.STRING_UTF8;

	public @Override long getSignature() { return SIGNATURE; }


	/**
	 * 
	 * @param prototype
	 * @param name
	 */
	public StringUTF8NeMethodRunner(NeObjectTypeHandler prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}


	@Override
	public void run(NeBranch branch, ByteInflow inflow, Object lambda) throws IOException {
		String arg = inflow.getStringUTF8();
		((NeObject.StringUTF8Lambda) lambda).operate(arg);
	}

}