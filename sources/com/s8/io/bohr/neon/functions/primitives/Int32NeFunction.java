package com.s8.io.bohr.neon.functions.primitives;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

public abstract class Int32NeFunction extends NeFunction {
	
	
	
	public final static long SIGNATURE = BOHR_Types.INT32;

	
	@Override
	public long getSignature() { 
		return SIGNATURE; 
	}
	

	public abstract void run(Object context, int arg);
}
