package com.s8.io.bohr.neon.methods.primitives;

import java.io.IOException;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeHandler;
import com.s8.io.bohr.neon.functions.NeFunction;
import com.s8.io.bohr.neon.functions.primitives.Int32NeFunction;
import com.s8.io.bohr.neon.methods.NeMethod;
import com.s8.io.bytes.alpha.ByteInflow;


/**
 * 
 * @author pierreconvert
 *
 */
public class Int32NeMethod extends NeMethod {

	public final static long SIGNATURE = BOHR_Types.INT32;
	
	public @Override long getSignature() { return SIGNATURE; }

	
	public Int32NeMethod(NeObjectTypeHandler prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}

	
	@Override
	public void run(NeBranch branch, Object context, ByteInflow inflow, NeFunction lambda) throws IOException {
		int arg =  inflow.getInt32();
		((Int32NeFunction) lambda).run(context, arg);
	}
}
