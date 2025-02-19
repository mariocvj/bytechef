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

import com.bytechef.hermes.definition.Option;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import java.util.Optional;

/**
 * @author Ivica Cardic
 */
public interface OptionsDataSource {

    /**
     *
     * @return
     */
    default Optional<List<String>> getLoadOptionsDependsOn() {
        return Optional.empty();
    }

    /**
     *
     * @return
     */
    OptionsFunction getOptions();

    /**
     *
     */
    interface OptionsFunction {
    }

    /**
     *
     */
    @FunctionalInterface
    interface ActionOptionsFunction extends OptionsFunction {

        /**
         *
         * @param inputParameters
         * @param connectionParameters
         * @param searchText
         * @param context
         * @return
         * @throws Exception
         */
        OptionsResponse apply(
            Parameters inputParameters, Parameters connectionParameters, String searchText, ActionContext context)
            throws Exception;
    }

    /**
     *
     */
    @FunctionalInterface
    interface TriggerOptionsFunction extends OptionsFunction {

        /**
         *
         * @param inputParameters
         * @param connectionParameters
         * @param searchText
         * @param context
         * @return
         * @throws Exception
         */
        OptionsResponse apply(
            Parameters inputParameters, Parameters connectionParameters, String searchText, TriggerContext context)
            throws Exception;
    }

    /**
     *
     * @param options
     * @param errorMessage
     */
    @SuppressFBWarnings("EI")
    record OptionsResponse(List<? extends Option<?>> options, String errorMessage) {

        public OptionsResponse(List<? extends Option<?>> options) {
            this(options, null);
        }
    }
}
