/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Configuration API
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
import type { PropertyModel } from './PropertyModel';
import {
    PropertyModelFromJSON,
    PropertyModelFromJSONTyped,
    PropertyModelToJSON,
} from './PropertyModel';
import type { ResourcesModel } from './ResourcesModel';
import {
    ResourcesModelFromJSON,
    ResourcesModelFromJSONTyped,
    ResourcesModelToJSON,
} from './ResourcesModel';
import type { TaskDispatcherOutputSchemaModel } from './TaskDispatcherOutputSchemaModel';
import {
    TaskDispatcherOutputSchemaModelFromJSON,
    TaskDispatcherOutputSchemaModelFromJSONTyped,
    TaskDispatcherOutputSchemaModelToJSON,
} from './TaskDispatcherOutputSchemaModel';

/**
 * A task dispatcher defines a strategy for dispatching tasks to be executed.
 * @export
 * @interface TaskDispatcherDefinitionModel
 */
export interface TaskDispatcherDefinitionModel {
    /**
     * The description.
     * @type {string}
     * @memberof TaskDispatcherDefinitionModel
     */
    description?: string;
    /**
     * The icon.
     * @type {string}
     * @memberof TaskDispatcherDefinitionModel
     */
    icon?: string;
    /**
     * The task dispatcher name..
     * @type {string}
     * @memberof TaskDispatcherDefinitionModel
     */
    name: string;
    /**
     * 
     * @type {TaskDispatcherOutputSchemaModel}
     * @memberof TaskDispatcherDefinitionModel
     */
    outputSchema?: TaskDispatcherOutputSchemaModel;
    /**
     * The list of task dispatcher properties.
     * @type {Array<PropertyModel>}
     * @memberof TaskDispatcherDefinitionModel
     */
    properties?: Array<PropertyModel>;
    /**
     * 
     * @type {ResourcesModel}
     * @memberof TaskDispatcherDefinitionModel
     */
    resources?: ResourcesModel;
    /**
     * Properties used to define tasks to be dispatched.
     * @type {Array<PropertyModel>}
     * @memberof TaskDispatcherDefinitionModel
     */
    taskProperties?: Array<PropertyModel>;
    /**
     * The title
     * @type {string}
     * @memberof TaskDispatcherDefinitionModel
     */
    title?: string;
    /**
     * Properties used to define tasks to be dispatched.
     * @type {Array<PropertyModel>}
     * @memberof TaskDispatcherDefinitionModel
     */
    variableProperties?: Array<PropertyModel>;
    /**
     * The version of a task dispatcher.
     * @type {number}
     * @memberof TaskDispatcherDefinitionModel
     */
    version: number;
}

/**
 * Check if a given object implements the TaskDispatcherDefinitionModel interface.
 */
export function instanceOfTaskDispatcherDefinitionModel(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "name" in value;
    isInstance = isInstance && "version" in value;

    return isInstance;
}

export function TaskDispatcherDefinitionModelFromJSON(json: any): TaskDispatcherDefinitionModel {
    return TaskDispatcherDefinitionModelFromJSONTyped(json, false);
}

export function TaskDispatcherDefinitionModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): TaskDispatcherDefinitionModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'description': !exists(json, 'description') ? undefined : json['description'],
        'icon': !exists(json, 'icon') ? undefined : json['icon'],
        'name': json['name'],
        'outputSchema': !exists(json, 'outputSchema') ? undefined : TaskDispatcherOutputSchemaModelFromJSON(json['outputSchema']),
        'properties': !exists(json, 'properties') ? undefined : ((json['properties'] as Array<any>).map(PropertyModelFromJSON)),
        'resources': !exists(json, 'resources') ? undefined : ResourcesModelFromJSON(json['resources']),
        'taskProperties': !exists(json, 'taskProperties') ? undefined : ((json['taskProperties'] as Array<any>).map(PropertyModelFromJSON)),
        'title': !exists(json, 'title') ? undefined : json['title'],
        'variableProperties': !exists(json, 'variableProperties') ? undefined : ((json['variableProperties'] as Array<any>).map(PropertyModelFromJSON)),
        'version': json['version'],
    };
}

export function TaskDispatcherDefinitionModelToJSON(value?: TaskDispatcherDefinitionModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'description': value.description,
        'icon': value.icon,
        'name': value.name,
        'outputSchema': TaskDispatcherOutputSchemaModelToJSON(value.outputSchema),
        'properties': value.properties === undefined ? undefined : ((value.properties as Array<any>).map(PropertyModelToJSON)),
        'resources': ResourcesModelToJSON(value.resources),
        'taskProperties': value.taskProperties === undefined ? undefined : ((value.taskProperties as Array<any>).map(PropertyModelToJSON)),
        'title': value.title,
        'variableProperties': value.variableProperties === undefined ? undefined : ((value.variableProperties as Array<any>).map(PropertyModelToJSON)),
        'version': value.version,
    };
}

