package org.kie.kogito.queries;

import java.io.Serializable;

public class LoanApplication implements Serializable {

    private static final long serialVersionUID = 6076713081470121991L;

    private String id;

    private Applicant applicant;

    private int amount;

    private int deposit;

    private boolean approved = false;

    public LoanApplication() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

}
