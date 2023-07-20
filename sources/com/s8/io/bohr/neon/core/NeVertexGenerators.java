package com.s8.io.bohr.neon.core;

import com.s8.io.bohr.neon.generators.NeGenerator;

public interface NeVertexGenerators {



	/**
	 * 
	 * @param ordinal
	 * @return
	 */
	public NeGenerator getGenerator(int ordinal);
	

	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setGenerator(String name, NeGenerator generator);

	
}
