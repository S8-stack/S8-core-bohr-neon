package com.s8.io.bohr.neon.functions.none;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

public abstract class VoidNeFunction extends NeFunction {

	
	
	public final static long SIGNATURE = BOHR_Types.BOOL8;

	
	@Override
	public long getSignature() { 
		return SIGNATURE; 
	}
	


	/**
	 * 
	 */
	public abstract void run();



}
