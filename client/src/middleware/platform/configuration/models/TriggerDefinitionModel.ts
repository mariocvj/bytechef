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
import type { ComponentOutputSchemaModel } from './ComponentOutputSchemaModel';
import {
    ComponentOutputSchemaModelFromJSON,
    ComponentOutputSchemaModelFromJSONTyped,
    ComponentOutputSchemaModelToJSON,
} from './ComponentOutputSchemaModel';
import type { HelpModel } from './HelpModel';
import {
    HelpModelFromJSON,
    HelpModelFromJSONTyped,
    HelpModelToJSON,
} from './HelpModel';
import type { PropertyModel } from './PropertyModel';
import {
    PropertyModelFromJSON,
    PropertyModelFromJSONTyped,
    PropertyModelToJSON,
} from './PropertyModel';
import type { TriggerTypeModel } from './TriggerTypeModel';
import {
    TriggerTypeModelFromJSON,
    TriggerTypeModelFromJSONTyped,
    TriggerTypeModelToJSON,
} from './TriggerTypeModel';

/**
 * A trigger definition defines ways to trigger workflows from the outside services.
 * @export
 * @interface TriggerDefinitionModel
 */
export interface TriggerDefinitionModel {
    /**
     * The component name.
     * @type {string}
     * @memberof TriggerDefinitionModel
     */
    componentName?: string;
    /**
     * The component version.
     * @type {number}
     * @memberof TriggerDefinitionModel
     */
    componentVersion?: number;
    /**
     * The description.
     * @type {string}
     * @memberof TriggerDefinitionModel
     */
    description?: string;
    /**
     * Does trigger has defined dynamic editor description.
     * @type {boolean}
     * @memberof TriggerDefinitionModel
     */
    editorDescriptionDataSource?: boolean;
    /**
     * 
     * @type {HelpModel}
     * @memberof TriggerDefinitionModel
     */
    help?: HelpModel;
    /**
     * The action name.
     * @type {string}
     * @memberof TriggerDefinitionModel
     */
    name: string;
    /**
     * 
     * @type {ComponentOutputSchemaModel}
     * @memberof TriggerDefinitionModel
     */
    outputSchema?: ComponentOutputSchemaModel;
    /**
     * Does trigger has defined dynamic output schema.
     * @type {boolean}
     * @memberof TriggerDefinitionModel
     */
    outputSchemaDataSource?: boolean;
    /**
     * The list of action properties.
     * @type {Array<PropertyModel>}
     * @memberof TriggerDefinitionModel
     */
    properties?: Array<PropertyModel>;
    /**
     * The title
     * @type {string}
     * @memberof TriggerDefinitionModel
     */
    title?: string;
    /**
     * 
     * @type {TriggerTypeModel}
     * @memberof TriggerDefinitionModel
     */
    type: TriggerTypeModel;
}

/**
 * Check if a given object implements the TriggerDefinitionModel interface.
 */
export function instanceOfTriggerDefinitionModel(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "name" in value;
    isInstance = isInstance && "type" in value;

    return isInstance;
}

export function TriggerDefinitionModelFromJSON(json: any): TriggerDefinitionModel {
    return TriggerDefinitionModelFromJSONTyped(json, false);
}

export function TriggerDefinitionModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): TriggerDefinitionModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'componentName': !exists(json, 'componentName') ? undefined : json['componentName'],
        'componentVersion': !exists(json, 'componentVersion') ? undefined : json['componentVersion'],
        'description': !exists(json, 'description') ? undefined : json['description'],
        'editorDescriptionDataSource': !exists(json, 'editorDescriptionDataSource') ? undefined : json['editorDescriptionDataSource'],
        'help': !exists(json, 'help') ? undefined : HelpModelFromJSON(json['help']),
        'name': json['name'],
        'outputSchema': !exists(json, 'outputSchema') ? undefined : ComponentOutputSchemaModelFromJSON(json['outputSchema']),
        'outputSchemaDataSource': !exists(json, 'outputSchemaDataSource') ? undefined : json['outputSchemaDataSource'],
        'properties': !exists(json, 'properties') ? undefined : ((json['properties'] as Array<any>).map(PropertyModelFromJSON)),
        'title': !exists(json, 'title') ? undefined : json['title'],
        'type': TriggerTypeModelFromJSON(json['type']),
    };
}

export function TriggerDefinitionModelToJSON(value?: TriggerDefinitionModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'componentName': value.componentName,
        'componentVersion': value.componentVersion,
        'description': value.description,
        'editorDescriptionDataSource': value.editorDescriptionDataSource,
        'help': HelpModelToJSON(value.help),
        'name': value.name,
        'outputSchema': ComponentOutputSchemaModelToJSON(value.outputSchema),
        'outputSchemaDataSource': value.outputSchemaDataSource,
        'properties': value.properties === undefined ? undefined : ((value.properties as Array<any>).map(PropertyModelToJSON)),
        'title': value.title,
        'type': TriggerTypeModelToJSON(value.type),
    };
}

