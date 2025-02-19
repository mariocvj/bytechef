/* tslint:disable */
/* eslint-disable */
/**
 * The Definition API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


/**
 * Authorization type.
 * @export
 */
export const AuthorizationTypeModel = {
    ApiKey: 'API_KEY',
    BasicAuth: 'BASIC_AUTH',
    BearerToken: 'BEARER_TOKEN',
    Custom: 'CUSTOM',
    DigestAuth: 'DIGEST_AUTH',
    Oauth2AuthorizationCode: 'OAUTH2_AUTHORIZATION_CODE',
    Oauth2AuthorizationCodePkce: 'OAUTH2_AUTHORIZATION_CODE_PKCE',
    Oauth2ClientCredentials: 'OAUTH2_CLIENT_CREDENTIALS',
    Oauth2ImplicitCode: 'OAUTH2_IMPLICIT_CODE',
    Oauth2ResourceOwnerPassword: 'OAUTH2_RESOURCE_OWNER_PASSWORD'
} as const;
export type AuthorizationTypeModel = typeof AuthorizationTypeModel[keyof typeof AuthorizationTypeModel];


export function AuthorizationTypeModelFromJSON(json: any): AuthorizationTypeModel {
    return AuthorizationTypeModelFromJSONTyped(json, false);
}

export function AuthorizationTypeModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): AuthorizationTypeModel {
    return json as AuthorizationTypeModel;
}

export function AuthorizationTypeModelToJSON(value?: AuthorizationTypeModel | null): any {
    return value as any;
}

