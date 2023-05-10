package com.s8.io.bohr.neon.demos.repo2;

import com.s8.io.bohr.neon.control.NeController;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObject;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class AircraftRotor extends NeObject<NeController> {



	public AircraftRotor(NeBranch<NeController> branch) {
		super(branch, "Aircraft-rotor");
		
		vertex.setFloat32Method("pitch", ctrl.createFloat32Func(p -> {
			vertex.setFloat64("pitch^2", p*p);
			vertex.setFloat64("pitch*radius", p*vertex.getFloat64("radius"));
		}));
	}



	/**
	 * 
	 * @param value
	 */
	public void setPitch(double value) { vertex.setFloat64("pitch", value); }
	
	


	/**
	 * 
	 * @return pitch
	 */
	public double getPitch() { return vertex.getFloat64("pitch"); }
	
	
	
}
