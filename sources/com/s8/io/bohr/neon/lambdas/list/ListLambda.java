package com.s8.io.bohr.neon.lambdas.list;

import java.util.List;

import com.s8.io.bohr.neon.core.NeObject;



public interface ListLambda<T extends NeObject> {

	public void operate(List<T> arg);
}
