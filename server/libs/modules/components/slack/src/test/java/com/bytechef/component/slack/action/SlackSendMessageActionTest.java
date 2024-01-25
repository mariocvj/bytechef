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

import com.slack.api.bolt.App;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Mario Cvjetojevic
 */
public class SlackSendMessageActionTest extends AbstractSlackActionTest{

    protected MethodsClient mockedMethodsClient = mock(MethodsClient.class);

    @Test
    public void testPerform() throws SlackApiException, IOException {
//
        try(MockedConstruction<App> mockedApp = Mockito.mockConstruction(App.class,(mock, context)-> {
            when(mock.client()).thenReturn(mockedMethodsClient);
        })){

            SlackSendMessageAction.perform(mockedParameters,mockedParameters,mockedContext);

            verify(mockedMethodsClient, times(1))
                .chatPostMessage(requestArgumentCaptor.capture());
        }
    }
}
