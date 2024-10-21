package com.s8.io.bohr.neon.fields.objects;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.api.serial.S8SerialPrototype;
import com.s8.api.serial.S8Serializable;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.BuildScope;
import com.s8.io.bohr.neon.core.NeObjectTypeFields;
import com.s8.io.bohr.neon.fields.NeFieldHandler;
import com.s8.io.bohr.neon.fields.NeFieldUpdate;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class SerializableNeFieldHandler extends NeFieldHandler {


	public final static long SIGNATURE = BOHR_Types.SERIAL;

	public @Override long getSignature() { return SIGNATURE; }




	public SerializableNeFieldHandler(NeObjectTypeFields prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.SERIAL);
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
			return SerializableNeFieldHandler.this;
		}
	}
}