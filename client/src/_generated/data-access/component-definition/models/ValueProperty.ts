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
import type { DisplayOption } from './DisplayOption';
import {
    DisplayOptionFromJSON,
    DisplayOptionFromJSONTyped,
    DisplayOptionToJSON,
} from './DisplayOption';
import type { PropertyType } from './PropertyType';
import {
    PropertyTypeFromJSON,
    PropertyTypeFromJSONTyped,
    PropertyTypeToJSON,
} from './PropertyType';

/**
 * 
 * @export
 * @interface ValueProperty
 */
export interface ValueProperty {
    /**
     * 
     * @type {object}
     * @memberof ValueProperty
     */
    defaultValue?: object;
    /**
     * 
     * @type {object}
     * @memberof ValueProperty
     */
    exampleValue?: object;
    /**
     * 
     * @type {Array<string>}
     * @memberof ValueProperty
     */
    loadOptionsDependsOn?: Array<string>;
    /**
     * 
     * @type {string}
     * @memberof ValueProperty
     */
    loadOptionsMethod?: string;
    /**
     * 
     * @type {string}
     * @memberof ValueProperty
     */
    description?: string;
    /**
     * 
     * @type {DisplayOption}
     * @memberof ValueProperty
     */
    displayOption?: DisplayOption;
    /**
     * 
     * @type {string}
     * @memberof ValueProperty
     */
    label?: string;
    /**
     * 
     * @type {string}
     * @memberof ValueProperty
     */
    name?: string;
    /**
     * 
     * @type {string}
     * @memberof ValueProperty
     */
    placeholder?: string;
    /**
     * 
     * @type {PropertyType}
     * @memberof ValueProperty
     */
    type?: PropertyType;
}

/**
 * Check if a given object implements the ValueProperty interface.
 */
export function instanceOfValueProperty(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function ValuePropertyFromJSON(json: any): ValueProperty {
    return ValuePropertyFromJSONTyped(json, false);
}

export function ValuePropertyFromJSONTyped(json: any, ignoreDiscriminator: boolean): ValueProperty {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'defaultValue': !exists(json, 'defaultValue') ? undefined : json['defaultValue'],
        'exampleValue': !exists(json, 'exampleValue') ? undefined : json['exampleValue'],
        'loadOptionsDependsOn': !exists(json, 'loadOptionsDependsOn') ? undefined : json['loadOptionsDependsOn'],
        'loadOptionsMethod': !exists(json, 'loadOptionsMethod') ? undefined : json['loadOptionsMethod'],
        'description': !exists(json, 'description') ? undefined : json['description'],
        'displayOption': !exists(json, 'displayOption') ? undefined : DisplayOptionFromJSON(json['displayOption']),
        'label': !exists(json, 'label') ? undefined : json['label'],
        'name': !exists(json, 'name') ? undefined : json['name'],
        'placeholder': !exists(json, 'placeholder') ? undefined : json['placeholder'],
        'type': !exists(json, 'type') ? undefined : PropertyTypeFromJSON(json['type']),
    };
}

export function ValuePropertyToJSON(value?: ValueProperty | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'defaultValue': value.defaultValue,
        'exampleValue': value.exampleValue,
        'loadOptionsDependsOn': value.loadOptionsDependsOn,
        'loadOptionsMethod': value.loadOptionsMethod,
        'description': value.description,
        'displayOption': DisplayOptionToJSON(value.displayOption),
        'label': value.label,
        'name': value.name,
        'placeholder': value.placeholder,
        'type': PropertyTypeToJSON(value.type),
    };
}

