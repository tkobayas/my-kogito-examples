package org.example.alerts;

import org.kie.kogito.rules.units.ListDataStream;

public class MyDataStream<T> extends ListDataStream<T> {

    @Override
    public void append(T value) {
        System.out.println("************** MyDataStream.append()");
        super.append(value);
    }
}
