package com.s8.io.bohr.neon.core;

import java.io.IOException;
import java.util.List;

import com.s8.io.bohr.atom.BOHR_Keywords;
import com.s8.io.bohr.neon.fields.NeFieldHandler;
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
import com.s8.io.bytes.alpha.ByteOutflow;


/**
 * 
 * 
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 *
 */
public abstract class NeVertexLayer0 implements NeVertex {

	public final NeBranch branch;

	public final NeObject object;

	private boolean hasUnpublishedChanges = false;

	private boolean isCreateUnpublished = false;

	private boolean isExposeUnpublished = false;

	private boolean isUpdateUnpublished = false;


	private int slot;


	NeFieldValue[] values;


	public final NeObjectTypeHandler prototype;


	/**
	 * index
	 */
	private String index;



	/**
	 * 
	 * @param branch
	 */
	public NeVertexLayer0(NeBranch branch, String typeName, NeObject object) {
		super();


		// branch
		this.branch = branch;
		this.prototype = branch.retrieveObjectPrototype(typeName);
		this.object = object;

		values = new NeFieldValue[4];

	}

	@Override
	public NeBranch getBranch() {
		return branch;
	}

	@Override
	public NeObject getAttachedObject() {
		return object;
	}
	
	@Override
	public NeObjectTypeHandler getPrototype() {
		return prototype;
	}


	@Override
	public String getId() {

		if(index == null) {

			index = branch.appendObject(this);

			/* keep track of update required status */
			isCreateUnpublished = true;

			onChange();
		}

		return index;
	}



	@Override
	public void expose(int slot) {

		isExposeUnpublished = true;

		this.slot = slot;

		/* general change notified */
		onChange();
	}




	protected void onUpdate() {

		/* keep track of update required status */
		isUpdateUnpublished = true;

		/* general change notified */
		onChange();
	}


	protected void onChange() {
		if(!hasUnpublishedChanges) {

			/* push toUnpublished */
			branch.outbound.notifyChanged(this);


			/* keep track of unchanged status */
			hasUnpublishedChanges = true;
		}
	}


	@Override
	public void publish(ByteOutflow outflow) throws IOException {

		if(hasUnpublishedChanges) {
			String index = getId();

			/* publish prototype */
			prototype.publish_DECLARE_TYPE(outflow);

			if(isCreateUnpublished) {

				// declare type
				outflow.putUInt8(BOHR_Keywords.CREATE_NODE);

				/* publish type code */
				outflow.putUInt7x(prototype.code);

				/* publish index */
				outflow.putStringUTF8(index);

				prototype.publishFields(values, outflow);

				outflow.putUInt8(BOHR_Keywords.CLOSE_NODE);

				isCreateUnpublished = false;
			}	
			else if(isUpdateUnpublished) {

				// declare type
				outflow.putUInt8(BOHR_Keywords.UPDATE_NODE);

				/* publish index */
				outflow.putStringUTF8(index);

				/* fields */
				prototype.publishFields(values, outflow);

				outflow.putUInt8(BOHR_Keywords.CLOSE_NODE);

				isUpdateUnpublished = false;
			}

			if(isExposeUnpublished) {

				// declare type
				outflow.putUInt8(BOHR_Keywords.EXPOSE_NODE);

				/* publish index */
				outflow.putStringUTF8(index);

				/* fields */
				outflow.putUInt8(slot);

				isExposeUnpublished = false;
			}

			hasUnpublishedChanges = false;
		}
	}



	protected NeFieldValue getEntry(NeFieldHandler field) {
		int ordinal= field.ordinal;
		NeFieldValue value;
		if(field.ordinal < values.length) {
			if((value = values[ordinal]) != null) {
				return value;
			}
			else {
				return (values[ordinal] = field.createValue());
			}
		}
		else {
			// increase values size
			int n = values.length, m = n >= 2 ? n : 2;
			while(m <= field.ordinal) { m*=2; }
			NeFieldValue[] extendedValues = new NeFieldValue[m];
			for(int i = 0; i < n; i++) { extendedValues[i] = values[i]; }
			values = extendedValues;

			return (values[ordinal] = field.createValue());
		}
	}




