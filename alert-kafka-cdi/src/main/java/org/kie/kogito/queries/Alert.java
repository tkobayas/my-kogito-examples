package org.kie.kogito.queries;

import org.kie.kogito.rules.RuleUnitData;
import org.kie.kogito.rules.DataStream;
import org.kie.kogito.queries.*;

public class Alert implements java.io.Serializable, org.drools.core.factmodel.GeneratedFact, org.drools.core.factmodel.AccessibleFact {

    public Alert() {
    }

    @org.kie.api.definition.type.Position(value = 0)
    private String severity;

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getSeverity() {
        return severity;
    }

    @org.kie.api.definition.type.Position(value = 1)
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Alert(String severity, String message) {
        super();
        this.severity = severity;
        this.message = message;
    }

    @Override()
    public String toString() {
        return "Alert" + "( " + "severity=" + severity + ", " + "message=" + message + " )";
    }

    @Override()
    public Object getValue(String fieldName) {
        switch(fieldName) {
            case "severity":
                return this.severity;
            case "message":
                return this.message;
            default:
                return null;
        }
    }

    @Override()
    public void setValue(String fieldName, Object value) {
        switch(fieldName) {
            case "severity":
                this.severity = (String) value;
                break;
            case "message":
                this.message = (String) value;
                break;
        }
    }
}
