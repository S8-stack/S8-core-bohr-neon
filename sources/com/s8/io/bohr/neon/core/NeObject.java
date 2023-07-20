package com.s8.io.bohr.neon.core;

public class NeObject {


	public final NeVertex vertex;
	
	//public final NeSyncFuncGenerator sync;


	public NeObject(NeBranch branch, String typeName) {
		super();
		
		/* create vertex and assign object to it */
		vertex = new NeVertex0(branch, typeName, this);

	}


}
