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
package org.apache.storm.cassandra.query;

import org.apache.storm.tuple.ITuple;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Default interface to map a {@link org.apache.storm.tuple.ITuple} to a CQL {@link com.datastax.driver.core.Statement}.
 *
 */
public abstract class BaseCQLStatementTupleMapper implements CQLStatementTupleMapper, Serializable {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Statement> map(Map conf, Session session, ITuple tuple) {
        return Arrays.asList(map(tuple));
    }

    /**
     * Maps a given tuple to a single CQL statements.
     *
     * @param tuple the incoming tuple to map.
     * @return a list of {@link com.datastax.driver.core.Statement}.
     */
    public abstract Statement map(ITuple tuple);
}
