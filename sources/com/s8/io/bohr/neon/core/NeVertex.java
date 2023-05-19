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
import com.s8.io.bohr.neon.lambdas.arrays.Bool8ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.Float32ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.Float64ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.StringUTF8ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.UInt16ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.UInt32ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.UInt64ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.UInt8ArrayLambda;
import com.s8.io.bohr.neon.lambdas.none.VoidLambda;
import com.s8.io.bohr.neon.lambdas.primitives.Bool8Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.Float32Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.Float64Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.Int16Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.Int32Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.Int64Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.Int8Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.StringUTF8Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.UInt16Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.UInt32Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.UInt64Lambda;
import com.s8.io.bohr.neon.lambdas.primitives.UInt8Lambda;
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
	
	
	/**
	 * Object attached to this vertex
	 * @return
	 */
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

	public default void setVoidMethodLambda(String name, VoidLambda lambda) {
		setVoidMethod(name, (flow) -> flow.then(0, () -> lambda.operate()).send());
	}


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

	public default void setBool8MethodLambda(String name, Bool8Lambda lambda) {
		setBool8Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	

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

	
	public default void setBool8ArrayMethodLambda(String name, Bool8ArrayLambda lambda) {
		setBool8ArrayMethod(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}

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
	 * @param lambda
	 */
	public default void setUInt8MethodLambda(String name, UInt8Lambda lambda) {
		setUInt8Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	
	
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

	public default void setUInt8ArrayMethodLambda(String name, UInt8ArrayLambda lambda) {
		setUInt8ArrayMethod(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}

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
	
	
	public default void setUInt16MethodLambda(String name, UInt16Lambda lambda) {
		setUInt16Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	
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

	public default void setUInt16ArrayMethodLambda(String name, UInt16ArrayLambda lambda) {
		setUInt16ArrayMethod(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}

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

	public default void setUInt32MethodLambda(String name, UInt32Lambda lambda) {
		setUInt32Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	
	
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

	
	public default void setUInt32ArrayMethodLambda(String name, UInt32ArrayLambda lambda) {
		setUInt32ArrayMethod(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}


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
	
	
	public default void setUInt64MethodLambda(String name, UInt64Lambda lambda) {
		setUInt64Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	

	public void setUInt64ArrayMethod(String name, UInt64ArrayNeFunction function);

	public default void setUInt64ArrayMethodLambda(String name, UInt64ArrayLambda lambda) {
		setUInt64ArrayMethod(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	
	
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
	
	public default void setInt8MethodLambda(String name, Int8Lambda lambda) {
		setInt8Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	

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
	 * @param lambda
	 */
	public default void setInt16MethodLambda(String name, Int16Lambda lambda) {
		setInt16Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	


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
	
	public default void setInt32MethodLambda(String name, Int32Lambda lambda) {
		setInt32Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	
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
	
	
	public default void setInt64MethodLambda(String name, Int64Lambda lambda) {
		setInt64Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}

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

	public default void setFloat32MethodLambda(String name, Float32Lambda lambda) {
		setFloat32Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	
	
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

	public default void setFloat32ArrayMethodLambda(String name, Float32ArrayLambda lambda) {
		setFloat32ArrayMethod(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}


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

	public default void setFloat64MethodLambda(String name, Float64Lambda lambda) {
		setFloat64Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	
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

	public default void setFloat64ArrayMethodLambda(String name, Float64ArrayLambda lambda) {
		setFloat64ArrayMethod(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	
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
	

	public default void setStringUTF8MethodLambda(String name, StringUTF8Lambda lambda) {
		setStringUTF8Method(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}
	
	
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

	public default void setStringUTF8ArrayMethodLambda(String name, StringUTF8ArrayLambda lambda) {
		setStringUTF8ArrayMethod(name, (flow, value) -> flow.then(0, () -> lambda.operate(value)).send());
	}

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
