package com.s8.io.bohr.neon.functions;

import com.s8.io.bohr.neon.functions.arrays.Float32ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.Float64ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.Int16ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.Int32ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.Int64ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.Int8ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.StringUTF8ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt16ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt32ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt64ArrayNeFunction;
import com.s8.io.bohr.neon.functions.arrays.UInt8ArrayNeFunction;
import com.s8.io.bohr.neon.functions.none.VoidNeFunction;
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
import com.s8.io.bohr.neon.lambdas.arrays.Float32ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.Float64ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.Int16ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.Int32ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.Int64ArrayLambda;
import com.s8.io.bohr.neon.lambdas.arrays.Int8ArrayLambda;
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

/**
 * 
 * @author pierreconvert
 *
 */
public interface NeSyncFuncGenerator {


	
	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public VoidNeFunction createVoidFunc(VoidLambda lambda);
	
	
	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public Bool8NeFunction createBool8Func(Bool8Lambda lambda);
	

	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public UInt8NeFunction createUInt8Func(UInt8Lambda lambda);

	
	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public UInt8ArrayNeFunction createUint8ArrayFunc(UInt8ArrayLambda lambda);

	
	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public UInt16NeFunction createUint16Func(UInt16Lambda lambda);

	
	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public UInt16ArrayNeFunction createUint16ArrayFunc(UInt16ArrayLambda lambda);

	
	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public UInt32NeFunction createUint32Func(UInt32Lambda lambda);

	
	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public UInt32ArrayNeFunction createUint32Func(UInt32ArrayLambda lambda);

	
	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public UInt64NeFunction createUint64Func(UInt64Lambda lambda);

	
	/**
	 * 
	 * @param lambda
	 * @return
	 */
	public UInt64ArrayNeFunction createUint64Func(UInt64ArrayLambda lambda);
	
	
	
	public Int8NeFunction createInt8Func(Int8Lambda lambda);

	public Int8ArrayNeFunction createInt8ArrayFunc(Int8ArrayLambda lambda);

	public Int16NeFunction createInt16Func(Int16Lambda lambda);

	public Int16ArrayNeFunction createInt16ArrayFunc(Int16ArrayLambda lambda);

	public Int32NeFunction createInt32Func(Int32Lambda lambda);

	public Int32ArrayNeFunction createInt32ArrayFunc(Int32ArrayLambda lambda);

	public Int64NeFunction createInt64Func(Int64Lambda lambda);

	public Int64ArrayNeFunction createInt64ArrayFunc(Int64ArrayLambda lambda);
	
	
	
	public Float32NeFunction createFloat32Func(Float32Lambda lambda);

	public Float32ArrayNeFunction createFloat32ArrayFunc(Float32ArrayLambda lambda);

	public Float64NeFunction createFloat64Func(Float64Lambda lambda);

	public Float64ArrayNeFunction createFloat64ArrayFunc(Float64ArrayLambda lambda);


	
	public StringUTF8NeFunction createStringUTF8Func(StringUTF8Lambda lambda);

	public StringUTF8ArrayNeFunction createStringUTF8ArrayFunc(StringUTF8ArrayLambda lambda);

}
