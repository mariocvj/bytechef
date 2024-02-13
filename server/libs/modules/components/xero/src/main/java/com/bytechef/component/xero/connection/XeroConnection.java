package com.bytechef.component.xero.connection;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Authorization;
import com.bytechef.component.definition.Authorization.ApplyResponse;
import com.bytechef.component.definition.ComponentDSL;
import com.bytechef.component.definition.Context;
import com.bytechef.component.definition.Parameters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.bytechef.component.definition.Authorization.ACCESS_TOKEN;
import static com.bytechef.component.definition.Authorization.AUTHORIZATION;
import static com.bytechef.component.definition.Authorization.AuthorizationType.OAUTH2_AUTHORIZATION_CODE;
import static com.bytechef.component.definition.Authorization.CLIENT_ID;
import static com.bytechef.component.definition.Authorization.CLIENT_SECRET;
import static com.bytechef.component.definition.ComponentDSL.authorization;
import static com.bytechef.component.definition.ComponentDSL.connection;
import static com.bytechef.component.definition.ComponentDSL.string;

public class XeroConnection {
    public static final ComponentDSL.ModifiableConnectionDefinition CONNECTION_DEFINITION = connection()
        .authorizations(
            authorization(OAUTH2_AUTHORIZATION_CODE.toLowerCase(), OAUTH2_AUTHORIZATION_CODE)
                .title("OAuth2 Authorization Code")
                .properties(
                    string(CLIENT_ID)
                        .label("Client Id")
                        .required(true),
                    string(CLIENT_SECRET)
                        .label("Client Secret")
                        .required(true))
                .apply(XeroConnection::getApplyResponse)
                .authorizationUrl((connection, context) -> "https://login.xero.com/identity/connect/authorize")
                .scopes((connection, context) -> List.of("accounting.contacts", "accounting.transactions"))
                .tokenUrl((connection, context) -> "https://identity.xero.com/connect/token"));

    private static ApplyResponse getApplyResponse(Parameters connectionParameters, Context context) {
        return ApplyResponse.ofHeaders(
            Map.of(
                AUTHORIZATION, List.of("OAuth " + connectionParameters.getRequiredString(ACCESS_TOKEN)),
                "Xero-tenant-id", List.of(getTenantId(connectionParameters.getRequiredString(ACCESS_TOKEN), context))
            )
        );
    }

    private XeroConnection() {
    }

    //todo: prebaciti metodu u definiciju konekcije
    public static String getTenantId(String accesToken, Context context) {
        Context.Http.Response response = context
            .http(http -> http.get("https://api.xero.com/connections"))
            .body(
                Context.Http.Body.of(
                    Map.of(
                        "Authorization", "Bearer " + accesToken,
                        "Content-Type", "application/json")))
            .configuration(Context.Http.responseType(Context.Http.ResponseType.JSON))
            .execute();

        Object body = response.getBody();
        if (body instanceof LinkedHashMap<?,?>){
            return ((LinkedHashMap<String,String>) body).get("tenantId");
        }

        if (body instanceof ArrayList<?>){
            ArrayList<Object> tenantList = (ArrayList) response.getBody();

            if (tenantList.get(0) instanceof LinkedHashMap<?,?>) {
                return ((LinkedHashMap<String, String>) tenantList.get(0)).get("tenantId");
            }
        }
        return null;
    }
}
