package com.s8.io.bohr.neon.core;

import java.io.IOException;

import com.s8.arch.fluor.S8AsyncFlow;
import com.s8.io.bohr.atom.BOHR_Keywords;
import com.s8.io.bohr.neon.functions.NeFunction;
import com.s8.io.bohr.neon.methods.NeMethod;
import com.s8.io.bytes.alpha.ByteInflow;



/**
 * 
 * @author pierreconvert
 *
 */
public class NeInbound {

	private final NeBranch branch;


	private int forkCode;

	private long viewIndex = -1;

	private int methodCode = -1;

	private Object[] params;

	public NeInbound(NeBranch branch) {
		super();
		this.branch = branch;
	}
	

	/**
	 * 
	 * @param inflow
	 * @throws IOException
	 */
	public void consume(S8AsyncFlow flow, ByteInflow inflow) throws IOException {
		int code;
		boolean isClosed = false;
		while(!isClosed) {
			switch(code = inflow.getUInt8()) {
			case BOHR_Keywords.DECLARE_METHOD: declareMethod(inflow); break;
			case BOHR_Keywords.RUN_METHOD : runFunc(flow, inflow); break;
			case BOHR_Keywords.CLOSE_JUMP : isClosed = true; break;
			default: throw new IOException("[NeInbound] Code "+code+" is not supported");
			}
		}
	}

	


	
	/**
	 * 
	 * @param inflow
	 * @throws IOException
	 */
	private void declareMethod(ByteInflow inflow) throws IOException {

		long typeCode = inflow.getUInt7x();
		
		NeObjectTypeHandler prototype = branch.prototypesByCode.get(typeCode);
		if(prototype == null) {
			throw new IOException("Failed to retrieve prototype for code: "+typeCode);
		}
		
		prototype.methods.consume_DECLARE_METHOD(inflow);
	}
	
	
	/**
	 * 
	 * @param inflow
	 * @throws IOException
	 */
	private void runFunc(S8AsyncFlow flow, ByteInflow inflow) throws IOException {
		
		String index = inflow.getStringUTF8();
		NeVertex0 vertex = branch.vertices.get(index);
		if(vertex == null) { throw new IOException("No Object for index = "+index); }
		
		int code = inflow.getUInt8();
		NeMethod runner = vertex.getPrototype().methods.getMethod(code);
		if(runner == null) { throw new IOException("No runner for code = "+code); }
		
		int ordinal = runner.ordinal;
		
		NeFunction function = vertex.methods.getFunction(ordinal);
		if(function == null) { throw new IOException("Missing func @ code = "+code+", for index = "+index); }
		
		/* run function */
		runner.run(branch, flow, inflow, function);
	}

	
	
	
	/**
	 * 
	 * @return the sub-protocol index within the [0x00, 0xff] index range.
	 */
	public int getForkCode() {
		return forkCode;
	}


	/**
	 * 
	 * @return the view index [0x0, 0xffffffffffffffff]
	 */
	public long getViewIndex() {
		return viewIndex;
	}



	/**
	 * 
	 * @return the method code
	 */
	public int getMethodCode() {
		return methodCode;
	}



	/**
	 * 
	 * @return
	 */
	public Object[] getParameters() {
		return params;
	}

	/**
	 * 
	 * @return
	 */
	public Object getParameter(int index) {
		return params[index];
	}


}
