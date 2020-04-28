package org.example.alerts;

import org.kie.kogito.rules.DataStream;
import org.kie.kogito.rules.units.impl.DataSourceFactoryImpl;

public class KafkaDataSourceFactoryImpl extends DataSourceFactoryImpl {

    public <T> DataStream<T> createStream() {
        System.out.println("*************************8");
        return new DataStreamWithKafka<>();
    }
}
