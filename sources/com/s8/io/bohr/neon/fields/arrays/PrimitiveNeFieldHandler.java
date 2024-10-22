package com.s8.io.bohr.neon.fields.arrays;

import com.s8.io.bohr.neon.core.NeObjectTypeFieldsBlock;
import com.s8.io.bohr.neon.fields.NeFieldHandler;
import com.s8.io.bohr.neon.fields.NeFieldUpdate;

/**
 * 
 *
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public abstract class PrimitiveNeFieldHandler extends NeFieldHandler {

	
	/**
	 * 
	 * @param prototype
	 * @param name
	 */
	public PrimitiveNeFieldHandler(NeObjectTypeFieldsBlock prototype, String name) {
		super(prototype, name);
	}
	
	
	
	public static abstract class Update extends NeFieldUpdate {
		public Update() {
			super();
		}
	}
	
	
}
