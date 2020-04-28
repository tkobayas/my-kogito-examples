package org.kie.kogito.queries;

import javax.enterprise.inject.spi.CDI;

import org.kie.kogito.rules.DataProcessor;
import org.kie.kogito.rules.DataStream;
import org.kie.kogito.rules.RuleUnitData;

public class AlertingService implements java.io.Serializable, org.drools.core.factmodel.GeneratedFact, org.drools.core.factmodel.AccessibleFact, RuleUnitData {

    public AlertingService() {
    }

    @org.kie.api.definition.type.Position(value = 0)
    private DataStream<Event> eventData;

    public void setEventData(DataStream<Event> eventData) {
        this.eventData = eventData;
    }

    public DataStream<Event> getEventData() {
        return eventData;
    }

    @org.kie.api.definition.type.Position(value = 1)
    private DataStream<Alert> alertData;

    public void setAlertData(DataStream<Alert> alertData) {
        this.alertData = new DataStream<Alert>() {

            @Override
            public void subscribe(DataProcessor<Alert> subscriber) {
                alertData.subscribe(subscriber);
            }

            @Override
            public void append(Alert value) {
                FooSubscriber foo = CDI.current().select(FooSubscriber.class).get();
                foo.send(value.toString());
                alertData.append(value);
            }
        };
    }

    public DataStream<Alert> getAlertData() {
        return alertData;
    }

    public AlertingService(DataStream<Event> eventData, DataStream<Alert> alertData) {
        super();
        this.eventData = eventData;
        this.alertData = alertData;
    }

    @Override()
    public String toString() {
        return "AlertingService" + "( " + "eventData=" + eventData + ", " + "alertData=" + alertData + " )";
    }

    @Override()
    public Object getValue(String fieldName) {
        switch(fieldName) {
            case "eventData":
                return this.eventData;
            case "alertData":
                return this.alertData;
            default:
                return null;
        }
    }

    @Override()
    public void setValue(String fieldName, Object value) {
        switch(fieldName) {
            case "eventData":
                this.eventData = (DataStream<Event>) value;
                break;
            case "alertData":
                this.alertData = (DataStream<Alert>) value;
                break;
        }
    }
}
