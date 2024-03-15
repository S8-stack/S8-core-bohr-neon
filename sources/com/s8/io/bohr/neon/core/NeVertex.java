package com.s8.io.bohr.neon.core;

import java.io.IOException;

import com.s8.api.bytes.ByteOutflow;
import com.s8.api.web.S8WebObject;
import com.s8.api.web.S8WebVertex;
import com.s8.api.web.S8WebVertexOutbound;
import com.s8.api.web.S8WebVertexInbound;
import com.s8.api.web.WebS8VertexProviders;
import com.s8.core.bohr.atom.protocol.BOHR_Keywords;


/**
 * 
 * 
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 *
 */
public class NeVertex implements S8WebVertex {

	public final NeBranch branch;

	public final S8WebObject object;

	private boolean hasUnpublishedChanges = false;

	private boolean isCreateUnpublished = false;

	private boolean isExposeUnpublished = false;

	private boolean isUpdateUnpublished = false;


	private int slot;




	public final NeObjectTypeHandler prototype;


	/**
	 * index
	 */
	private String index;

	
	public final NeVertexOutbound outbound;
	
	public final NeVertexInbound inbound;

	public final NeVertexProviders0 providers;


	/**
	 * 
	 * @param branch
	 */
	public NeVertex(NeBranch branch, String typeName, S8WebObject object) {
		super();


		// branch
		this.branch = branch;
		this.prototype = branch.retrieveObjectPrototype(typeName);
		this.object = object;

		this.outbound = new NeVertexOutbound(this, prototype.fields);
		this.inbound = new NeVertexInbound(this, prototype.methods);
		this.providers = new NeVertexProviders0(this, prototype.providers);
	}

	@Override
	public NeBranch getSession() {
		return branch;
	}

	@Override
	public S8WebObject getAttachedObject() {
		return object;
	}
	
	
	/**
	 * 
	 */
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

				prototype.fields.publishFields(outbound.pullUpdates(), outflow);

				outflow.putUInt8(BOHR_Keywords.CLOSE_NODE);

				isCreateUnpublished = false;
			}	
			else if(isUpdateUnpublished) {

				// declare type
				outflow.putUInt8(BOHR_Keywords.UPDATE_NODE);

				/* publish index */
				outflow.putStringUTF8(index);

				/* fields */
				prototype.fields.publishFields(outbound.pullUpdates(), outflow);

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
	

	@Override
	public S8WebVertexOutbound outbound() {
		return outbound;
	}

	@Override
	public S8WebVertexInbound inbound() {
		return inbound;
	}

	@Override
	public WebS8VertexProviders providers() {
		return providers;
	}





}
