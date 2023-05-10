package com.s8.io.bohr.neon.methods.primitives;

import java.io.IOException;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeHandler;
import com.s8.io.bohr.neon.functions.NeFunction;
import com.s8.io.bohr.neon.functions.primitives.UInt8NeFunction;
import com.s8.io.bohr.neon.methods.NeMethod;
import com.s8.io.bytes.alpha.ByteInflow;


/**
 * 
 * @author pierreconvert
 *
 */
public class UInt8NeMethod extends NeMethod {

	public final static long SIGNATURE = BOHR_Types.UINT8;
	
	public @Override long getSignature() { return SIGNATURE; }

	
	public UInt8NeMethod(NeObjectTypeHandler prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}

	@Override
	public void run(NeBranch branch, Object context, ByteInflow inflow, NeFunction function) throws IOException {
		int arg =  inflow.getUInt8();
		((UInt8NeFunction) function).run(context, arg);
	}
}
