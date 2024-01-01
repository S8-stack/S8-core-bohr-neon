package com.s8.io.bohr.neon.fields.objects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.api.web.S8WebFrontObject;
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
public class ListNeFieldHandler<T extends S8WebFrontObject> extends NeFieldHandler {

	public final static long SIGNATURE =  BOHR_Types.ARRAY << 8 & BOHR_Types.S8OBJECT;

	public @Override long getSignature() { return SIGNATURE; }

	/**
	 * 
	 * @param view
	 */
	public ListNeFieldHandler(NeObjectTypeFields prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.ARRAY);
		outflow.putUInt8(BOHR_Types.S8OBJECT);
	}



	/**
	 * 
	 * @param values
	 * @return
	 */
	
	public List<T> get(NeFieldUpdate wrapper) {
		@SuppressWarnings("unchecked")
		Update value = (Update) wrapper; 
		if(value.list == null) {
			List<T> list = new ArrayList<T>();
			value.list = list;
			return list;
		}
		else {
			List<T> list = value.list;
			List<T> copy = new ArrayList<T>(list.size());
			list.forEach(item -> copy.add(item));
			return copy;
		}
	}

	public NeFieldUpdate createUpdate(List<T> list) {
		return new Update(list);
	}



	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends NeFieldUpdate {

		private List<T> list;

		public Update(List<T> list) {
			super();
			this.list = list;
		}
		
		
		/**
		 * 
		 * @param value
		 * @return
		 */
		private boolean checkIfHasDelta(List<T> value) {
			if(this.list == null && value == null) {
				return false;
			}
			else if((this.list != null && value == null) || (this.list == null && value != null)) {
				return true;
			}
			else { /* this.value != null && value != null */
				int nLeft = this.list.size(), nRight = value.size();
				if(nLeft != nRight) {
					return true;
				}
				else {
					for(int i= 0; i<nLeft; i++) {
						T left = this.list.get(i), right = value.get(i);
						if((left == null && right != null) || 
								(left != null && right == null) ||
								(left != null && right != null && !left.vertex.getId().equals(right.vertex.getId()))) {
							return true;
						}
					}
					return false;
				}
			}
		}
		
		/**
		 * 
		 * @param value
		 */
		public boolean setValue(List<T> value) {
			if(checkIfHasDelta(value)) {
				this.list = value;
				return true;
			}
			else {
				return false;
			}
		}
		

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			if(list != null) {
				int n = list.size();
				outflow.putUInt7x(n);
				T item;
				for(int i = 0; i < n; i++) {
					item = list.get(i);
					outflow.putStringUTF8(item != null ? item.vertex.getId() : null);
				}
			}
			else {
				outflow.putUInt7x(-1);
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			int n = (int) inflow.getUInt7x();
			if(n >= 0) {
				List<String> indices = new ArrayList<String>(n);
				for(int i = 0; i < n; i++) { indices.add(inflow.getStringUTF8()); }

				scope.appendBinding(new BuildScope.Binding() {

					@Override
					public void resolve(BuildScope scope) throws IOException {
						list = new ArrayList<T>(n);
						String index;
						for(int i = 0; i < n; i++) {
							index = indices.get(i);
							list.add(index != null ? (T) scope.retrieveObject(indices.get(i)) : null);
						}	
					}
				});
			}
			else {
				list = null;
			}

		}


		@Override
		public NeFieldHandler getFieldHandler() {
			return ListNeFieldHandler.this;
		}
	}	
}
