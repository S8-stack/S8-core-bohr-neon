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
	public final NeBranch branch;

	
	/**
	 * 
	 */
	private Queue<S8WebVertex> unpublishedChanges;
	
	
	/**
	 * 
	 */
	public NeOutbound(NeBranch branch) {
		super();
		this.branch = branch;
		unpublishedChanges = new LinkedList<S8WebVertex>();
	}
	
	
	/**
	 * 
	 * @param outflow
	 * @throws IOException 
	 */
	public void publish(ByteOutflow outflow) throws IOException {
		
		outflow.putUInt8(BOHR_Keywords.OPEN_JUMP);
		
		/* version */
		outflow.putUInt64(branch.version++);
		
		/* last assigned index */
		outflow.putUInt64(branch.highestObjectId);
		
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
