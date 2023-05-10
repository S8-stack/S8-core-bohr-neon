package com.s8.io.bohr.neon.functions.objects;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeObject;
import com.s8.io.bohr.neon.functions.NeFunction;

/**
 * 
 * @author pierreconvert
 *
 */
public abstract class ObjectNeFunction<T extends NeObject> extends NeFunction {

	
	
	public final static long SIGNATURE = BOHR_Types.S8OBJECT;

	
	@Override
	public long getSignature() { 
		return SIGNATURE; 
	}
	
	
	/**
	 * 
	 * @param arg
	 */
	public abstract void run(Object context, T arg);
	
	
}
