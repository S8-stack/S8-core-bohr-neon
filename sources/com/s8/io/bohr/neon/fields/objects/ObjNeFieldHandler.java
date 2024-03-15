package com.s8.io.bohr.neon.fields.objects;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.api.web.S8WebObject;
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
public class ObjNeFieldHandler<T extends S8WebObject> extends NeFieldHandler {

	public final static long SIGNATURE =  BOHR_Types.S8OBJECT;

	public @Override long getSignature() { return SIGNATURE; }

	/**
	 * 
	 * @param view
	 */
	public ObjNeFieldHandler(NeObjectTypeFields prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.S8OBJECT);
	}




	/**
	 * 
	 * @param value
	 * @return
	 */
	public NeFieldUpdate createValue(T value) {
		return new Update(value);
	}



	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends NeFieldUpdate {

		private T value;

		public Update(T value) {
			super();
			this.value = value;
		}


		private boolean checkIfHasDelta(T value) {
			return (this.value == null && value != null) || 
					(this.value != null && value == null) ||
					(this.value != null && value != null && !this.value.vertex.getId().equals(value.vertex.getId()));

		}


		/**
		 * 
		 * @param value
		 */
		public boolean setValue(T value) {
			if(checkIfHasDelta(value)) {
				this.value = value;
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			outflow.putStringUTF8(value != null ? value.vertex.getId() : null);
		}


		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {

			// get index
			String index = inflow.getStringUTF8();

			if(index != null) {
				scope.appendBinding(new BuildScope.Binding() {

					@SuppressWarnings("unchecked")
					@Override
					public void resolve(BuildScope scope) throws IOException {
						value = (T) scope.retrieveObject(index);
					}
				});
			}
			else {
				value = null;
			}
		}


		@Override
		public NeFieldHandler getFieldHandler() {
			return ObjNeFieldHandler.this;
		}
	}	
}
