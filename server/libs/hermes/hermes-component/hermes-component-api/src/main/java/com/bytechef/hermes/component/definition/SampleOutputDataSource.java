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

package com.bytechef.hermes.component.definition;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * @author Ivica Cardic
 */
public interface SampleOutputDataSource {

    /**
     * The function that returns an example output.
     *
     * @return The function implementation
     */
    SampleOutputFunction getSampleOutput();

    /**
     *
     */
    interface SampleOutputFunction {
    }

    /**
     *
     * @param sampleOutput
     * @param errorMessage
     */
    @SuppressFBWarnings("EI")
    record SampleOutputResponse(Object sampleOutput, String errorMessage) {

        public SampleOutputResponse(Object sampleOutput) {
            this(sampleOutput, null);
        }
    }

    /**
     *
     */
    @FunctionalInterface
    interface ActionSampleOutputFunction extends SampleOutputFunction {

        /**
         *
         * @param inputParameters
         * @param connectionParameters
         * @param context
         * @return
         * @throws Exception
         */
        SampleOutputResponse apply(
            Parameters inputParameters, Parameters connectionParameters, ActionContext context)
            throws Exception;
    }

    /**
     *
     */
    @FunctionalInterface
    interface TriggerSampleOutputFunction extends SampleOutputFunction {

        /**
         * @param inputParameters
         * @param connectionParameters
         * @param context
         * @return
         * @throws Exception
         */
        SampleOutputResponse apply(
            Parameters inputParameters, Parameters connectionParameters, TriggerContext context)
            throws Exception;
    }
}
