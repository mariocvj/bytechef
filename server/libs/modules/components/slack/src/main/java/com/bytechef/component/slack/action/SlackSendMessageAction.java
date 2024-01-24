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
import com.slack.api.RequestConfigurator;
import com.slack.api.bolt.App;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.conversations.ConversationsListRequest;
import com.slack.api.methods.request.oauth.OAuthTokenRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.methods.response.conversations.ConversationsListResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

import static com.bytechef.component.definition.Authorization.ACCESS_TOKEN;
import static com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.dynamicProperties;
import static com.bytechef.component.definition.ComponentDSL.option;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.slack.constant.SlackConstants.CHANNEL_ID;
import static com.bytechef.component.slack.constant.SlackConstants.SEND_MESSAGE;
import static com.bytechef.component.slack.constant.SlackConstants.TEXT;

/**
 * @author Mario Cvjetojevic
 */
public final class SlackSendMessageAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(SEND_MESSAGE)
        .title("Send Message")
        .description(
            "Posts a message to a public channel, private channel, or existing direct message conversation.")
        .properties(
            string(TEXT)
                .label("Text")
                .description(
                    "The content of the message to be sent.")
                .required(true),
            string(TEXT)
                .label("Channel")
                .description(
                    "The id of a channel where the message will be sent.")
                .options((OptionsDataSource.ActionOptionsFunction) SlackSendMessageAction::getChannelOptions)
                .required(true))
        .outputSchema(string())
        .perform(SlackSendMessageAction::perform);

    private SlackSendMessageAction() {
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
                .channel(inputParameters.getRequiredString(CHANNEL_ID))
                .build());
    }

    public static List<Option<String>> getChannelOptions(
        Parameters inputParameters, Parameters connectionParameters, String searchText, ActionContext context)
        throws IOException, SlackApiException {

        ConversationsListResponse response = new App()
            .client()
            .conversationsList(ConversationsListRequest
                .builder()
                .token(connectionParameters.getRequiredString(ACCESS_TOKEN))
                .build());

        List<Option<String>> options = response.getChannels().stream()
            .filter(channel -> StringUtils.isNotEmpty(searchText) &&
                StringUtils.startsWith(channel.getName(), searchText))
            .map(channel -> (Option<String>) option(channel.getName(), channel.getId()))
            .toList();

        return options;
    }
}
