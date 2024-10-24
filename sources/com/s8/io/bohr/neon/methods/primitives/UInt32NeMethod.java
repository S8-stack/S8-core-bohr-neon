package com.s8.io.bohr.neon.methods.primitives;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.flow.S8AsyncFlow;
import com.s8.api.web.functions.NeFunction;
import com.s8.api.web.functions.primitives.UInt32NeFunction;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeMethodsBlock;
import com.s8.io.bohr.neon.methods.NeMethod;


/**
 * 
 * @author pierreconvert
 *
 */
public class UInt32NeMethod extends NeMethod {

	public final static long SIGNATURE = BOHR_Types.UINT32;
	
	public @Override long getSignature() { return SIGNATURE; }

	
	public UInt32NeMethod(NeObjectTypeMethodsBlock prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}

	@Override
	public void run(NeBranch branch, S8AsyncFlow flow, ByteInflow inflow, NeFunction function) throws IOException {
		int arg =  inflow.getUInt32();
		((UInt32NeFunction) function).run(flow, arg);
	}
}
