package com.s8.io.bohr.neon.functions.primitives;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

public interface Bool8NeFunction extends NeFunction {
	
	
	public final static long SIGNATURE = BOHR_Types.BOOL8;

	
	
	public @Override default long getSignature() { return SIGNATURE; }
	
	
	public abstract void run(Object context, boolean arg);

}
