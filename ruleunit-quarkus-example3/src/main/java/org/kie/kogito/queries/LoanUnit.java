/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.kogito.queries;

import java.io.Serializable;

import org.kie.kogito.conf.SessionsPool;
import org.kie.kogito.rules.DataSource;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.RuleUnitData;

@SessionsPool(1)
public class LoanUnit implements RuleUnitData, Serializable {
    private int adultAge;

    private DataStore<Applicant> applicants;
    private DataStore<LoanApplication> loanApplications;

    public LoanUnit() {
        this(DataSource.createStore(), DataSource.createStore());
    }

    public LoanUnit(DataStore<Applicant> applicants, DataStore<LoanApplication> loanApplications) {
        this.applicants = applicants;
        this.loanApplications = loanApplications;
    }

    public DataStore<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(DataStore<Applicant> applicants) {
        this.applicants = applicants;
    }

    public DataStore<LoanApplication> getLoanApplications() {
        return loanApplications;
    }

    public void setLoanApplications(DataStore<LoanApplication> loanApplications) {
        this.loanApplications = loanApplications;
    }

    public int getAdultAge() {
        return adultAge;
    }

    public void setAdultAge( int adultAge ) {
        this.adultAge = adultAge;
    }
}
