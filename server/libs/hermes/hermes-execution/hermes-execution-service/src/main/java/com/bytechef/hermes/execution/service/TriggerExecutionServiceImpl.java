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

package com.bytechef.hermes.execution.service;

import com.bytechef.commons.util.OptionalUtils;
import com.bytechef.hermes.execution.domain.TriggerExecution;
import com.bytechef.hermes.execution.domain.TriggerExecution.Status;
import com.bytechef.hermes.execution.repository.TriggerExecutionRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ivica Cardic
 */
@Service
@Transactional
public class TriggerExecutionServiceImpl implements TriggerExecutionService {

    private final TriggerExecutionRepository triggerExecutionRepository;

    public TriggerExecutionServiceImpl(TriggerExecutionRepository triggerExecutionRepository) {
        this.triggerExecutionRepository = triggerExecutionRepository;
    }

    @Override
    public TriggerExecution create(TriggerExecution triggerExecution) {
        Validate.notNull(triggerExecution, "'triggerExecution' must not be null");
        Validate.isTrue(triggerExecution.getId() == null, "'triggerExecution.id' must be null");

        return triggerExecutionRepository.save(triggerExecution);
    }

    @Override
    @Transactional(readOnly = true)
    public TriggerExecution getJobTriggerExecution(long jobId) {
        return triggerExecutionRepository.findByJobId(jobId);
    }

    @Override
    @Transactional(readOnly = true)
    public TriggerExecution getTriggerExecution(long id) {
        return OptionalUtils.get(triggerExecutionRepository.findById(id));
    }

    @Override
    public TriggerExecution update(TriggerExecution triggerExecution) {
        Validate.notNull(triggerExecution, "'triggerExecution' must not be null");

        TriggerExecution currentTriggerExecution = OptionalUtils.get(
            triggerExecutionRepository.findByIdForUpdate(Validate.notNull(triggerExecution.getId(), "id")));

        Status currentStatus = currentTriggerExecution.getStatus();
        Status status = triggerExecution.getStatus();

        if (currentStatus.isTerminated() && status == Status.STARTED) {
            currentTriggerExecution.setStartDate(triggerExecution.getStartDate());

            triggerExecution = currentTriggerExecution;
        } else if (status.isTerminated() && currentTriggerExecution.getStatus() == Status.STARTED) {
            triggerExecution.setStartDate(currentTriggerExecution.getStartDate());
        }

        // Do not override initial workflow task definition

        triggerExecution.setWorkflowExecutionId(currentTriggerExecution.getWorkflowExecutionId());
        triggerExecution.setWorkflowTrigger(currentTriggerExecution.getWorkflowTrigger());

        return triggerExecutionRepository.save(triggerExecution);
    }
}
