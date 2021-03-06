/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.blindpirate.gogradle.core.dependency.produce.external.glock;

import com.github.blindpirate.gogradle.core.dependency.produce.ExternalDependencyFactory;

import javax.inject.Singleton;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Converts GLOCKFILE in repos managed by glock to gogradle map notations
 *
 * @see <a href="https://github.com/robfig/glock">glock</a>
 */
@Singleton
public class GlockDependencyFactory extends ExternalDependencyFactory {
    private GlockfileParser parser = new GlockfileParser();

    @Override
    public String identityFileName() {
        return "GLOCKFILE";
    }

    @Override
    protected List<Map<String, Object>> adapt(File file) {
        return parser.parse(file);
    }
}
