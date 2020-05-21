package org.kie.kogito.examples;

import org.drools.core.base.WrappedStatefulKnowledgeSessionForRHS;
import org.drools.model.Drools;
import org.kie.api.runtime.KieRuntime;
import org.kie.kogito.Application;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.RuleUnit;
import org.kie.kogito.rules.RuleUnits;

public class UnitUtils {

    public static void setupAdultUnit(Drools drools, DataStore<Person> persons, Results results) {
        KieRuntime kieRuntime = drools.getRuntime(KieRuntime.class);
        Application app = ((WrappedStatefulKnowledgeSessionForRHS)kieRuntime).getApplication();
        RuleUnits ruleUnits = app.ruleUnits();

        RuleUnit<AdultUnit> adultUnit = ruleUnits.create(AdultUnit.class);
        AdultUnit adultData18 = new AdultUnit(persons, 18);
        adultData18.setResults(results);

        adultUnit.createInstance(adultData18, "adult18");
    }
}
