package org.example.alerts;

import org.kie.kogito.rules.units.ListDataStream;

public class MyDataStream<T> extends ListDataStream<T> {

    //@Override
    public static <T> MyDataStream<T> createStream() {
        return new MyDataStream<>();
    }

    @Override
    public void append(T value) {
        System.out.println("************** MyDataStream.append()");
        super.append(value);
    }
}
