
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

package com.bytechef.hermes.component.definition;

import com.bytechef.hermes.component.Context;
import com.bytechef.hermes.component.InputParameters;
import com.bytechef.hermes.definition.Display;
import com.bytechef.hermes.definition.Property;
import com.bytechef.hermes.definition.Resources;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Ivica Cardic
 */
@JsonDeserialize(as = ComponentDSL.ModifiableActionDefinition.class)
public sealed interface ActionDefinition permits ComponentDSL.ModifiableActionDefinition {

    Boolean getBatch();

    String getComponentName();

    Display getDisplay();

    Object getExampleOutput();

    ExampleOutputDataSource getExampleOutputDataSource();

    Map<String, Object> getMetadata();

    String getName();

    List<? extends Property<?>> getOutputSchema();

    OutputSchemaDataSource getOutputSchemaDataSource();

    List<? extends Property<?>> getProperties();

    /**
     * The code that should be executed when an action runs as a task inside the workflow engine.
     *
     * @return an optional execute function implementation
     */
    Optional<ExecuteFunction> getExecute();

    Resources getResources();

    /**
     *
     */
    @FunctionalInterface
    interface ExecuteFunction {

        /**
         *
         * @param context
         * @param inputParameters
         * @return
         */
        Object apply(Context context, InputParameters inputParameters);
    }
}
