package com.s8.io.bohr.neon.core;

import java.util.ArrayList;
import java.util.List;

import com.s8.io.bohr.neon.control.NeController;
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
public abstract class NeVertexLayer1<C extends NeController> extends NeVertexLayer0<C> {



	/**
	 * 
	 * @param branch
	 * @param typeName
	 * @param object
	 */
	public NeVertexLayer1(NeBranch<C> branch, String typeName, NeObject<C> object) {
		super(branch, typeName, object);
	}



	@Override
	public boolean getBool8(String name) {
		Bool8NeFieldHandler field = prototype.getBool8Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public boolean[] getBool8Array(String name) {
		Bool8ArrayNeFieldHandler field = prototype.getBool8ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int getUInt8(String name) {
		UInt8NeFieldHandler field = prototype.getUInt8Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int[] getUInt8Array(String name) {
		UInt8ArrayNeFieldHandler field = prototype.getUInt8ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}



	@Override
	public int getUInt16(String name) {
		UInt16NeFieldHandler field = prototype.getUInt16Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int[] getUInt16Array(String name) {
		UInt16ArrayNeFieldHandler field = prototype.getUInt16ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long getUInt32(String name) {
		UInt32NeFieldHandler field = prototype.getUInt32Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long[] getUInt32Array(String name) {
		UInt32ArrayNeFieldHandler field = prototype.getUInt32ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long getUInt64(String name) {
		UInt64NeFieldHandler field = prototype.getUInt64Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int getInt8(String name) {
		Int8NeFieldHandler field = prototype.getInt8Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int getInt16(String name) {
		Int16NeFieldHandler field = prototype.getInt16Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public int getInt32(String name) {
		Int32NeFieldHandler field = prototype.getInt32Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long getInt64(String name) {
		Int64NeFieldHandler field = prototype.getInt64Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public long[] getInt64Array(String name) {
		Int64ArrayNeFieldHandler field = prototype.getInt64ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public float getFloat32(String name) {
		Float32NeFieldHandler field = prototype.getFloat32Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public float[] getFloat32Array(String name) {
		Float32ArrayNeFieldHandler field = prototype.getFloat32ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public double getFloat64(String name) {
		Float64NeFieldHandler field = prototype.getFloat64Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public double[] getFloat64Array(String name) {
		Float64ArrayNeFieldHandler field = prototype.getFloat64ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public String getStringUTF8(String name) {
		StringUTF8NeFieldHandler field = prototype.getStringUTF8Field(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}
	

	@Override
	public String[] getStringUTF8Array(String name) {
		StringUTF8ArrayNeFieldHandler field = prototype.getStringUTF8ArrayField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}
	

	@Override
	public <T extends NeObject<C>> T getObj(String name) {
		ObjNeFieldHandler<T> field = prototype.getObjField(name);
		NeFieldValue entry = getEntry(field);
		return field.get(entry);
	}


	@Override
	public <T extends NeObject<C>> List<T> getObjList(String name) {
		ListNeFieldHandler<T> field = prototype.getObjArrayField(name);
		NeFieldValue entry = getEntry(field);
		List<T> list = field.get(entry);
		List<T> copy = new ArrayList<T>(list.size());
		list.forEach(item -> copy.add(item));
		return copy;
	}




}
