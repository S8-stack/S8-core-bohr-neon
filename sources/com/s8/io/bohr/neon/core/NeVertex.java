package com.s8.io.bohr.neon.core;

import java.io.IOException;

import com.s8.io.bytes.alpha.ByteOutflow;


/**
 * 
 * 
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 *
 */
public interface NeVertex {

	
	/**
	 * 
	 * @return index
	 */
	public String getId();
	
	
	
	public NeBranch getBranch();
	
	
	/**
	 * Object attached to this vertex
	 * @return
	 */
	public NeObject getAttachedObject();


	
	public NeObjectTypeHandler getPrototype();


	public void expose(int slot);




	public void publish(ByteOutflow outflow) throws IOException;
	



	/**
	 * 
	 * @return the vertex fields handling module
	 */
	public NeVertexFields fields();
	

	/**
	 * 
	 * @return the vertex methods handling module
	 */
	public NeVertexMethods methods();
	
	
	/**
	 * 
	 * @return the vertex generators handling module
	 */
	public NeVertexGenerators generators();


}
