



import { S8 } from '/S8-api/S8Context.js';

import {S8Vertex} from "/S8-api/S8Vertex.js";
import {S8Object} from "/S8-api/S8Object.js";

import { ByteInflow } from "/S8-core-io-bytes/ByteInflow.js";
import { ByteOutflow } from "/S8-core-io-bytes/ByteOutflow.js";

import { BOHR_Keywords } from "/S8-core-bohr-atom/BOHR_Protocol.js";
import { NeProvider } from "/S8-core-bohr-neon/NeProvider.js";

import { NeBranch } from "./NeBranch.js";
import { NeObjectTypeHandler } from "./NeObjectTypeHandler.js";
import { NeMethodRunner } from "./NeMethodRunner.js";


/**
 * 
 */
export class NeVertex extends S8Vertex {

	/**
	 * @type {NeBranch}
	 */
	branch;

	/**
	 * Automatically assigned by NeObjectTypeHandler
	 * 
	 * @type {string}
	 */
	id;

	/**
	 * @type {NeObjectTypeHandler}
	 */
	type;


	/**
	 * @type {S8Object}
	 */
	object;

	/**
	 * 
	 * @param {NeBranch} branch 
	 * @param {string} id 
	 * @param {NeObjectTypeHandler} type
	 * @param {S8Object} object
	 */
	constructor(branch, id, type, object) {
		super();
		this.branch = branch;
		this.id = id;
		this.type = type;
		this.object = object;
	}




	runVoid(methodName) {
		let methodRunner = this.type.getVoidMethodRunner(methodName);
		this.shoot(methodRunner);
	}

	/**
	 * 
	 * @param {string} methodName 
	 * @param {boolean} argValue 
	 */
	runBool8(methodName, argValue) {
		let methodRunner = this.type.getBool8MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {Array} argValue 
	 */
	runBool8Array(methodName, argValue) {
		let methodRunner = this.type.getBool8ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runUInt8(methodName, argValue) {
		let methodRunner = this.type.getUInt8MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runUInt8Array(methodName, argValue) {
		let methodRunner = this.type.getUInt8ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runUInt16(methodName, argValue) {
		let methodRunner = this.type.getUInt16MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {Array} argValue 
	 */
	runUInt16Array(methodName, argValue) {
		let methodRunner = this.type.getUInt16ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runUInt32(methodName, argValue) {
		let methodRunner = this.type.getUInt32MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {Array} argValue 
	 */
	runUInt32Array(methodName, argValue) {
		let methodRunner = this.type.getUInt32ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runUInt64(methodName, argValue) {
		let methodRunner = this.type.getUInt64MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {Array} argValue 
	 */
	runUInt64Array(methodName, argValue) {
		let methodRunner = this.type.getUInt64ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runInt8(methodName, argValue) {
		let methodRunner = this.type.getInt8MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {Array} argValue 
	 */
	runInt8Array(methodName, argValue) {
		let methodRunner = this.type.getInt8ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runInt16(methodName, argValue) {
		let methodRunner = this.type.getInt16MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {Array} argValue 
	 */
	runInt16Array(methodName, argValue) {
		let methodRunner = this.type.getInt16ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runInt32(methodName, argValue) {
		let methodRunner = this.type.getInt32MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runInt32Array(methodName, argValue) {
		let methodRunner = this.type.getInt16ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runInt64(methodName, argValue) {
		let methodRunner = this.type.getInt64ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runInt64Array(methodName, argValue) {
		let methodRunner = this.type.getInt64MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runFloat32(methodName, argValue) {
		let methodRunner = this.type.getFloat32MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {Array} argValue 
	 */
	runFloat32Array(methodName, argValue) {
		let methodRunner = this.type.getFloat32ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runFloat64(methodName, argValue) {
		let methodRunner = this.type.getFloat64MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}



	/**
	 * 
	 * @param {string} methodName 
	 * @param {Array} argValue 
	 */
	runFloat64Array(methodName, argValue) {
		let methodRunner = this.type.getFloat64ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {number} argValue 
	 */
	runStringUTF8(methodName, argValue) {
		let methodRunner = this.type.getStringUTF8MethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {string} methodName 
	 * @param {Array} argValue 
	 */
	runStringUTF8Array(methodName, argValue) {
		let methodRunner = this.type.getStringUTF8ArrayMethodRunner(methodName);
		this.shoot(methodRunner, argValue);
	}


	/**
	 * 
	 * @param {NeMethodRunner} method 
	 * @param {*} arg 
	 */
	shoot(method, arg) {

		let outflow = new ByteOutflow(new ArrayBuffer(2048));
		outflow.putUInt8(this.branch.requestRunFuncKeyword);


		/* <declare-method> */

		// publish method if necessary
		method.publish_DECLARE_METHOD(outflow);
		/* <declare-method> */

		/* <run-method> */

		// shoot id
		outflow.putUInt8(BOHR_Keywords.RUN_METHOD);

		// object/vertex id
		outflow.putStringUTF8(this.id);

		// method code
		outflow.putUInt8(method.code);

		// pass args
		method.produceValue(outflow, arg);

		outflow.putUInt8(BOHR_Keywords.CLOSE_JUMP);

		const _branch = this.branch;
		S8.server.sendRequest_HTTP2_POST(outflow.toRequestArray(), function (responseArrayBuffer) {
			let inflow = new ByteInflow(responseArrayBuffer);
			_branch.consume(inflow);
		});
		/* </run-method> */

	};



	/**
	 * 
	 * @param {string} providerName 
	 * @param {string} filename 
	 */
	downloadRaw(providerName, filename) {
		let provider = this.type.getRawProvider(providerName);
		this.shootDownload(provider, filename);
	}



	/**
	* 
	* @param {NeProvider} provider 
	* @param {string} filename 
	*/
	shootDownload(provider, filename) {

		let requestArrayBuffer = new ArrayBuffer(64);
		let outflow = new ByteOutflow(requestArrayBuffer);
		outflow.putUInt8(this.branch.requestRunFuncKeyword);


		/* <declare-method> */

		// publish method if necessary
		provider.publish_DECLARE_PROVIDER(outflow);
		/* <declare-method> */

		/* <run-method> */

		// shoot id
		outflow.putUInt8(BOHR_Keywords.RUN_PROVIDER);

		// object/vertex id
		outflow.putStringUTF8(this.id);

		// provider code
		outflow.putUInt8(provider.code);

		// (no args to add)

		outflow.putUInt8(BOHR_Keywords.CLOSE_JUMP);

		/**
		 * responseArrayBuffer = request.response
		 */
		S8.server.sendRequest_HTTP2_POST(requestArrayBuffer, function (responseArrayBuffer) {

			// The actual download
			var blob = new Blob([responseArrayBuffer], { type: 'application/text' });
			var link = document.createElement('a');
			link.href = window.URL.createObjectURL(blob);
			link.download = filename;

			document.body.appendChild(link);
			link.click();
			document.body.removeChild(link);
			
		});
		/* </run-method> */

	};

}