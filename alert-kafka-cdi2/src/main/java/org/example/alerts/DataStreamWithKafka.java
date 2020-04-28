package org.example.alerts;

import javax.enterprise.inject.spi.CDI;

import org.kie.kogito.rules.units.ListDataStream;

public class DataStreamWithKafka<T> extends ListDataStream<T> {

    @Override
    public void append(T value) {
        FooSubscriber foo = CDI.current().select(FooSubscriber.class).get();
        foo.send(value.toString());
        super.append(value);
    }
}
