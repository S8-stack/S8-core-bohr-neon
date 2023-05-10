package com.s8.io.bohr.neon.functions.primitives;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

public abstract class StringUTF8NeFunction extends NeFunction {

	
	
	public final static long SIGNATURE = BOHR_Types.STRING_UTF8;

	
	@Override
	public long getSignature() { 
		return SIGNATURE; 
	}
	
	
	/**
	 * 
	 * @param arg
	 */
	public abstract void run(Object context, String arg);
}
