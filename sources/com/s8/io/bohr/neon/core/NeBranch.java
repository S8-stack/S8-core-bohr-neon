package com.s8.io.bohr.neon.core;

import java.util.HashMap;
import java.util.Map;

import com.s8.io.bohr.neon.control.NeController;
import com.s8.io.bytes.base64.Base64Generator;

/**
 * 
 * 
 * 
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 *
 */
public class NeBranch<C extends NeController> {
	
	
	public final String address;
	
	public final String id;
	
	public final C ctrl;
	
	
	final Map<String, NeObjectTypeHandler> prototypesByName;
	
	final Map<Long, NeObjectTypeHandler> prototypesByCode;
	
	
	/**
	 * 
	 */
	final Map<String, NeVertex<C>> vertices;

	
	/**
	 * 
	 */
	public long highestObjectId = 0x02L;
	
	public long highestTypeCode = 0x02L;
	
	
	
	public final NeInbound inbound;
	
	public final NeOutbound outbound;
	
	
	private final Base64Generator idxGen;
	
	public NeBranch(String address, String id, C ctrl) {
		super();
		this.address = address;
		this.id = id;
		this.ctrl = ctrl;
		
		prototypesByName = new HashMap<>();
		prototypesByCode = new HashMap<>();
		vertices = new HashMap<>();
		
		
		/* outbound */
		this.inbound = new NeInbound(this);
		this.outbound = new NeOutbound();
		
		idxGen = new Base64Generator(id);
	}



	/**
	 * 
	 * @return
	 */
	public String createNewIndex() {
		return idxGen.generate(++highestObjectId);
	}
	

	
	
	/**
	 * 
	 * @param vertex
	 * @return
	 */
	String appendObject(NeVertex<C> object) {
		
		String index = createNewIndex();
		
		vertices.put(index, object);
		
		outbound.notifyChanged(object);
		
		return index;
	}
	
	

	/**
	 * 
	 * @param index
	 * @return
	 */
	public NeVertex<C> getVertex(String index) {
		return vertices.get(index);
	}
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public NeObject<C> getObject(String index) {
		NeVertex<C> vertex = vertices.get(index);
		return vertex != null ? vertex.getAttachedObject() : null;
	}



	/**
	 * 
	 * @param typename
	 * @return
	 */
	public NeObjectTypeHandler retrieveObjectPrototype(String typename) {
		return prototypesByName.computeIfAbsent(typename, name -> {
			NeObjectTypeHandler proto = new NeObjectTypeHandler(name, highestTypeCode++);
			
			// store by code (so share code with front)
			prototypesByCode.put(proto.code, proto);
			return proto;
		});
	}


}
