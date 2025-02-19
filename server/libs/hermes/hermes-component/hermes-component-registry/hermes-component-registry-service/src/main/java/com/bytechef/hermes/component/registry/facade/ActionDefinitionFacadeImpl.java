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

package com.bytechef.hermes.component.registry.facade;

import com.bytechef.hermes.component.definition.factory.ContextFactory;
import com.bytechef.hermes.component.registry.domain.ComponentConnection;
import com.bytechef.hermes.component.registry.domain.EditorDescriptionResponse;
import com.bytechef.hermes.component.registry.domain.OptionsResponse;
import com.bytechef.hermes.component.registry.domain.OutputSchemaResponse;
import com.bytechef.hermes.component.registry.domain.PropertiesResponse;
import com.bytechef.hermes.component.registry.domain.SampleOutputResponse;
import com.bytechef.hermes.component.registry.service.ActionDefinitionService;
import com.bytechef.hermes.connection.domain.Connection;
import com.bytechef.hermes.connection.service.ConnectionService;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Map;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Ivica Cardic
 */
@Service("actionDefinitionFacade")
public class ActionDefinitionFacadeImpl implements ActionDefinitionFacade {

    private final ConnectionService connectionService;
    private final ContextFactory contextFactory;
    private final ActionDefinitionService actionDefinitionService;

    @SuppressFBWarnings("EI")
    public ActionDefinitionFacadeImpl(
        ConnectionService connectionService, ContextFactory contextFactory,
        ActionDefinitionService actionDefinitionService) {

        this.contextFactory = contextFactory;
        this.actionDefinitionService = actionDefinitionService;
        this.connectionService = connectionService;
    }

    @Override
    public PropertiesResponse executeDynamicProperties(
        @NonNull String componentName, int componentVersion, @NonNull String actionName, @NonNull String propertyName,
        Map<String, Object> inputParameters, Long connectionId) {

        ComponentConnection componentConnection = getComponentConnection(connectionId);

        return actionDefinitionService.executeDynamicProperties(
            componentName, componentVersion, actionName, propertyName, inputParameters, componentConnection,
            contextFactory.createActionContext(
                componentName, componentVersion, actionName, null, null, null, null, componentConnection));
    }

    @Override
    public EditorDescriptionResponse executeEditorDescription(
        @NonNull String componentName, int componentVersion, @NonNull String actionName,
        @NonNull Map<String, Object> inputParameters, Long connectionId) {

        ComponentConnection componentConnection = getComponentConnection(connectionId);

        return actionDefinitionService.executeEditorDescription(
            componentName, componentVersion, actionName, inputParameters, componentConnection,
            contextFactory.createActionContext(
                componentName, componentVersion, actionName, null, null, null, null, componentConnection));
    }

    @Override
    public OptionsResponse executeOptions(
        @NonNull String componentName, int componentVersion, @NonNull String actionName, @NonNull String propertyName,
        @NonNull Map<String, Object> inputParameters, Long connectionId, String searchText) {

        ComponentConnection componentConnection = getComponentConnection(connectionId);

        return actionDefinitionService.executeOptions(
            componentName, componentVersion, actionName, propertyName, inputParameters, searchText,
            componentConnection,
            contextFactory.createActionContext(
                componentName, componentVersion, actionName, null, null, null, null, componentConnection));
    }

    @Override
    public OutputSchemaResponse executeOutputSchema(
        @NonNull String componentName, int componentVersion, @NonNull String actionName,
        @NonNull Map<String, Object> inputParameters, Long connectionId) {

        ComponentConnection componentConnection = getComponentConnection(connectionId);

        return actionDefinitionService.executeOutputSchema(
            componentName, componentVersion, actionName, inputParameters, componentConnection,
            contextFactory.createActionContext(
                componentName, componentVersion, actionName, null, null, null, null, componentConnection));
    }

    @Override
    public Object executePerform(
        @NonNull String componentName, int componentVersion, @NonNull String actionName, @NonNull int type,
        Long instanceId, @NonNull String workflowId, long jobId, @NonNull Map<String, ?> inputParameters,
        Long connectionId) {

        ComponentConnection componentConnection = getComponentConnection(connectionId);

        return actionDefinitionService.executePerform(
            componentName, componentVersion, actionName, inputParameters, componentConnection,
            contextFactory.createActionContext(
                componentName, componentVersion, actionName, type, instanceId, workflowId, jobId,
                componentConnection));
    }

    @Override
    public SampleOutputResponse executeSampleOutput(
        @NonNull String componentName, int componentVersion, @NonNull String actionName,
        @NonNull Map<String, Object> inputParameters, Long connectionId) {

        ComponentConnection componentConnection = getComponentConnection(connectionId);

        return actionDefinitionService.executeSampleOutput(
            componentName, componentVersion, actionName, inputParameters, componentConnection,
            contextFactory.createActionContext(
                componentName, componentVersion, actionName, null, null, null, null, componentConnection));
    }

    private ComponentConnection getComponentConnection(Long connectionId) {
        ComponentConnection componentConnection = null;

        if (connectionId != null) {
            Connection connection = connectionService.getConnection(connectionId);

            componentConnection = new ComponentConnection(
                connection.getConnectionVersion(), connection.getParameters(), connection.getAuthorizationName());
        }

        return componentConnection;
    }
}
