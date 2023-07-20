package com.s8.io.bohr.neon.core;

import com.s8.arch.fluor.delivery.S8WebResourceGenerator;

public interface NeVertexProviders {



	/**
	 * 
	 * @param ordinal
	 * @return
	 */
	public S8WebResourceGenerator getGenerator(int ordinal);
	

	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setRawProvider(String name, S8WebResourceGenerator generator);

	
}