	@Override
	public void setBool8Field(String name, boolean value) {
		Bool8NeFieldHandler field = prototype.getBool8Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}






	@Override
	public void setBool8ArrayField(String name, boolean[] value) {
		Bool8ArrayNeFieldHandler field = prototype.getBool8ArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}





	@Override
	public void setUInt8Field(String name, int value) {
		UInt8NeFieldHandler field = prototype.getUInt8Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}




	@Override
	public void setUInt8ArrayField(String name, int[] value) {
		UInt8ArrayNeFieldHandler field = prototype.getUInt8ArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}




	@Override
	public void setUInt16Field(String name, int value) {
		UInt16NeFieldHandler field = prototype.getUInt16Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}




	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt16ArrayField(String name, int[] value) {
		UInt16ArrayNeFieldHandler field = prototype.getUInt16ArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}




	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt32Field(String name, long value) {
		UInt32NeFieldHandler field = prototype.getUInt32Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}






	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt32ArrayField(String name, long[] value) {
		UInt32ArrayNeFieldHandler field = prototype.getUInt32ArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}



	@Override
	public void setUInt64Field(String name, long value) {
		UInt64NeFieldHandler field = prototype.getUInt64Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}






	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setInt8Field(String name, int value) {
		Int8NeFieldHandler field = prototype.getInt8Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}



	@Override
	public void setInt16Field(String name, int value) {
		Int16NeFieldHandler field = prototype.getInt16Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}






	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setInt32Field(String name, int value) {
		Int32NeFieldHandler field = prototype.getInt32Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}




	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setInt64Field(String name, long value) {
		Int64NeFieldHandler field = prototype.getInt64Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}





	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setInt64ArrayField(String name, long[] value) {
		Int64ArrayNeFieldHandler field = prototype.getInt64ArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}




	@Override
	public void setFloat32Field(String name, float value) {
		Float32NeFieldHandler field = prototype.getFloat32Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}


	@Override
	public void setFloat32ArrayField(String name, float[] value) {
		Float32ArrayNeFieldHandler field = prototype.getFloat32ArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}



	@Override
	public void setFloat64Field(String name, double value) {
		Float64NeFieldHandler field = prototype.getFloat64Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}


	@Override
	public void setFloat64ArrayField(String name, double[] value) {
		Float64ArrayNeFieldHandler field = prototype.getFloat64ArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}



	@Override
	public void setStringUTF8Field(String name, String value) {
		StringUTF8NeFieldHandler field = prototype.getStringUTF8Field(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}



	@Override
	public void setStringUTF8ArrayField(String name, String[] value) {
		StringUTF8ArrayNeFieldHandler field = prototype.getStringUTF8ArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}


	@Override
	public <T extends NeObject> void setObjectField(String name, T value) {
		ObjNeFieldHandler<T> field = prototype.getObjField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}





	@Override
	public <T extends NeObject> void setObjectListField(String name, List<T> value) {
		ListNeFieldHandler<T> field = prototype.getObjArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.set(entry, value);
		onUpdate();
	}



	

	@Override
	public <T extends NeObject> void addObjToList(String name, T obj) {
		ListNeFieldHandler<T> field = prototype.getObjArrayField(name);
		NeFieldValue entry = getEntry(field);
		field.add(entry, obj);
		onUpdate();
	}



	@Override
	public <T extends NeObject> void removeObjFromList(String name, T obj) {
		if(obj != null) {
			ListNeFieldHandler<T> field = prototype.getObjArrayField(name);
			NeFieldValue entry = getEntry(field);
			field.remove(entry, obj.vertex.getId());
			onUpdate();
		}
	}



}
