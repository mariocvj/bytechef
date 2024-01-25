package com.bytechef.component.slack.action;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;
import com.slack.api.bolt.App;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import org.junit.jupiter.api.AfterEach;
import org.mockito.ArgumentCaptor;

import java.io.IOException;

import static com.bytechef.component.definition.Authorization.ACCESS_TOKEN;
import static com.bytechef.component.slack.constant.SlackConstants.CHANNEL_ID;
import static com.bytechef.component.slack.constant.SlackConstants.TEXT;
import static com.bytechef.component.slack.properties.SlackInputProperties.AS_USER;
import static com.bytechef.component.slack.properties.SlackInputProperties.ATTACHMENTS;
import static com.bytechef.component.slack.properties.SlackInputProperties.BLOCKS;
import static com.bytechef.component.slack.properties.SlackInputProperties.ICON_EMOJI;
import static com.bytechef.component.slack.properties.SlackInputProperties.ICON_URL;
import static com.bytechef.component.slack.properties.SlackInputProperties.LINK_NAMES;
import static com.bytechef.component.slack.properties.SlackInputProperties.METADATA;
import static com.bytechef.component.slack.properties.SlackInputProperties.MRKDWN;
import static com.bytechef.component.slack.properties.SlackInputProperties.PARSE;
import static com.bytechef.component.slack.properties.SlackInputProperties.REPLY_BROADCAST;
import static com.bytechef.component.slack.properties.SlackInputProperties.THREAD_TS;
import static com.bytechef.component.slack.properties.SlackInputProperties.UNFURL_LINKS;
import static com.bytechef.component.slack.properties.SlackInputProperties.UNFURL_MEDIA;
import static com.bytechef.component.slack.properties.SlackInputProperties.USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AbstractSlackActionTest {
    protected App mockedApp = mock(App.class);
    protected MethodsClient mockedMethodsClient = mock(MethodsClient.class);
    protected ActionContext mockedContext = mock(ActionContext.class);
    protected Parameters mockedParameters = mock(Parameters.class);
    protected ArgumentCaptor<ChatPostMessageRequest> requestArgumentCaptor =
        ArgumentCaptor.forClass(ChatPostMessageRequest.class);


    protected void beforeTestPerform() throws IOException {
        when(mockedParameters.getRequiredString(ACCESS_TOKEN))
            .thenReturn(ACCESS_TOKEN);
        when(mockedParameters.getRequiredString(CHANNEL_ID))
            .thenReturn(CHANNEL_ID);
        when(mockedParameters.getString(ATTACHMENTS))
            .thenReturn(ATTACHMENTS);
        when(mockedParameters.getString(BLOCKS))
            .thenReturn(BLOCKS);
        when(mockedParameters.getString(TEXT))
            .thenReturn(TEXT);
        when(mockedParameters.getBoolean(AS_USER))
            .thenReturn(true);
        when(mockedParameters.getString(ICON_EMOJI))
            .thenReturn(ICON_EMOJI);
        when(mockedParameters.getString(ICON_URL))
            .thenReturn(ICON_URL);
        when(mockedParameters.getBoolean(LINK_NAMES))
            .thenReturn(true);
        when(mockedParameters.getString(METADATA))
            .thenReturn(METADATA);
        when(mockedParameters.getBoolean(MRKDWN))
            .thenReturn(true);
        when(mockedParameters.getString(PARSE))
            .thenReturn(PARSE);
        when(mockedParameters.getBoolean(REPLY_BROADCAST))
            .thenReturn(true);
        when(mockedParameters.getString(THREAD_TS))
            .thenReturn(THREAD_TS);
        when(mockedParameters.getBoolean(UNFURL_LINKS))
            .thenReturn(true);
        when(mockedParameters.getBoolean(UNFURL_MEDIA))
            .thenReturn(true);
        when(mockedParameters.getString(USERNAME))
            .thenReturn(USERNAME);
    }

    @AfterEach
    protected void afterTestPerform() throws IOException {
        assertEquals(true, requestArgumentCaptor.getValue().getAttachmentsAsString());
        assertEquals(true, requestArgumentCaptor.getValue().getBlocksAsString());
        assertEquals("", requestArgumentCaptor.getValue().);
        assertEquals("", requestArgumentCaptor.getValue().);
        assertEquals("", requestArgumentCaptor.getValue().);
        assertEquals("", requestArgumentCaptor.getValue().);
        assertEquals("", requestArgumentCaptor.getValue().);
        assertEquals("", requestArgumentCaptor.getValue().);
        assertEquals("", requestArgumentCaptor.getValue().);
        assertEquals("", requestArgumentCaptor.getValue().);

//        verify(mockedCreate, times(1))
//            .execute();
    }
}
