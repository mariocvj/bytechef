package com.bytechef.component.slack.connection;

import com.bytechef.component.definition.ComponentDSL;

import java.util.List;

import static com.bytechef.component.definition.Authorization.AuthorizationType.OAUTH2_AUTHORIZATION_CODE;
import static com.bytechef.component.definition.Authorization.CLIENT_ID;
import static com.bytechef.component.definition.Authorization.CLIENT_SECRET;
import static com.bytechef.component.definition.ComponentDSL.authorization;
import static com.bytechef.component.definition.ComponentDSL.connection;
import static com.bytechef.component.definition.ComponentDSL.string;

public class SlackConnection {
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
                .authorizationUrl((connection, context) -> "https://slack.com/oauth/authorize")
                .scopes((connection, context) -> List.of("channels:read", "channels:write", "channels:history",
                    "chat:write:bot", "groups:read", "reactions:read", "mpim:read","users:read"))
                .tokenUrl((connection, context) -> "https://slack.com/api/oauth.access"));

    private SlackConnection() {
    }
}
