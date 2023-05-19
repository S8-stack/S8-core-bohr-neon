package com.s8.io.bohr.neon.functions.objects;

import java.util.List;

import com.s8.arch.fluor.S8AsyncFlow;
import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeObject;
import com.s8.io.bohr.neon.functions.NeFunction;


@FunctionalInterface
public interface ObjectsListNeFunction<T extends NeObject> extends NeFunction {
	
	
	public final static long SIGNATURE = (BOHR_Types.ARRAY << 8) & BOHR_Types.S8OBJECT;

	public @Override default long getSignature() { return SIGNATURE; }
	
	
	public abstract void run(S8AsyncFlow flow, List<T> arg);
	
}
