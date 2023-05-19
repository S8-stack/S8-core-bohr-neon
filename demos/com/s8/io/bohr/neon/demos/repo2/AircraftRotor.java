package com.s8.io.bohr.neon.demos.repo2;

import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObject;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class AircraftRotor extends NeObject {



	public AircraftRotor(NeBranch branch) {
		super(branch, "Aircraft-rotor");
		
		vertex.setFloat32Method("pitch", (flow, p) -> flow.then(0, ()-> {
			vertex.setFloat64Field("pitch^2", p*p);
			vertex.setFloat64Field("pitch*radius", p*vertex.getFloat64Field("radius"));
		}).send());
		
	}



	/**
	 * 
	 * @param value
	 */
	public void setPitch(double value) { vertex.setFloat64Field("pitch", value); }
	
	


	/**
	 * 
	 * @return pitch
	 */
	public double getPitch() { return vertex.getFloat64Field("pitch"); }
	
	
	
}
