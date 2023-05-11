package com.s8.io.bohr.neon.core;

import java.io.IOException;
import java.util.List;

import com.s8.io.bohr.neon.functions.NeFunction;
import com.s8.io.bohr.neon.functions.arrays.Bool8ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.Float32ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.Float64ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.StringUTF8ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt16ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt32ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt64ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt8ArrayNeFunction;
import com.s8.io.bohr.neon.functions.none.VoidNeFunction;
import com.s8.io.bohr.neon.functions.objects.ObjectNeFunction;
import com.s8.io.bohr.neon.functions.primitives.Bool8NeFunction;
import com.s8.io.bohr.neon.functions.primitives.Float32NeFunction;
import com.s8.io.bohr.neon.functions.primitives.Float64NeFunction;
import com.s8.io.bohr.neon.functions.primitives.Int16NeFunction;
import com.s8.io.bohr.neon.functions.primitives.Int32NeFunction;
import com.s8.io.bohr.neon.functions.primitives.Int64NeFunction;
import com.s8.io.bohr.neon.functions.primitives.Int8NeFunction;
import com.s8.io.bohr.neon.functions.primitives.StringUTF8NeFunction;
import com.s8.io.bohr.neon.functions.primitives.UInt16NeFunction;
import com.s8.io.bohr.neon.functions.primitives.UInt32NeFunction;
import com.s8.io.bohr.neon.functions.primitives.UInt64NeFunction;
import com.s8.io.bohr.neon.functions.primitives.UInt8NeFunction;
import com.s8.io.bytes.alpha.ByteOutflow;


/**
 * 
 * 
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 *
 */
public interface NeVertex {

	
	/**
	 * 
	 * @return index
	 */
	public String getIndex();
	
	
	
	public NeBranch getBranch();
	

	public NeObject getAttachedObject();

	
	public NeObjectTypeHandler getPrototype();


	/**
	 * 
	 * @param ordinal
	 * @return
	 */
	public NeFunction getFunction(int ordinal);
	

	public void expose(int slot);




	public void publish(ByteOutflow outflow) throws IOException;
	
	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setVoidMethod(String name, VoidNeFunction function);



	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setBool8Field(String name, boolean value);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean getBool8Field(String name);

	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setBool8Method(String name, Bool8NeFunction function);

	

	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setBool8ArrayField(String name, boolean[] value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean[] getBool8ArrayField(String name);
	

	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setBool8ArrayMethod(String name, Bool8ArrayNeFunction function);


	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt8Field(String name, int value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getUInt8Field(String name);
	
	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setUInt8Method(String name, UInt8NeFunction function);

	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt8ArrayField(String name, int[] value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public int[] getUInt8ArrayField(String name);
	
	
	public void setUInt8ArrayMethod(String name, UInt8ArrayNeFunction function);


	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt16Field(String name, int value);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getUInt16Field(String name);
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setUInt16Method(String name, UInt16NeFunction function);

	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt16ArrayField(String name, int[] value);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public int[] getUInt16ArrayField(String name);

	
	public void setUInt16ArrayMethod(String name, UInt16ArrayNeFunction function);


	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt32Field(String name, long value);
	
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public long getUInt32Field(String name);
	
	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setUInt32Method(String name, UInt32NeFunction function);

	
	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt32ArrayField(String name, long[] value);
	
	

	/**
	 * 
	 * @param name
	 * @return
	 */
	public long[] getUInt32ArrayField(String name);
	
	
	public void setUInt32ArrayMethod(String name, UInt32ArrayNeFunction function);



	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt64Field(String name, long value);
	


	/**
	 * 
	 * @param name
	 * @return
	 */
	public long getUInt64Field(String name);
	
	

	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setUInt64Method(String name, UInt64NeFunction function);
	
	
	

	public void setUInt64ArrayMethod(String name, UInt64ArrayNeFunction function);

	
	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setInt8Field(String name, int value);
	
	

	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getInt8Field(String name);
	
	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setInt8Method(String name, Int8NeFunction function);
	

	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setInt16Field(String name, int value);


	/*
	 * 
	 */
	public int getInt16Field(String name);
	
	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setInt16Method(String name, Int16NeFunction function);
	


	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setInt32Field(String name, int value);
	


	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getInt32Field(String name);
	

	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setInt32Method(String name, Int32NeFunction function);
	
	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setInt64Field(String name, long value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public long getInt64Field(String name);
	
	
	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setInt64Method(String name, Int64NeFunction function);
	
	

	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setInt64ArrayField(String name, long[] value);
	

	/**
	 * 
	 * @param name
	 * @return
	 */
	public long[] getInt64ArrayField(String name);
	


	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setFloat32Field(String name, float value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public float getFloat32Field(String name);
	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setFloat32Method(String name, Float32NeFunction function);


	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setFloat32ArrayField(String name, float[] value);



	/**
	 * 
	 * @param name
	 * @return
	 */
	public float[] getFloat32ArrayField(String name);

	
	public void setFloat32ArrayMethod(String name, Float32ArrayNeFunction function);




	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setFloat64Field(String name, double value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public double getFloat64Field(String name);

	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setFloat64Method(String name, Float64NeFunction function);

	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setFloat64ArrayField(String name, double[] value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public double[] getFloat64ArrayField(String name);


	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setFloat64ArrayMethod(String name, Float64ArrayNeFunction function);

	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setStringUTF8Field(String name, String value);


	public String getStringUTF8Field(String name);


	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setStringUTF8Method(String name, StringUTF8NeFunction function);
	

	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setStringUTF8ArrayField(String name, String[] value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public String[] getStringUTF8ArrayField(String name);
	
	
	/**
	 * 
	 * @param name
	 * @param function
	 */
	public void setStringUTF8ArrayMethod(String name, StringUTF8ArrayNeFunction function);



	/**
	 * 
	 * @param <T>
	 * @param name
	 * @param value
	 */
	public <T extends NeObject> void setObjectField(String name, T value);


	/**
	 * 
	 * @param <T>
	 * @param name
	 * @return
	 */
	public <T extends NeObject> T getObjectField(String name);
	
	
	/**
	 * 
	 * @param <T>
	 * @param name
	 * @return
	 */
	public <T extends NeObject> void setObjectMethod(String name, ObjectNeFunction<T> function);




	public <T extends NeObject> void setObjectListField(String name, List<T> value);


	
	/**
	 * 
	 * @param <T>
	 * @param name
	 * @return a <b>COPY</b> of the underlying list
	 */
	public <T extends NeObject> List<T> getObjectListField(String name);

	
	/**
	 * 
	 * @param <T>
	 * @param name
	 * @param obj
	 */
	public <T extends NeObject> void addObjToList(String name, T obj);
	
	
	/**
	 * 
	 * @param <T>
	 * @param name
	 * @param obj
	 */
	public <T extends NeObject> void removeObjFromList(String name, T obj);


	







}
