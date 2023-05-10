package com.s8.io.bohr.neon.methods.primitives;

import java.io.IOException;

import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeHandler;
import com.s8.io.bohr.neon.functions.NeFunction;
import com.s8.io.bohr.neon.functions.primitives.UInt16NeFunction;
import com.s8.io.bohr.neon.methods.NeMethodRunner;
import com.s8.io.bytes.alpha.ByteInflow;


/**
 * 
 * @author pierreconvert
 *
 */
public class UInt16NeMethod extends NeMethodRunner {

	public final static long SIGNATURE = BOHR_Types.UINT16;
	
	public @Override long getSignature() { return SIGNATURE; }

	
	public UInt16NeMethod(NeObjectTypeHandler prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}

	@Override
	public void run(NeBranch<?> branch, ByteInflow inflow, NeFunction function) throws IOException {
		int arg =  inflow.getUInt16();
		((UInt16NeFunction) function).run(arg);
	}
}
