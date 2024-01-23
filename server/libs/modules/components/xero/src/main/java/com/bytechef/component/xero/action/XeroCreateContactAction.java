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

package com.bytechef.component.xero.action;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;

import static com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.xero.constant.XeroConstants.CREATE_CONTACT;

/**
 * @author Mario Cvjetojevic
 */
public final class XeroCreateContactAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(CREATE_CONTACT)
        .title("Send Message")
        .description("Description")
        .properties()
        .outputSchema(string())
        .perform(XeroCreateContactAction::perform);

    private XeroCreateContactAction() {
    }

    public static Object perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext) {


        return null;
    }
}
