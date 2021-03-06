/*
 *  Copyright 2014 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.model;

import java.util.Objects;

/**
 *
 * @author Alexey Andreev
 */
public class CallLocation {
    private MethodReference method;
    private InstructionLocation sourceLocation;

    public CallLocation(MethodReference method) {
        this(method, null);
    }

    public CallLocation(MethodReference method, InstructionLocation sourceLocation) {
        if (method == null) {
            throw new IllegalArgumentException("Method must not be null");
        }
        this.method = method;
        this.sourceLocation = sourceLocation;
    }

    public MethodReference getMethod() {
        return method;
    }

    public InstructionLocation getSourceLocation() {
        return sourceLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, sourceLocation);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallLocation)) {
            return false;
        }
        CallLocation other = (CallLocation)obj;
        return Objects.equals(method, other.method) && Objects.equals(sourceLocation, other.sourceLocation);
    }
}
