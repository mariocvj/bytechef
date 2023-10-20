/* tslint:disable */
/* eslint-disable */
/**
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { AuthorizationType } from './AuthorizationType';
import {
    AuthorizationTypeFromJSON,
    AuthorizationTypeFromJSONTyped,
    AuthorizationTypeToJSON,
} from './AuthorizationType';
import type { Display } from './Display';
import {
    DisplayFromJSON,
    DisplayFromJSONTyped,
    DisplayToJSON,
} from './Display';
import type { ValueProperty } from './ValueProperty';
import {
    ValuePropertyFromJSON,
    ValuePropertyFromJSONTyped,
    ValuePropertyToJSON,
} from './ValueProperty';

/**
 * Contains information required for a connection's authorization.
 * @export
 * @interface Authorization
 */
export interface Authorization {
    /**
     * 
     * @type {Display}
     * @memberof Authorization
     */
    display?: Display;
    /**
     * The authorization name.
     * @type {string}
     * @memberof Authorization
     */
    name?: string;
    /**
     * Properties of the connection.
     * @type {Array<ValueProperty>}
     * @memberof Authorization
     */
    properties?: Array<ValueProperty>;
    /**
     * 
     * @type {AuthorizationType}
     * @memberof Authorization
     */
    type?: AuthorizationType;
}

/**
 * Check if a given object implements the Authorization interface.
 */
export function instanceOfAuthorization(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function AuthorizationFromJSON(json: any): Authorization {
    return AuthorizationFromJSONTyped(json, false);
}

export function AuthorizationFromJSONTyped(json: any, ignoreDiscriminator: boolean): Authorization {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'display': !exists(json, 'display') ? undefined : DisplayFromJSON(json['display']),
        'name': !exists(json, 'name') ? undefined : json['name'],
        'properties': !exists(json, 'properties') ? undefined : ((json['properties'] as Array<any>).map(ValuePropertyFromJSON)),
        'type': !exists(json, 'type') ? undefined : AuthorizationTypeFromJSON(json['type']),
    };
}

export function AuthorizationToJSON(value?: Authorization | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'display': DisplayToJSON(value.display),
        'name': value.name,
        'properties': value.properties === undefined ? undefined : ((value.properties as Array<any>).map(ValuePropertyToJSON)),
        'type': AuthorizationTypeToJSON(value.type),
    };
}

