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

package com.bytechef.helios.execution.web.rest.mapper;

import com.bytechef.atlas.execution.dto.JobParameters;
import com.bytechef.helios.execution.web.rest.mapper.config.ProjectExecutionMapperSpringConfig;
import com.bytechef.helios.execution.web.rest.mapper.util.ConverterUtils;
import com.bytechef.helios.execution.web.rest.model.JobParametersModel;
import java.util.List;
import java.util.Map;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Ivica Cardic
 */
@Mapper(config = ProjectExecutionMapperSpringConfig.class)
public interface ProjectJobParametersModelMapper extends Converter<JobParametersModel, JobParameters> {

    @Override
    @Mapping(target = "inputs", qualifiedByName = "inputs", source = ".")
    @Mapping(target = "metadata", qualifiedByName = "metadata", source = ".")
    JobParameters convert(JobParametersModel jobParametersModel);

    @Named("inputs")
    default Map<String, Object> getInputs(JobParametersModel jobParametersModel) {
        return ConverterUtils.getInputs(
            jobParametersModel.getInputs() == null ? Map.of() : jobParametersModel.getInputs(),
            jobParametersModel.getTriggerOutputs() == null ? List.of() : jobParametersModel.getTriggerOutputs());
    }

    @Named("metadata")
    default Map<String, Object> getMetadata(JobParametersModel jobParametersModel) {
        return ConverterUtils.getMetadata(
            jobParametersModel.getConnections() == null ? List.of() : jobParametersModel.getConnections());
    }
}
