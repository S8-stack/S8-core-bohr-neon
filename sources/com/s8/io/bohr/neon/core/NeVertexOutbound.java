package com.s8.io.bohr.neon.core;

import java.util.ArrayList;
import java.util.List;

import com.s8.api.serial.S8SerialPrototype;
import com.s8.api.serial.S8Serializable;
import com.s8.api.web.S8WebObject;
import com.s8.api.web.S8WebVertexOutbound;
import com.s8.io.bohr.neon.NeException;
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
import com.s8.io.bohr.neon.fields.objects.SerializableArrayNeFieldHandler;
import com.s8.io.bohr.neon.fields.objects.SerializableNeFieldHandler;
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

	public final NeObjectTypeFieldsBlock prototype;

	private NeFieldUpdate[] updates;

	private int position;

	/**
	 * 
	 * @param branch
	 */
	public NeVertexOutbound(NeVertex vertex, NeObjectTypeFieldsBlock prototype) {
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
		try {
			Bool8NeFieldHandler field = prototype.getBool8Field(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setBool8ArrayField(String name, boolean[] value) {
		try {
			Bool8ArrayNeFieldHandler field = prototype.getBool8ArrayField(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setUInt8Field(String name, int value) {
		try {
			UInt8NeFieldHandler field = prototype.getUInt8Field(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setUInt8ArrayField(String name, int[] value) {
		try {
			UInt8ArrayNeFieldHandler field = prototype.getUInt8ArrayField(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setUInt16Field(String name, int value) {
		try {

			UInt16NeFieldHandler field = prototype.getUInt16Field(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setUInt16ArrayField(String name, int[] value) {
		try {

			UInt16ArrayNeFieldHandler field = prototype.getUInt16ArrayField(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setUInt32Field(String name, long value) {
		try {

			UInt32NeFieldHandler field = prototype.getUInt32Field(name);
			pushUpdate(field.createValue(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setUInt32ArrayField(String name, long[] value) {
		try {

			UInt32ArrayNeFieldHandler field = prototype.getUInt32ArrayField(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setUInt64Field(String name, long value) {
		try {

			UInt64NeFieldHandler field = prototype.getUInt64Field(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setInt8Field(String name, int value) {
		try {

			Int8NeFieldHandler field = prototype.getInt8Field(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setInt16Field(String name, int value) {
		try {

			Int16NeFieldHandler field = prototype.getInt16Field(name);
			pushUpdate(field.createValue(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void setInt32Field(String name, int value) {
		try {	

			Int32NeFieldHandler field = prototype.getInt32Field(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setInt64Field(String name, long value) {
		try {

			Int64NeFieldHandler field = prototype.getInt64Field(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setInt64ArrayField(String name, long[] value) {
		try {

			Int64ArrayNeFieldHandler field = prototype.getInt64ArrayField(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setFloat32Field(String name, float value) {
		try {

			Float32NeFieldHandler field = prototype.getFloat32Field(name);
			pushUpdate(field.createValue(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setFloat32ArrayField(String name, float[] value) {
		try {

			Float32ArrayNeFieldHandler field = prototype.getFloat32ArrayField(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setFloat64Field(String name, double value) {
		try {

			Float64NeFieldHandler field = prototype.getFloat64Field(name);
			pushUpdate(field.createValue(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setFloat64ArrayField(String name, double[] value) {
		try {

			Float64ArrayNeFieldHandler field = prototype.getFloat64ArrayField(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setStringUTF8Field(String name, String value) {
		try {

			StringUTF8NeFieldHandler field = prototype.getStringUTF8Field(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setStringUTF8ArrayField(String name, String[] value) {
		try {

			StringUTF8ArrayNeFieldHandler field = prototype.getStringUTF8ArrayField(name);
			pushUpdate(field.createValue(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}



	@Override
	public <S extends S8Serializable> void setSerializableField(String name, S value)  {
		try {
			S8SerialPrototype<?> serialProto = value != null ? value.getSerialPrototype() : null;
			SerializableNeFieldHandler field = prototype.getSerializableField(name, serialProto);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}



	@Override
	public <S extends S8Serializable> void setSerializableArrayField(String name, S[] value) {
		try {
			
			/* retrieve proto if any */
			@SuppressWarnings("unchecked")
			S8SerialPrototype<S> serialProto = (value != null && value.length > 0) ? (S8SerialPrototype<S>) value[0].getSerialPrototype() : null;
			
			SerializableArrayNeFieldHandler<S> field = prototype.getSerializableArrayField(name, serialProto);
			pushUpdate(field.createValue(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public <T extends S8WebObject> void setObjectField(String name, T value) {
		try {
			ObjNeFieldHandler<T> field = prototype.getObjField(name);
			pushUpdate(field.createValue(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
	}


	@Override
	public <T extends S8WebObject> void setObjectListField(String name, List<T> value) {
		try {
			ListNeFieldHandler<T> field = prototype.getObjArrayField(name);
			pushUpdate(field.createUpdate(value));
			vertex.onUpdate();
		} catch (NeException e) {
			e.printStackTrace();
		}
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
