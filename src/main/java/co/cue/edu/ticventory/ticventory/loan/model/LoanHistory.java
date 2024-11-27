package co.cue.edu.ticventory.ticventory.loan.model;

import co.cue.edu.ticventory.ticventory.loan.domain.LoanAction;

public class LoanHistory {
    private Loan loan;
    private LoanAction action;

    public LoanHistory(Loan loan, LoanAction action) {
        this.loan = loan;
        this.action = action;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public LoanAction getAction() {
        return action;
    }

    public void setAction(LoanAction action) {
        this.action = action;
    }
}
