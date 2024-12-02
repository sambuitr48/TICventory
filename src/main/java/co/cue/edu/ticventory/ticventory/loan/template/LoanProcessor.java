package co.cue.edu.ticventory.ticventory.loan.template;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;

public abstract class LoanProcessor {
    public final void process(Loan loan) {
        verifyAvailability(loan);
        reserveResources(loan);
        finalizeLoan(loan);
    }

    protected abstract void verifyAvailability(Loan loan);

    protected abstract void reserveResources(Loan loan);

    protected abstract void finalizeLoan(Loan loan);
}
