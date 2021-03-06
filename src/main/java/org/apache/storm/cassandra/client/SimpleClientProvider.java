/**
 * Copyright (C) ${project.inceptionYear} Etaia AS (oss@hubrick.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.storm.cassandra.client;

import java.util.Map;

/**
 * Default interface to provide cassandra client.
 */
public interface SimpleClientProvider {

    /**
     * Creates a new cassandra client based on the specified storm configuration.
     *
     * @param config The configuration passed to the storm topology.
     * @return a new {@link SimpleClient} instance.
     */
    SimpleClient getClient(Map<String, Object> config);
}
