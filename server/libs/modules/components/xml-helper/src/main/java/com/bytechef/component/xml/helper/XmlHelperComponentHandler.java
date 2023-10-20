/*
 * Copyright 2021 <your company/name>.
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

package com.bytechef.component.xml.helper;

import static com.bytechef.component.xml.helper.constants.XmlHelperConstants.SOURCE;
import static com.bytechef.component.xml.helper.constants.XmlHelperConstants.XML_HELPER;
import static com.bytechef.component.xml.helper.constants.XmlHelperConstants.XML_PARSE;
import static com.bytechef.component.xml.helper.constants.XmlHelperConstants.XML_STRINGIFY;
import static com.bytechef.hermes.component.ComponentDSL.action;
import static com.bytechef.hermes.component.ComponentDSL.any;
import static com.bytechef.hermes.component.ComponentDSL.array;
import static com.bytechef.hermes.component.ComponentDSL.createComponent;
import static com.bytechef.hermes.component.ComponentDSL.display;
import static com.bytechef.hermes.component.ComponentDSL.object;
import static com.bytechef.hermes.component.ComponentDSL.string;

import com.bytechef.commons.xml.XmlUtils;
import com.bytechef.hermes.component.ComponentHandler;
import com.bytechef.hermes.component.Context;
import com.bytechef.hermes.component.ExecutionParameters;
import com.bytechef.hermes.component.definition.ComponentDefinition;
import java.util.Map;

/**
 * @author Ivica Cardic
 */
public class XmlHelperComponentHandler implements ComponentHandler {

    private final ComponentDefinition componentDefinition = createComponent(XML_HELPER)
            .display(display("XML Helper").description("Converts between XML string and object/array."))
            .actions(
                    action(XML_PARSE)
                            .display(display("Convert from XML string")
                                    .description("Converts the XML string to object/array."))
                            .inputs(string(SOURCE)
                                    .label("Source")
                                    .description("The XML string to convert to the data.")
                                    .required(true))
                            .outputSchema(object())
                            .performFunction(this::performParse),
                    action(XML_STRINGIFY)
                            .display(display("Convert to XML string")
                                    .description("Writes the object/array to a XML string."))
                            .inputs(any(SOURCE)
                                    .label("Source")
                                    .description("The data to convert to XML string.")
                                    .required(true)
                                    .types(array(), object()))
                            .outputSchema(string())
                            .performFunction(this::performStringify));

    @Override
    public ComponentDefinition getDefinition() {
        return componentDefinition;
    }

    protected Map<String, ?> performParse(Context context, ExecutionParameters executionParameters) {
        String input = executionParameters.getRequiredString(SOURCE);

        return XmlUtils.read(input);
    }

    protected String performStringify(Context context, ExecutionParameters executionParameters) {
        Object input = executionParameters.getRequiredObject(SOURCE);

        return XmlUtils.write(input);
    }
}
