package org.example.alerts;

import org.kie.kogito.rules.DataHandle;
import org.kie.kogito.rules.units.ListDataStore;

public class MyDataStore<T> extends ListDataStore<T> {

    @Override
    public DataHandle add(T value) {
        System.out.println("************** MyDataStore.add()");
        return super.add(value);
    }
}
