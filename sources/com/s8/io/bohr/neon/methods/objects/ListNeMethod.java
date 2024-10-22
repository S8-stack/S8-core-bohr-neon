package com.s8.io.bohr.neon.methods.objects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.flow.S8AsyncFlow;
import com.s8.api.web.S8WebObject;
import com.s8.api.web.functions.NeFunction;
import com.s8.api.web.functions.objects.ObjectsListNeFunction;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeMethodsBlock;
import com.s8.io.bohr.neon.methods.NeMethod;

/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class ListNeMethod<T extends S8WebObject> extends NeMethod {





	public final static long SIGNATURE = (BOHR_Types.ARRAY << 8) & BOHR_Types.S8OBJECT;

	public @Override long getSignature() { return SIGNATURE; }


	/**
	 * 
	 * @param prototype
	 * @param name
	 */
	public ListNeMethod(NeObjectTypeMethodsBlock prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}



	@SuppressWarnings("unchecked")
	@Override
	public void run(NeBranch branch, S8AsyncFlow flow, ByteInflow inflow, NeFunction function) throws IOException {
		List<T> list = null;
		int length = (int) inflow.getUInt7x();
		if(length >= 0) {
			list =  new ArrayList<T>();
			for(int i=0; i<length; i++) {
				String index = inflow.getStringUTF8();
				list.add(index != null ? (T) branch.getObject(index) : null);
			}	
		}
		((ObjectsListNeFunction<T>) function).run(flow, list);	
	}
}
