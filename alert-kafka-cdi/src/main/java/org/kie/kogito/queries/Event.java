package org.kie.kogito.queries;

import org.kie.kogito.rules.RuleUnitData;
import org.kie.kogito.rules.DataStream;
import org.kie.kogito.queries.*;

public class Event implements java.io.Serializable, org.drools.core.factmodel.GeneratedFact, org.drools.core.factmodel.AccessibleFact {

    public Event() {
    }

    @org.kie.api.definition.type.Position(value = 0)
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @org.kie.api.definition.type.Position(value = 1)
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Event(String type, int value) {
        super();
        this.type = type;
        this.value = value;
    }

    @Override()
    public String toString() {
        return "Event" + "( " + "type=" + type + ", " + "value=" + value + " )";
    }

    @Override()
    public Object getValue(String fieldName) {
        switch(fieldName) {
            case "type":
                return this.type;
            case "value":
                return this.value;
            default:
                return null;
        }
    }

    @Override()
    public void setValue(String fieldName, Object value) {
        switch(fieldName) {
            case "type":
                this.type = (String) value;
                break;
            case "value":
                this.value = (int) value;
                break;
        }
    }
}
