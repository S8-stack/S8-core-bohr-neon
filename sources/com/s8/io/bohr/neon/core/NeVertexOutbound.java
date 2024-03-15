package com.s8.io.bohr.neon.core;

import java.util.ArrayList;
import java.util.List;

import com.s8.api.web.S8WebObject;
import com.s8.api.web.S8WebVertexOutbound;
import com.s8.io.bohr.neon.fields.NeFieldUpdate;
import com.s8.io.bohr.neon.fields.arrays.Bool8ArrayNeFieldHandler;
import com.s8.io.bohr.neon.fields.arrays.Float32ArrayNeFieldHandler;
import com.s8.io.bohr.neon.fields.arrays.Float64ArrayNeFieldHandler;
import com.s8.io.bohr.neon.fields.arrays.Int64ArrayNeFieldHandler;
import com.s8.io.bohr.neon.fields.arrays.StringUTF8ArrayNeFieldHandler;
import com.s8.io.bohr.neon.fields.arrays.UInt16ArrayNeFieldHandler;
import com.s8.io.bohr.neon.fields.arrays.UInt32ArrayNeFieldHandler;
import com.s8.io.bohr.neon.fields.arrays.UInt8ArrayNeFieldHandler;
import com.s8.io.bohr.neon.fields.objects.ListNeFieldHandler;
import com.s8.io.bohr.neon.fields.objects.ObjNeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.Bool8NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.Float32NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.Float64NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.Int16NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.Int32NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.Int64NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.Int8NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.StringUTF8NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.UInt16NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.UInt32NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.UInt64NeFieldHandler;
import com.s8.io.bohr.neon.fields.primitives.UInt8NeFieldHandler;


/**
 * 
 * 
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 *
 */
public class NeVertexOutbound implements S8WebVertexOutbound {

	public final NeVertex vertex;

	public final NeObjectTypeFields prototype;
	
	private NeFieldUpdate[] updates;
	
	private int position;

	/**
	 * 
	 * @param branch
	 */
	public NeVertexOutbound(NeVertex vertex, NeObjectTypeFields prototype) {
		super();


		// branch
		this.vertex = vertex;
		this.prototype = prototype;
		
		this.updates = new NeFieldUpdate[4];
		this.position = 0;

	}



	protected void pushUpdate(NeFieldUpdate update) {
		if(position >= updates.length) {
			// increase values size
			int n = updates.length, m = n >= 2 ? n : 2;
			while(m <= position) { m*=2; }
			NeFieldUpdate[] extendedArray = new NeFieldUpdate[m];
			for(int i = 0; i < n; i++) { extendedArray[i] = updates[i]; }
			updates = extendedArray;
		}
		updates[position++] = update;
	}
	
	
	
	/**
	 * Retreive and clear updates
	 * @return
	 */
	protected NeFieldUpdate[] pullUpdates() {
		NeFieldUpdate[] stack = updates;
		
		/* clear updates */
		this.updates = new NeFieldUpdate[4];
		this.position = 0;
		
		return stack;
	}


	

	/* <setters> */


	@Override
	public void setBool8Field(String name, boolean value) {
		Bool8NeFieldHandler field = prototype.getBool8Field(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setBool8ArrayField(String name, boolean[] value) {
		Bool8ArrayNeFieldHandler field = prototype.getBool8ArrayField(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setUInt8Field(String name, int value) {
		UInt8NeFieldHandler field = prototype.getUInt8Field(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}

	
	@Override
	public void setUInt8ArrayField(String name, int[] value) {
		UInt8ArrayNeFieldHandler field = prototype.getUInt8ArrayField(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setUInt16Field(String name, int value) {
		UInt16NeFieldHandler field = prototype.getUInt16Field(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setUInt16ArrayField(String name, int[] value) {
		UInt16ArrayNeFieldHandler field = prototype.getUInt16ArrayField(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setUInt32Field(String name, long value) {
		UInt32NeFieldHandler field = prototype.getUInt32Field(name);
		pushUpdate(field.createValue(value));
		vertex.onUpdate();
	}


	@Override
	public void setUInt32ArrayField(String name, long[] value) {
		UInt32ArrayNeFieldHandler field = prototype.getUInt32ArrayField(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setUInt64Field(String name, long value) {
		UInt64NeFieldHandler field = prototype.getUInt64Field(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setInt8Field(String name, int value) {
		Int8NeFieldHandler field = prototype.getInt8Field(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setInt16Field(String name, int value) {
		Int16NeFieldHandler field = prototype.getInt16Field(name);
		pushUpdate(field.createValue(value));
		vertex.onUpdate();
	}


	
	@Override
	public void setInt32Field(String name, int value) {
		Int32NeFieldHandler field = prototype.getInt32Field(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setInt64Field(String name, long value) {
		Int64NeFieldHandler field = prototype.getInt64Field(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setInt64ArrayField(String name, long[] value) {
		Int64ArrayNeFieldHandler field = prototype.getInt64ArrayField(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setFloat32Field(String name, float value) {
		Float32NeFieldHandler field = prototype.getFloat32Field(name);
		pushUpdate(field.createValue(value));
		vertex.onUpdate();
	}


	@Override
	public void setFloat32ArrayField(String name, float[] value) {
		Float32ArrayNeFieldHandler field = prototype.getFloat32ArrayField(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setFloat64Field(String name, double value) {
		Float64NeFieldHandler field = prototype.getFloat64Field(name);
		pushUpdate(field.createValue(value));
		vertex.onUpdate();
	}


	@Override
	public void setFloat64ArrayField(String name, double[] value) {
		Float64ArrayNeFieldHandler field = prototype.getFloat64ArrayField(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setStringUTF8Field(String name, String value) {
		StringUTF8NeFieldHandler field = prototype.getStringUTF8Field(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public void setStringUTF8ArrayField(String name, String[] value) {
		StringUTF8ArrayNeFieldHandler field = prototype.getStringUTF8ArrayField(name);
		pushUpdate(field.createValue(value));
		vertex.onUpdate();
	}


	@Override
	public <T extends S8WebObject> void setObjectField(String name, T value) {
		ObjNeFieldHandler<T> field = prototype.getObjField(name);
		pushUpdate(field.createValue(value));
		 vertex.onUpdate();
	}


	@Override
	public <T extends S8WebObject> void setObjectListField(String name, List<T> value) {
		ListNeFieldHandler<T> field = prototype.getObjArrayField(name);
		pushUpdate(field.createUpdate(value));
		vertex.onUpdate();
	}


	@Override
	public <T extends S8WebObject> void setObjectListField(String name, T[] value) {
		/*  transform array into list */
		int n = value.length;
		List<T> list = new ArrayList<>();
		for(int i = 0; i<n; i++) { list.add(value[i]); }
		
		setObjectListField(name, list);
	}
	
	
	@Override
	public <T extends S8WebObject> void setObjectListField(String name, T singleValue) {
		/*  transform array into list */
		List<T> list = new ArrayList<>();
		list.add(singleValue);
		
		setObjectListField(name, list);
	}
	
	
	/* </setters> */

	

}
