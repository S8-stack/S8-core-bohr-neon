package com.s8.io.bohr.neon.functions.arrays;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

public abstract class Bool8ArrayNeFunction extends NeFunction {
	


	public final static long SIGNATURE = (BOHR_Types.ARRAY << 8) & BOHR_Types.BOOL8;

	public @Override long getSignature() { return SIGNATURE; }
	
	
	public abstract void operate(Object context, boolean[] arg);

}
