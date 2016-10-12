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
package org.apache.storm.cassandra.trident;

import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import storm.trident.operation.TridentCollector;
import storm.trident.spout.IBatchSpout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 *
 */
public class WeatherBatchSpout implements IBatchSpout {
    private final Fields outputFields;
    private final int batchSize;
    private final String[] stationIds;
    private final HashMap<Long, List<List<Object>>> batches = new HashMap<Long, List<List<Object>>>();
    List<Object>[] outputs;

    public WeatherBatchSpout(Fields fields, int batchSize, String[] stationIds) {
        this.outputFields = fields;
        this.batchSize = batchSize;
        this.stationIds = stationIds;
    }

    @Override
    public void open(Map conf, TopologyContext context) {

    }

    @Override
    public void emitBatch(long batchId, TridentCollector collector) {
        List<List<Object>> batch = this.batches.get(batchId);
        if(batch == null){
            batch = new ArrayList<>();
            for (int i=0; i< batchSize; i++) {
                batch.add(createTuple());
            }
            this.batches.put(batchId, batch);
        }
        for(List<Object> list : batch){
            collector.emit(list);
        }
    }

    private List<Object> createTuple() {
        final Random random = new Random();
        List<Object> values = new ArrayList<Object>(){{
            add(stationIds[random.nextInt(stationIds.length)]);
            add(random.nextInt(100) + "");
            add(UUID.randomUUID());}};
        return values;
    }

    @Override
    public void ack(long batchId) {
        batches.remove(batchId);
    }

    @Override
    public void close() {

    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

    @Override
    public Fields getOutputFields() {
        return outputFields;
    }

    public int getRemainingBatches() {
        return batches.size();
    }
}