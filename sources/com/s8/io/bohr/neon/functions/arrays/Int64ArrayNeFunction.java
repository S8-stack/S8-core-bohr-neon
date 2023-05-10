package com.s8.io.bohr.neon.functions.arrays;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

public abstract class Int64ArrayNeFunction extends NeFunction {
	
	
	public final static long SIGNATURE = (BOHR_Types.ARRAY << 8) & BOHR_Types.INT64;

	public @Override long getSignature() { return SIGNATURE; }

	public abstract void operate(long[] arg);
}
