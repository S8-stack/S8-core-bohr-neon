package com.s8.io.bohr.neon.core;

import java.util.HashMap;
import java.util.Map;

import com.s8.api.web.S8WebFront;
import com.s8.api.web.S8WebFrontObject;
import com.s8.api.web.S8WebVertex;
import com.s8.core.io.bytes.base64.Base64Composer;

/**
 * 
 * 
 * 
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 *
 */
public class NeBranch implements S8WebFront {
	
	
	public final String id;
	
	
	
	final Map<String, NeObjectTypeHandler> prototypesByName;
	
	final Map<Long, NeObjectTypeHandler> prototypesByCode;
	
	
	/**
	 * 
	 */
	final Map<String, NeVertex0> vertices;

	
	/**
	 * 
	 */
	public long highestObjectId = 0x02L;
	
	public long highestTypeCode = 0x02L;
	
	
	
	public final NeInbound inbound;
	
	public final NeOutbound outbound;
	
	
	private final Base64Composer idxGen;



	public long version = 0x0L;
	
	
	public NeBranch(String id) {
		super();
		this.id = id;
		
		prototypesByName = new HashMap<>();
		prototypesByCode = new HashMap<>();
		vertices = new HashMap<>();
		
		
		/* outbound */
		this.inbound = new NeInbound(this);
		this.outbound = new NeOutbound(this);
		
		idxGen = new Base64Composer(id);
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
	String appendObject(NeVertex0 object) {
		
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
	public S8WebVertex getVertex(String index) {
		return vertices.get(index);
	}
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public S8WebFrontObject getObject(String index) {
		S8WebVertex vertex = vertices.get(index);
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



	@Override
	public S8WebVertex createVertex(String typeName, S8WebFrontObject object) {
		return new NeVertex0(this, typeName, object);
	}

}
