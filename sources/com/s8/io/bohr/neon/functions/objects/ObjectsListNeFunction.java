package com.s8.io.bohr.neon.functions.objects;

import java.util.List;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.control.NeController;
import com.s8.io.bohr.neon.core.NeObject;
import com.s8.io.bohr.neon.functions.NeFunction;



public abstract class ObjectsListNeFunction<T extends NeObject<? extends NeController>> extends NeFunction {
	
	
	public final static long SIGNATURE = (BOHR_Types.ARRAY << 8) & BOHR_Types.S8OBJECT;

	public @Override long getSignature() { return SIGNATURE; }
	
	
	public abstract void run(List<T> arg);
	
}
