package com.bytechef.component.xero.connection;

import com.bytechef.component.definition.ComponentDSL;

import java.util.List;

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
                .authorizationUrl((connection, context) -> "https://login.xero.com/identity/connect/authorize")
                .scopes((connection, context) -> List.of("accounting.contacts", "accounting.transactions"))
                .tokenUrl((connection, context) -> "https://identity.xero.com/connect/token"));

    private XeroConnection() {
    }
}
