/* tslint:disable */
/* eslint-disable */
/**
 * The Automation Configuration API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface WorkflowRequestModel
 */
export interface WorkflowRequestModel {
    /**
     * The definition of a workflow.
     * @type {string}
     * @memberof WorkflowRequestModel
     */
    definition: string;
}

/**
 * Check if a given object implements the WorkflowRequestModel interface.
 */
export function instanceOfWorkflowRequestModel(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "definition" in value;

    return isInstance;
}

export function WorkflowRequestModelFromJSON(json: any): WorkflowRequestModel {
    return WorkflowRequestModelFromJSONTyped(json, false);
}

export function WorkflowRequestModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): WorkflowRequestModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'definition': json['definition'],
    };
}

export function WorkflowRequestModelToJSON(value?: WorkflowRequestModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'definition': value.definition,
    };
}

