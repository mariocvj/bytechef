package com.bytechef.component.slack.properties;

import com.bytechef.component.definition.ComponentDSL;

import static com.bytechef.component.definition.ComponentDSL.array;
import static com.bytechef.component.definition.ComponentDSL.bool;
import static com.bytechef.component.definition.ComponentDSL.object;
import static com.bytechef.component.definition.ComponentDSL.string;

public class SlackOutputProperties {
    private static String OK ="ok";
    private static String WARNING ="warning";
    private static String ERROR ="error";
    private static String NEEDED ="needed";
    private static String PROVIDED ="provided";
    private static String HTTP_RESPONSE_HEADERS ="httpResponseHeaders";
    private static String DEPRECATED_ARGUMENT ="deprecatedArgument";
    private static String ERRORS ="errors";
    private static String RESPONSE_METADATA ="responseMetadata";
    private static String CHANNEL ="channel";
    private static String TS ="ts";
    private static String MESSAGE ="message";
    private static String MESSAGES ="messages";
    private static String TYPE ="type";
    private static String SUBTYPE ="subtype";
    private static String TEAM ="team";
    private static String USER ="user";
    private static String USERNAME ="username";
    private static String TEXT ="text";
    private static String THREAD_TS ="threadTs";

    public static final ComponentDSL.ModifiableObjectProperty CHAT_POST_MESSAGE_RESPONSE_PROPERTY = object()
        .properties(
            bool(OK),
            string(WARNING),
            string(NEEDED),
            string(PROVIDED),
            array(HTTP_RESPONSE_HEADERS),
            string(DEPRECATED_ARGUMENT),
            array(ERRORS)
                .items(
                    string(ERROR)),
            object(RESPONSE_METADATA)
                .properties(
                    array(MESSAGES)
                        .items(
                            string(MESSAGE))),
            string(CHANNEL),
            string(TS),
            object(MESSAGE)
                .properties(
                    string(TYPE),
                    string(SUBTYPE),
                    string(TEAM),
                    string(CHANNEL),
                    string(USER),
                    string(USERNAME),
                    string(TEXT),
                    string(TS),
                    string(THREAD_TS)));
}
