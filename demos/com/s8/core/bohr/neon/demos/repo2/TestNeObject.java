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
public class TestNeObject extends S8WebFrontObject {


	public TestNeObject(NeBranch branch) {
		super(branch, "Test-object");
	}




	public void setRotor(AircraftRotor value) { vertex.outbound().setObjectField("rotor", value); }



	public void setPitch(double value) { vertex.outbound().setFloat64Field("pitch", value); }


	
	public void setYaw(double value) { vertex.outbound().setFloat64Field("yaw", value); }




	/**
	 * 
	 * @param vertices
	 */
	public void setVertexCoordinates(double[] vertices) {
		vertex.outbound().setFloat64ArrayField("vertex-coordinates#12", vertices);
	}


}
