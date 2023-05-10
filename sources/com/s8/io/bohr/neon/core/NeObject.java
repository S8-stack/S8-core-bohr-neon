package com.s8.io.bohr.neon.core;

import com.s8.io.bohr.neon.control.NeController;

public class NeObject<C extends NeController> {


	public final NeVertex<C> vertex;
	
	public final C ctrl;


	public NeObject(NeBranch<C> branch, String typeName) {
		super();
		
		/* create vertex and assign object to it */
		vertex = new NeVertexLayer2<C>(branch, typeName, this);
		
		
		/* create ctrl */
		this.ctrl = branch.ctrl;
	}


}
