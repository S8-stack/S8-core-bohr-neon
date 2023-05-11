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
public class TestNeObject extends NeObject {


	public TestNeObject(NeBranch branch) {
		super(branch, "Test-object");
	}




	public void setRotor(AircraftRotor value) { vertex.setObjectField("rotor", value); }

	public AircraftRotor getRotor() { return vertex.getObjectField("rotor"); }


	public void setPitch(double value) { vertex.setFloat64Field("pitch", value); }

	public double getPitch() { return vertex.getFloat64Field("pitch"); }

	
	public void setYaw(double value) { vertex.setFloat64Field("yaw", value); }

	public double getYaw() { return vertex.getFloat64Field("yaw"); }



	/**
	 * 
	 * @param vertices
	 */
	public void setVertexCoordinates(double[] vertices) {
		vertex.setFloat64ArrayField("vertex-coordinates#12", vertices);
	}


}
