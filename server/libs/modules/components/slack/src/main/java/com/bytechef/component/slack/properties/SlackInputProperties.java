package com.bytechef.component.slack.properties;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.OptionsDataSource;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.definition.Property;

import java.util.List;
import java.util.Map;

import static com.bytechef.component.definition.ComponentDSL.dynamicProperties;
import static com.bytechef.component.definition.ComponentDSL.option;
import static com.bytechef.component.definition.ComponentDSL.string;

public class SlackInputProperties {
    private static final String CONTENT_TYPE = "contentType";
    private static final String ATTACHMENTS = "attachments";
    private static final String BLOCKS = "blocks";
    public static final String TEXT = "text";
    public static final String CONTENT = "content";

    public static final List<Property> propertyList = List.of(
        string(CONTENT_TYPE)
            .label("Content type")
            .description("" +
                "One of these arguments is required to describe the content of the message. If attachments or blocks " +
                "are included, text will be used as fallback text for notifications only.")
            .options(
                option("Attachments", ATTACHMENTS,
                    "A JSON-based array of structured attachments, presented as a URL-encoded string."),
                option("Blocks", BLOCKS,
                    "A JSON-based array of structured blocks, presented as a URL-encoded string."),
                option("Text", TEXT,
                    "How this field works and whether it is required depends on other fields you use in your API call."))
            .required(true),
        dynamicProperties(CONTENT)
            .loadPropertiesDependsOn(CONTENT_TYPE)
            .properties(SlackInputProperties::getEventTypeProperties)
            .required(true));

    public static List<? extends Property.ValueProperty<?>> getEventTypeProperties(
        Parameters inputParameters, Parameters connectionParameters, ActionContext context) {

        String eventType = inputParameters.getString(CONTENT_TYPE);

        if (eventType.equals(ATTACHMENTS)) {
            return List.of(
                string(ATTACHMENTS)
                    .label("Attachments")
                    .description(
                        "A JSON-based array of structured attachments, presented as a URL-encoded string.")
                    .required(true));
        }

        if (eventType.equals(BLOCKS)) {
            return List.of(
                string(BLOCKS)
                    .label("Blocks")
                    .description(
                        "A JSON-based array of structured blocks, presented as a URL-encoded string.")
                    .required(true));
        }

        if (eventType.equals(TEXT)) {
            return List.of(
                string(TEXT)
                    .label("Text")
                    .description(
                        "How this field works and whether it is required depends on other fields you use in your API call.")
                    .required(true));
        }


        return List.of();
    }
}
