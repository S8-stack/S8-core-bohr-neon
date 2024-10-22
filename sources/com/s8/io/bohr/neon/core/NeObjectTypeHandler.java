package com.s8.io.bohr.neon.core;

import java.io.IOException;

import com.s8.api.bytes.ByteOutflow;
import com.s8.core.bohr.atom.protocol.BOHR_Keywords;



/**
 * 
 * 
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 *
 */
public class NeObjectTypeHandler {


	/**
	 * The name associated to this object type
	 */
	public final String outboundTypeName;

	public final long code;

	private boolean isUnpublished;


	/* fields */
	public final NeObjectTypeFieldsBlock fields;

	/* methods */
	public final NeObjectTypeMethodsBlock methods;
	
	/* providers */
	public final NeObjectTypeProvidersBlock providers;



	public NeObjectTypeHandler(String name, long code) {
		super();
		this.outboundTypeName = name;
		this.code = code;

		/* fields */
		this.fields = new NeObjectTypeFieldsBlock(this);

		/* methods */
		this.methods = new NeObjectTypeMethodsBlock(this);
		
		/* providers */
		this.providers = new NeObjectTypeProvidersBlock(this);

		isUnpublished = true;
	}




	public final static String RUNTIME_MODFICATION_ERROR_MESSAGE = "Prototype can only be edited at compile time";



	public String getName() {
		return outboundTypeName;
	}



	/**
	 * 
	 * @param outflow
	 * @throws IOException
	 */
	public void publish_DECLARE_TYPE(ByteOutflow outflow) throws IOException {

		if(isUnpublished) {

			// declare type
			outflow.putUInt8(BOHR_Keywords.DECLARE_TYPE);

			/* publish name */
			outflow.putStringUTF8(outboundTypeName);

			/* publish code */
			outflow.putUInt7x(code);

			isUnpublished = false;
		}
	}


}
