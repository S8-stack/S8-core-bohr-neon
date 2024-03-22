

import { S8 } from '/S8-api/S8Context.js';
import { BOHR_Keywords } from '/S8-core-bohr-atom/BOHR_Protocol.js';

import { NeObjectTypeHandler } from './NeObjectTypeHandler.js';
import { NeVertex } from './NeVertex.js';
import { NeObject } from './NeObject.js';

import { jump } from "./NeJump.js";


export class NeBranch {
	
	
	/**
	 * @type{number} UInt8
	 */
	requestRunFuncKeyword;

	/**
	 * @type {Map<string, NeObjectTypeHandler>}
	 */
	objectTypesByName = new Map();


	/**
	 * @type {Map<number, NeObjectTypeHandler>}
	 */
	objectTypesByCode = new Map();


	/**
	 * @type {Map<string, NeVertex>}
	 */
	vertices = new Map();


	
	/**
	 * Branch version
	 */
	version = -1;



	/**
	 * Out of thin air!
	 */
	constructor(requestRunFuncKeyword) {
		
		this.requestRunFuncKeyword = requestRunFuncKeyword;

		/** views */
		this.vertices.set("NULL", null);

		// create branch inbound
		//this.inbound = new NeBranchInbound(this);

		this.isVerbose = false;
	}

	/**
	 * 
	 * @param {ByteInflow} inflow 
	 */
	consume(inflow) {
		let code = inflow.getUInt8();
		if (code != BOHR_Keywords.OPEN_JUMP) {
			throw "Error: Can only start with a JUMP!!";
		}

		/* <version> */
		const jumpVersion = inflow.getUInt64();
		if(jumpVersion != this.version + 1){
			/* messed-up with version */
			alert("Server sync lost. Please Reload Page.")
			return false;
		}
		this.version = jumpVersion;
		/* </version> */
		
		
		/* <highest-index> */
		const jumpHighestObjectId = inflow.getUInt64();
		console.log(jumpHighestObjectId);
		/* /<highest-index> */

		// perform jump
		jump(this, inflow);
		
		/* is successful */
		return true;
	}


	/**
	 * 
	 * @param {string} id 
	 * @returns {NeVertex}
	 */
	getVertex(id) {
		return this.vertices.get(id);
	}

	/**
	 * 
	 * @param {string} id 
	 * @returns {NeObject}
	 */
	getObject(id) {
		let vertex = this.vertices.get(id);
		if (vertex == undefined) { throw `Failed to retrieve vertex for id=${id}`; }
		return vertex.object;
	}

	/**
	 * 
	 * @param {string} id 
	 * @param {NeVertex} node 
	 */
	setVertex(id, vertex) {
		if (!this.vertices.has(id)) {
			this.vertices.set(id, vertex);
		}
		else {
			throw "HARD overriding for node with index = " + id;
		}
	}

	deleteVertex(id) {
		let vertex = this.vertices.get(id);
		if (vertex) {
			let object = vertex.object;
			object.S8_dispose();
			this.vertices.delete(id);
		}
	}


	resolve(pathname) {
		return this.origin + pathname;
	}


	/**
	 * 
	 * @param {string} id 
	 * @param {number} slot 
	 */
	expose(id, slot) {
		if (slot != 0) { throw "Only slot 0 is available!"; }

		let vertex = this.getVertex(id);

		if (vertex == undefined) { throw `No object for id=${id}`; }
		let object = vertex.object;

		
		/* legacy code:
		S8.page.removeChildren(this.screenNode);
		this.screenNode.appendChild(object.getEnvelope());
		*/

		/* new code */
		S8.page.HTML_setRootElement(object.getEnvelope());
	}


	/**
	 * 
	 * @param {ByteInflow} inflow 
	 * @returns {NeObjectTypeHandler}
	 */
	declareType(inflow) {
		let name = inflow.getStringUTF8();
		let code = inflow.getUInt7x();

		if(this.objectTypesByCode.has(code) || this.objectTypesByName.has(name)){
			throw "[IO/BOHR_NEON] type alreday declared, for name = "+name;
		}

		let objectType = new NeObjectTypeHandler(this.branch, name, code);

		// register by name
		this.objectTypesByName.set(name, objectType);

		// register by code
		this.objectTypesByCode.set(code, objectType);

		return objectType;
	}



	render(){

		// render all controlled object
		this.vertices.forEach(vertex => {
			if(vertex != null){ // a NULL vertex is defined by default
				vertex.object.S8_render()
			}
		});
	}

}


