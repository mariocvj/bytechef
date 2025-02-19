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

package com.bytechef.hermes.component.exception;

import java.util.Collections;
import java.util.Map;

/**
 * @author Igor Beslic
 */
public class ComponentExecutionException extends RuntimeException {

    private Map<String, ?> inputParameters;

    /**
     *
     * @param message
     */
    public ComponentExecutionException(String message) {
        super(message);
    }

    public ComponentExecutionException(String message, Map<String, ?> inputParameters) {
        super(message);

        this.inputParameters = Collections.unmodifiableMap(inputParameters);
    }

    /**
     *
     * @param cause
     */
    public ComponentExecutionException(Throwable cause) {
        super(cause);
    }

    public ComponentExecutionException(Throwable cause, Map<String, ?> inputParameters) {
        super(cause);

        this.inputParameters = Collections.unmodifiableMap(inputParameters);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public ComponentExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComponentExecutionException(String message, Throwable cause, Map<String, ?> inputParameters) {
        super(message, cause);

        this.inputParameters = Collections.unmodifiableMap(inputParameters);
    }

    public Map<String, ?> getInputParameters() {
        return Collections.unmodifiableMap(inputParameters);
    }

    @Override
    public String toString() {
        return "ComponentExecutionException{" +
            "inputParameters=" + inputParameters + ", " +
            "message=" + super.toString() +
            "} ";
    }
}
