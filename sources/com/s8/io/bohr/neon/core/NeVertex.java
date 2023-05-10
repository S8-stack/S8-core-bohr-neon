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
	public void setBool8(String name, boolean value);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean getBool8(String name);

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
	public void setBool8Array(String name, boolean[] value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean[] getBool8Array(String name);
	

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
	public void setUInt8(String name, int value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getUInt8(String name);
	
	
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
	public void setUInt8Array(String name, int[] value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public int[] getUInt8Array(String name);
	
	
	public void setUInt8ArrayMethod(String name, UInt8ArrayNeFunction function);


	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt16(String name, int value);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getUInt16(String name);
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
	public void setUInt16Array(String name, int[] value);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public int[] getUInt16Array(String name);

	
	public void setUInt16ArrayMethod(String name, UInt16ArrayNeFunction function);


	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt32(String name, long value);
	
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public long getUInt32(String name);
	
	
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
	public void setUInt32Array(String name, long[] value);
	
	

	/**
	 * 
	 * @param name
	 * @return
	 */
	public long[] getUInt32Array(String name);
	
	
	public void setUInt32ArrayMethod(String name, UInt32ArrayNeFunction function);



	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setUInt64(String name, long value);
	


	/**
	 * 
	 * @param name
	 * @return
	 */
	public long getUInt64(String name);
	
	

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
	public void setInt8(String name, int value);
	
	

	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getInt8(String name);
	
	
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
	public void setInt16(String name, int value);


	/*
	 * 
	 */
	public int getInt16(String name);
	
	
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
	public void setInt32(String name, int value);
	


	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getInt32(String name);
	

	
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
	public void setInt64(String name, long value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public long getInt64(String name);
	
	
	
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
	public void setInt64Array(String name, long[] value);
	

	/**
	 * 
	 * @param name
	 * @return
	 */
	public long[] getInt64Array(String name);
	


	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setFloat32(String name, float value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public float getFloat32(String name);
	
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
	public void setFloat32Array(String name, float[] value);



	/**
	 * 
	 * @param name
	 * @return
	 */
	public float[] getFloat32Array(String name);

	
	public void setFloat32ArrayMethod(String name, Float32ArrayNeFunction function);




	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setFloat64(String name, double value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public double getFloat64(String name);

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
	public void setFloat64Array(String name, double[] value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public double[] getFloat64Array(String name);


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
	public void setStringUTF8(String name, String value);


	public String getStringUTF8(String name);


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
	public void setStringUTF8Array(String name, String[] value);


	/**
	 * 
	 * @param name
	 * @return
	 */
	public String[] getStringUTF8Array(String name);
	
	
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
	public <T extends NeObject> void setObj(String name, T value);


	/**
	 * 
	 * @param <T>
	 * @param name
	 * @return
	 */
	public <T extends NeObject> T getObj(String name);
	
	
	/**
	 * 
	 * @param <T>
	 * @param name
	 * @return
	 */
	public <T extends NeObject> void setObjectMethod(String name, ObjectNeFunction<T> function);




	public <T extends NeObject> void setObjList(String name, List<T> value);


	
	/**
	 * 
	 * @param <T>
	 * @param name
	 * @return a <b>COPY</b> of the underlying list
	 */
	public <T extends NeObject> List<T> getObjList(String name);

	
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
