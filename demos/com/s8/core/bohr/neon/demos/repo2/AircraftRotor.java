package com.s8.core.bohr.neon.demos.repo2;

import com.s8.api.web.S8WebObject;
import com.s8.io.bohr.neon.core.NeBranch;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class AircraftRotor extends S8WebObject {



	public AircraftRotor(NeBranch branch) {
		super(branch, "Aircraft-rotor");

		vertex.inbound().setFloat32Method("pitch", (flow, p) -> {
			flow.runBlock(0, ()-> {
				vertex.outbound().setFloat64Field("pitch^2", p*p);
				//vertex.outbound().setFloat64Field("pitch*radius", p * vertex.outbound().getFloat64Field("radius"));
			});
			flow.send();
		});

	}



	/**
	 * 
	 * @param value
	 */
	public void setPitch(double value) { vertex.outbound().setFloat64Field("pitch", value); }





}
