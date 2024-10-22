package com.s8.io.bohr.neon.fields.objects;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.api.serial.S8ExplicitSerialPrototype;
import com.s8.api.serial.S8SerialPrototype;
import com.s8.api.serial.S8Serializable;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.BuildScope;
import com.s8.io.bohr.neon.core.NeObjectTypeFieldsBlock;
import com.s8.io.bohr.neon.fields.NeFieldHandler;
import com.s8.io.bohr.neon.fields.NeFieldUpdate;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class ExplicitSerializableNeFieldHandler extends NeFieldHandler {


	public final static long SIGNATURE = BOHR_Types.SERIAL_EXPLICIT;

	public @Override long getSignature() { return SIGNATURE; }



	private S8ExplicitSerialPrototype<?> serialProto;

	public ExplicitSerializableNeFieldHandler(NeObjectTypeFieldsBlock block, String name, S8ExplicitSerialPrototype<?> serialProto) {
		super(block, name);
		this.serialProto = serialProto;
	}
	
	public S8SerialPrototype<?> getSerialPrototype(){
		return serialProto;
	}

	
	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.SERIAL_EXPLICIT);
		
		/* publish serial signature */
		for(byte b : serialProto.getSignature()) { outflow.putByte(b); }
	}


	/**
	 * 
	 * @param values
	 * @param value
	 */
	public Update createUpdate(S8Serializable value) {
		return new Update(value);
	}




	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends NeFieldUpdate {

		private S8Serializable value;
		
		private S8SerialPrototype<?> proto;
		

		public Update(S8Serializable value) {
			super();
			this.value = value;
		}
		
		public Update(S8SerialPrototype<?> proto) {
			super();
			this.proto = proto;
		}

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			value.serialize(outflow);
		}

		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			value = proto.deserialize(inflow);
		}

		@Override
		public NeFieldHandler getFieldHandler() {
			return ExplicitSerializableNeFieldHandler.this;
		}
	}
}
