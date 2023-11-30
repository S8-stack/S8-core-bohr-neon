package com.s8.core.bohr.neon.demos.repo2;

import com.s8.api.web.S8WebFrontObject;
import com.s8.io.bohr.neon.core.NeBranch;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class AircraftRotor extends S8WebFrontObject {



	public AircraftRotor(NeBranch branch) {
		super(branch, "Aircraft-rotor");
		
		vertex.methods().setFloat32Method("pitch", (flow, p) -> flow.runBlock(0, ()-> {
			vertex.fields().setFloat64Field("pitch^2", p*p);
			vertex.fields().setFloat64Field("pitch*radius", p * vertex.fields().getFloat64Field("radius"));
		}).send());
		
	}



	/**
	 * 
	 * @param value
	 */
	public void setPitch(double value) { vertex.fields().setFloat64Field("pitch", value); }
	
	


	/**
	 * 
	 * @return pitch
	 */
	public double getPitch() { return vertex.fields().getFloat64Field("pitch"); }
	
	
	
}
