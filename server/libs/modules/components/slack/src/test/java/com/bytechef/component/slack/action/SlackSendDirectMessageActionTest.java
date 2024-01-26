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

import com.bytechef.component.definition.Option;
import com.slack.api.bolt.App;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.conversations.ConversationsListRequest;
import com.slack.api.methods.request.users.UsersListRequest;
import com.slack.api.methods.response.conversations.ConversationsListResponse;
import com.slack.api.methods.response.users.UsersListResponse;
import com.slack.api.model.Conversation;
import com.slack.api.model.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.bytechef.component.slack.constant.SlackConstants.CHANNEL_ID;
import static com.bytechef.component.slack.constant.SlackConstants.USER_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Mario Cvjetojevic
 */
public class SlackSendDirectMessageActionTest extends AbstractSlackActionTest {

    protected MethodsClient mockedMethodsClient = mock(MethodsClient.class);

    @Test
    public void testPerform() throws SlackApiException, IOException {
        beforeTestPerform();

        Mockito.mockConstruction(App.class, (mock, context) -> {
            when(mock.client()).thenReturn(mockedMethodsClient);
        });

        when(mockedParameters.getRequiredString(USER_ID))
            .thenReturn(USER_ID);

        SlackSendDirectMessageAction.perform(mockedParameters, mockedParameters, mockedContext);

        verify(mockedMethodsClient, times(1))
            .chatPostMessage(chatPostMessageRequestArgumentCaptor.capture());

        assertEquals(USER_ID, chatPostMessageRequestArgumentCaptor.getValue().getChannel());

        afterTestPerform();
    }


    @Test
    public void testGetUserOptions() throws IOException, SlackApiException {
        UsersListResponse usersListResponse = mock(UsersListResponse.class);
        List<User> mockedUserList = Arrays.asList(
            mock(User.class),
            mock(User.class),
            mock(User.class),
            mock(User.class));

        Mockito.mockConstruction(App.class, (mock, context) -> {
            when(mock.client()).thenReturn(mockedMethodsClient);
        });

        when(mockedMethodsClient.usersList(any(UsersListRequest.class)))
            .thenReturn(usersListResponse);

        when(usersListResponse.getMembers())
            .thenReturn(mockedUserList);

        mockedUserList.forEach(user ->
            when(user.getName())
                .thenReturn("NOT searched text"));

        when(mockedUserList.get(0)
            .getName())
            .thenReturn(SEARCH_TEXT + " more text");

        List<Option<String>> options = SlackSendDirectMessageAction
            .getUserOptions(mockedParameters, mockedParameters, SEARCH_TEXT, mockedContext);

        verify(mockedMethodsClient, times(1))
            .usersList(any(UsersListRequest.class));

        assertEquals(1, options.size());

        options.forEach(option -> assertTrue(StringUtils.startsWith(option.getLabel(), SEARCH_TEXT)));
    }
}
