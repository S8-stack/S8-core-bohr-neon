package com.s8.io.bohr.neon.functions.primitives;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

/**
 * 
 * @author pierreconvert
 *
 */
public interface UInt64NeFunction extends NeFunction {

	
	
	public final static long SIGNATURE = BOHR_Types.UINT64;

	
	@Override
	public default long getSignature() { 
		return SIGNATURE; 
	}
	
	

	/**
	 * 
	 * @param arg
	 */
	public abstract void run(Object context, long arg);
	
}

