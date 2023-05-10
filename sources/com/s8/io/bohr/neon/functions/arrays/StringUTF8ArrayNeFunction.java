package com.s8.io.bohr.neon.functions.arrays;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

/**
 * 
 * @author pierreconvert
 *
 */
public abstract class StringUTF8ArrayNeFunction extends NeFunction {

	
	public final static long SIGNATURE = (BOHR_Types.ARRAY << 8) & BOHR_Types.STRING_UTF8;

	public @Override long getSignature() { return SIGNATURE; }
	
	public abstract void run(Object context, String[] arg);
	
}
