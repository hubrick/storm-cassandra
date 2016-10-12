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
package org.apache.storm.cassandra.bolt;

import backtype.storm.tuple.Tuple;
import com.datastax.driver.core.Statement;

/**
 * Simple class to pair a tuple with a statement.
 */
public class PairStatementTuple {
    
    private final Tuple tuple;
    
    private final Statement statement;

    /**
     * Creates a new {@link PairStatementTuple} instance.
     * @param tuple
     * @param statement
     */
    public PairStatementTuple(Tuple tuple, Statement statement) {
        this.tuple = tuple;
        this.statement = statement;
    }

    public Tuple getTuple() {
        return tuple;
    }

    public Statement getStatement() {
        return statement;
    }
}
