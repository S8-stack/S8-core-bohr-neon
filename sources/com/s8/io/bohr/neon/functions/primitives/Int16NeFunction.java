package com.s8.io.bohr.neon.functions.primitives;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

/**
 * 
 * @author pierreconvert
 *
 */
public interface Int16NeFunction extends NeFunction {
	
	
	
	public final static long SIGNATURE = BOHR_Types.INT16;

	
	@Override
	public default long getSignature() { 
		return SIGNATURE; 
	}
	

	public abstract void run(Object context, int arg);
}