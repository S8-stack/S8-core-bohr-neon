package com.s8.io.bohr.neon.demos.repo2;

import com.s8.api.objects.web.S8WebFrontObject;
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




	public void setRotor(AircraftRotor value) { vertex.fields().setObjectField("rotor", value); }

	public AircraftRotor getRotor() { return vertex.fields().getObjectField("rotor"); }


	public void setPitch(double value) { vertex.fields().setFloat64Field("pitch", value); }

	public double getPitch() { return vertex.fields().getFloat64Field("pitch"); }

	
	public void setYaw(double value) { vertex.fields().setFloat64Field("yaw", value); }

	public double getYaw() { return vertex.fields().getFloat64Field("yaw"); }



	/**
	 * 
	 * @param vertices
	 */
	public void setVertexCoordinates(double[] vertices) {
		vertex.fields().setFloat64ArrayField("vertex-coordinates#12", vertices);
	}


}
