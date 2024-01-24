/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.slack.action;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Option;
import com.bytechef.component.definition.OptionsDataSource;
import com.bytechef.component.definition.Parameters;
import com.slack.api.bolt.App;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.conversations.ConversationsListRequest;
import com.slack.api.methods.request.users.UsersListRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.methods.response.conversations.ConversationsListResponse;
import com.slack.api.methods.response.users.UsersListResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

import static com.bytechef.component.definition.Authorization.ACCESS_TOKEN;
import static com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.option;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.slack.constant.SlackConstants.CHANNEL_ID;
import static com.bytechef.component.slack.constant.SlackConstants.SEND_DIRECT_MESSAGE;
import static com.bytechef.component.slack.constant.SlackConstants.TEXT;
import static com.bytechef.component.slack.constant.SlackConstants.USER_ID;

/**
 * @author Mario Cvjetojevic
 */
public final class SlackSendDirectMessageAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(SEND_DIRECT_MESSAGE)
        .title("Send Direct Message")
        .description(
            "Sends a direct message to another user in a workspace. If it hasn't already, a direct message" +
                " conversation will be created.")
        .properties(
            string(TEXT)
                .label("Text")
                .description(
                    "The content of the message to be sent.")
                .required(true),
            string(USER_ID)
                .label("User")
                .description(
                    "The id of a user to send the direct message to.")
                .options((OptionsDataSource.ActionOptionsFunction) SlackSendDirectMessageAction::getUserOptions)
                .required(true))
        .outputSchema(string())
        .perform(SlackSendDirectMessageAction::perform);

    private SlackSendDirectMessageAction() {
    }

    public static ChatPostMessageResponse perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext)
        throws SlackApiException, IOException {

        return new App()
            .client()
            .chatPostMessage(ChatPostMessageRequest
                .builder()
                .token(connectionParameters.getRequiredString(ACCESS_TOKEN))
                .text(inputParameters.getRequiredString(TEXT))
                .channel(inputParameters.getRequiredString(USER_ID))
                .build());
    }

    public static List<Option<String>> getUserOptions(
        Parameters inputParameters, Parameters connectionParameters, String searchText, ActionContext context)
        throws IOException, SlackApiException {

        UsersListResponse response = new App()
            .client()
            .usersList(UsersListRequest
                .builder()
                .token(connectionParameters.getRequiredString(ACCESS_TOKEN))
                .build());

        List<Option<String>> options = response.getMembers().stream()
            .filter(user -> StringUtils.isNotEmpty(searchText) &&
                StringUtils.startsWith(user.getName(), searchText))
            .map(user -> (Option<String>) option(user.getName(), user.getId()))
            .toList();

        return options;
    }
}
