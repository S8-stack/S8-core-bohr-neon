package com.s8.io.bohr.neon.generators;

import java.io.IOException;

@FunctionalInterface
public interface NeGenerator {

	/**
	 * Generate a resource
	 * 
	 * @return
	 */
	public NeGeneratedResource generate() throws IOException;
	
	
}
