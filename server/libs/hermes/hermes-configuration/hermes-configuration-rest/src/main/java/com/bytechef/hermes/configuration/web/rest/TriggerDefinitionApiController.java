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

package com.bytechef.hermes.configuration.web.rest;

import com.bytechef.commons.util.CollectionUtils;
import com.bytechef.hermes.component.registry.OperationType;
import com.bytechef.hermes.component.registry.facade.TriggerDefinitionFacade;
import com.bytechef.hermes.component.registry.service.TriggerDefinitionService;
import com.bytechef.hermes.configuration.web.rest.model.ComponentOperationRequestModel;
import com.bytechef.hermes.configuration.web.rest.model.EditorDescriptionResponseModel;
import com.bytechef.hermes.configuration.web.rest.model.OptionsResponseModel;
import com.bytechef.hermes.configuration.web.rest.model.OutputSchemaResponseModel;
import com.bytechef.hermes.configuration.web.rest.model.PropertiesResponseModel;
import com.bytechef.hermes.configuration.web.rest.model.SampleOutputResponseModel;
import com.bytechef.hermes.configuration.web.rest.model.TriggerDefinitionBasicModel;
import com.bytechef.hermes.configuration.web.rest.model.TriggerDefinitionModel;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivica Cardic
 */
@RestController
@RequestMapping("${openapi.openAPIDefinition.base-path.core:}")
@ConditionalOnProperty(prefix = "bytechef", name = "coordinator.enabled", matchIfMissing = true)
public class TriggerDefinitionApiController implements TriggerDefinitionApi {

    private final ConversionService conversionService;
    private final TriggerDefinitionFacade triggerDefinitionFacade;
    private final TriggerDefinitionService triggerDefinitionService;

    public TriggerDefinitionApiController(
        ConversionService conversionService, TriggerDefinitionFacade triggerDefinitionFacade,
        TriggerDefinitionService triggerDefinitionService) {

        this.conversionService = conversionService;
        this.triggerDefinitionFacade = triggerDefinitionFacade;
        this.triggerDefinitionService = triggerDefinitionService;
    }

    @Override
    public ResponseEntity<TriggerDefinitionModel> getComponentTriggerDefinition(
        String componentName, Integer componentVersion, String triggerName) {

        return ResponseEntity.ok(
            conversionService.convert(
                triggerDefinitionService.getTriggerDefinition(componentName, componentVersion, triggerName),
                TriggerDefinitionModel.class));
    }

    @Override
    public ResponseEntity<List<TriggerDefinitionBasicModel>> getComponentTriggerDefinitions(
        String componentName, Integer componentVersion) {

        return ResponseEntity.ok(
            triggerDefinitionService.getTriggerDefinitions(componentName, componentVersion)
                .stream()
                .map(triggerDefinitionDTO -> conversionService.convert(
                    triggerDefinitionDTO, TriggerDefinitionBasicModel.class))
                .toList());
    }

    @Override
    public ResponseEntity<EditorDescriptionResponseModel> getComponentTriggerEditorDescription(
        String componentName, Integer componentVersion, String triggerName,
        ComponentOperationRequestModel componentOperationRequestModel) {

        return ResponseEntity.ok(
            conversionService.convert(
                triggerDefinitionFacade.executeEditorDescription(
                    componentName, componentVersion, triggerName, componentOperationRequestModel.getParameters(),
                    componentOperationRequestModel.getConnectionId()),
                EditorDescriptionResponseModel.class));
    }

    @Override
    public ResponseEntity<OutputSchemaResponseModel> getComponentTriggerOutputSchema(
        String componentName, Integer componentVersion, String triggerName,
        ComponentOperationRequestModel componentOperationRequestModel) {

        return ResponseEntity.ok(
            conversionService.convert(
                triggerDefinitionFacade.executeOutputSchema(
                    componentName, componentVersion, triggerName, componentOperationRequestModel.getParameters(),
                    componentOperationRequestModel.getConnectionId()),
                OutputSchemaResponseModel.class));
    }

    @Override
    public ResponseEntity<SampleOutputResponseModel> getComponentTriggerSampleOutput(
        String componentName, Integer componentVersion, String triggerName,
        ComponentOperationRequestModel componentOperationRequestModel) {

        return ResponseEntity.ok(
            conversionService.convert(
                triggerDefinitionFacade.executeSampleOutput(
                    componentName, componentVersion, triggerName, componentOperationRequestModel.getParameters(),
                    componentOperationRequestModel.getConnectionId()),
                SampleOutputResponseModel.class));
    }

    @Override
    public ResponseEntity<PropertiesResponseModel> getComponentTriggerPropertyDynamicProperties(
        String componentName, Integer componentVersion, String triggerName, String propertyName,
        ComponentOperationRequestModel componentOperationRequestModel) {

        return ResponseEntity.ok(
            conversionService.convert(
                triggerDefinitionFacade.executeDynamicProperties(
                    componentName, componentVersion, triggerName, propertyName,
                    componentOperationRequestModel.getParameters(),
                    componentOperationRequestModel.getConnectionId()),
                PropertiesResponseModel.class));
    }

    @Override
    public ResponseEntity<OptionsResponseModel> getComponentTriggerPropertyOptions(
        String componentName, Integer componentVersion, String triggerName, String propertyName, String searchText,
        ComponentOperationRequestModel componentOperationRequestModel) {

        return ResponseEntity.ok(
            conversionService.convert(
                triggerDefinitionFacade.executeOptions(
                    componentName, componentVersion, triggerName, propertyName,
                    componentOperationRequestModel.getParameters(), componentOperationRequestModel.getConnectionId(),
                    searchText),
                OptionsResponseModel.class));
    }

    @Override
    public ResponseEntity<List<TriggerDefinitionModel>> getTriggerDefinitions(List<String> triggerTypes) {
        return ResponseEntity.ok(
            CollectionUtils.map(
                triggerDefinitionService.getTriggerDefinitions(
                    triggerTypes == null ? List.of() : CollectionUtils.map(triggerTypes, OperationType::ofType)),
                triggerDefinition -> conversionService.convert(triggerDefinition, TriggerDefinitionModel.class)));
    }
}
