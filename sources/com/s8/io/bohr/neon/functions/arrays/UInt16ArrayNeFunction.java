package com.s8.io.bohr.neon.functions.arrays;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

/**
 * 
 * @author pierreconvert
 *
 */
public abstract class UInt16ArrayNeFunction extends NeFunction {

	
	public final static long SIGNATURE = (BOHR_Types.ARRAY << 8) & BOHR_Types.UINT16;

	public @Override long getSignature() { return SIGNATURE; }
	
	/**
	 * 
	 * @param arg
	 */
	public abstract void run(Object context, int[] arg);
}
