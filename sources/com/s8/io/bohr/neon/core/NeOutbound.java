package com.s8.io.bohr.neon.core;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import com.s8.api.bytes.ByteOutflow;
import com.s8.api.objects.web.S8WebVertex;
import com.s8.core.io.bohr.atom.protocol.BOHR_Keywords;

/**
 * 
 * @author pierreconvert
 *
 */
public class NeOutbound {


	/**
	 * 
	 */
	private Queue<S8WebVertex> unpublishedChanges;
	
	
	/**
	 * 
	 */
	public NeOutbound() {
		super();
		unpublishedChanges = new LinkedList<S8WebVertex>();
	}
	
	
	/**
	 * 
	 * @param outflow
	 * @throws IOException 
	 */
	public void publish(ByteOutflow outflow) throws IOException {
		
		outflow.putUInt8(BOHR_Keywords.OPEN_JUMP);
		
		while(!unpublishedChanges.isEmpty()) {
			unpublishedChanges.poll().publish(outflow);
		}
		
		outflow.putUInt8(BOHR_Keywords.CLOSE_JUMP);
	}



	/**
	 * 
	 * @param object
	 */
	public void notifyChanged(S8WebVertex object) {
		unpublishedChanges.add(object);
	}
	
}
