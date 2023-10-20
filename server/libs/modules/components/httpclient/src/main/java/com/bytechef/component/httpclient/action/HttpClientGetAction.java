
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

package com.bytechef.component.httpclient.action;

import com.bytechef.component.httpclient.constant.HttpClientConstants;
import com.bytechef.component.httpclient.util.HttpClientActionUtils;
import com.bytechef.hermes.component.definition.ActionDefinition;
import com.bytechef.hermes.component.definition.ComponentDSL.ModifiableActionDefinition;
import com.bytechef.hermes.component.definition.ParameterMap;

import static com.bytechef.component.httpclient.constant.HttpClientConstants.GET;
import static com.bytechef.hermes.component.definition.Context.Http.RequestMethod;
import static com.bytechef.hermes.component.definition.ComponentDSL.action;

/**
 * @author Ivica Cardic
 */
public class HttpClientGetAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(GET)
        .title("GET")
        .description("The request method to use.")
        .properties(
            HttpClientActionUtils.toArray(
                //
                // Common properties
                //

                HttpClientConstants.COMMON_PROPERTIES))
        .outputSchema(HttpClientConstants.OUTPUT_PROPERTIES)
        .perform(HttpClientDeleteAction::perform);

    protected static Object perform(
        ParameterMap inputParameters, ParameterMap connectionParameters, ActionDefinition.ActionContext context) {

        return HttpClientActionUtils.execute(inputParameters, RequestMethod.GET, context);
    }
}
