/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.joor;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

/* [java-8] */

import java.util.Collections;
import java.util.List;

import javax.annotation.processing.Processor;

/**
 * @author Lukas Eder
 */
public final class CompileOptions {

    final List<? extends Processor> processors;
    private ClassLoader classLoader = MethodHandles.lookup().lookupClass().getClassLoader();

    public CompileOptions() {
        this(Collections.emptyList());
    }

    public CompileOptions(ClassLoader classLoader) {
        this(Collections.emptyList());
        this.classLoader = classLoader;
    }

    private CompileOptions(List<? extends Processor> processors) {
        this.processors = processors;
    }

    public CompileOptions processors(Processor... processors) {
        return processors(Arrays.asList(processors));
    }

    public CompileOptions processors(List<? extends Processor> processors) {
        return new CompileOptions(processors);
    }

    public ClassLoader getClassLoader(){
        return this.classLoader;
    }
}
/* [/java-8] */
