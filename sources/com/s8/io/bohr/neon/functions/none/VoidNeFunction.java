package com.s8.io.bohr.neon.functions.none;

import com.s8.arch.fluor.S8AsyncFlow;
import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

public interface VoidNeFunction extends NeFunction {

	
	
	public final static long SIGNATURE = BOHR_Types.VOID;

	
	@Override
	public default long getSignature() { 
		return SIGNATURE; 
	}
	


	/**
	 * 
	 */
	public abstract void run(S8AsyncFlow flow);



}
