package com.s8.io.bohr.neon.core;

import java.util.ArrayList;
import java.util.List;

import com.s8.io.bohr.neon.fields.NeFieldValue;
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
public abstract class NeVertexLayer1 extends NeVertexLayer0 {



	/**
	 * 
	 * @param branch
	 * @param typeName
	 * @param object
	 */
	public NeVertexLayer1(NeBranch branch, String typeName, NeObject object) {
		super(branch, typeName, object);
	}



	@Override
	public boolean getBool8Field(String name) {
		Bool8NeFieldHandler field = prototype.getBool8Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public boolean[] getBool8ArrayField(String name) {
		Bool8ArrayNeFieldHandler field = prototype.getBool8ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int getUInt8Field(String name) {
		UInt8NeFieldHandler field = prototype.getUInt8Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int[] getUInt8ArrayField(String name) {
		UInt8ArrayNeFieldHandler field = prototype.getUInt8ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}



	@Override
	public int getUInt16Field(String name) {
		UInt16NeFieldHandler field = prototype.getUInt16Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int[] getUInt16ArrayField(String name) {
		UInt16ArrayNeFieldHandler field = prototype.getUInt16ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long getUInt32Field(String name) {
		UInt32NeFieldHandler field = prototype.getUInt32Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long[] getUInt32ArrayField(String name) {
		UInt32ArrayNeFieldHandler field = prototype.getUInt32ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long getUInt64Field(String name) {
		UInt64NeFieldHandler field = prototype.getUInt64Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int getInt8Field(String name) {
		Int8NeFieldHandler field = prototype.getInt8Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int getInt16Field(String name) {
		Int16NeFieldHandler field = prototype.getInt16Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int getInt32Field(String name) {
		Int32NeFieldHandler field = prototype.getInt32Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long getInt64Field(String name) {
		Int64NeFieldHandler field = prototype.getInt64Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long[] getInt64ArrayField(String name) {
		Int64ArrayNeFieldHandler field = prototype.getInt64ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public float getFloat32Field(String name) {
		Float32NeFieldHandler field = prototype.getFloat32Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public float[] getFloat32ArrayField(String name) {
		Float32ArrayNeFieldHandler field = prototype.getFloat32ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public double getFloat64Field(String name) {
		Float64NeFieldHandler field = prototype.getFloat64Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public double[] getFloat64ArrayField(String name) {
		Float64ArrayNeFieldHandler field = prototype.getFloat64ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public String getStringUTF8Field(String name) {
		StringUTF8NeFieldHandler field = prototype.getStringUTF8Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}
	

	@Override
	public String[] getStringUTF8ArrayField(String name) {
		StringUTF8ArrayNeFieldHandler field = prototype.getStringUTF8ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}
	

	@Override
	public <T extends NeObject> T getObjectField(String name) {
		ObjNeFieldHandler<T> field = prototype.getObjField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public <T extends NeObject> List<T> getObjectListField(String name) {
		ListNeFieldHandler<T> field = prototype.getObjArrayField(name);
		NeFieldValue entry = getEntry(field);
		List<T> list = field.get(entry);
		List<T> copy = new ArrayList<T>(list.size());
		list.forEach(item -> copy.add(item));
		return copy;
	}




}
