import { ByteInflow } from "/S8-core-io-bytes/ByteInflow.js";



/**
 * 
 * @param {ByteInflow} inflow 
 */
export const getS8Deserializer = function (inflow) {

    let code = inflow.getUInt8();
    switch (code) {

        case 0x24: return IMAGE_SVG_getS8Deserializer(inflow);

        default: throw "Unsupported EXPLICIT serial code: " + code;
    }
}


const IMAGE_SVG_getS8Deserializer = function (inflow) {

    let code = inflow.getUInt8();
    switch (code) {

        case 0x24: return IMAGE_SVG_PATH_ELEMENT_Deserializer;

        default: throw "Unsupported EXPLICIT serial code: " + code;
    }
}

const IMAGE_SVG_PATH_ELEMENT_Deserializer = function (inflow) {

    let code = inflow.getUInt8();

    let object = new Object();
    object.code = code;
    
    switch (code) {

        case 0x02: break;

        case 0x12:
            object.x = inflow.getFloat32();
            object.y = inflow.getFloat32();
            break;

        case 0x13:
            object.dx = inflow.getFloat32();
            object.dy = inflow.getFloat32();
            break;

        case 0x21:
            object.x = inflow.getFloat32();
            object.y = inflow.getFloat32();
            break;

        case 0x22:
            object.dx = inflow.getFloat32();
            object.dy = inflow.getFloat32();
            break;

        case 0x23:
            object.x = inflow.getFloat32();
            break;

        case 0x24:
            object.dx = inflow.getFloat32();
            break;

        case 0x25:
            object.y = inflow.getFloat32();
            break;

        case 0x26:
            object.dy = inflow.getFloat32();
            break;

        case 0x31:
            object.r = inflow.getFloat32();
            object.isLargeArc = inflow.getBool8();
            object.isPositiveSweep = inflow.getBool8();
            object.x = inflow.getFloat32();
            object.y = inflow.getFloat32();
            break;

        case 0x32:
            object.r = inflow.getFloat32();
            object.isLargeArc = inflow.getBool8();
            object.isPositiveSweep = inflow.getBool8();
            object.dx = inflow.getFloat32();
            object.dy = inflow.getFloat32();
            break;

        default: throw "Unsupported EXPLICIT serial code for IMAGE_SVG_PATH_ELEMENT: " + code;
    }

    return object;
}