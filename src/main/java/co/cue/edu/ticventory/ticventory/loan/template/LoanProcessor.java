package co.cue.edu.ticventory.ticventory.loan.template;

public abstract class LoanProcessor {
    public final void process() {
        verifyAvailability();
        reserveResources();
        finalizeLoan();
    }

    protected abstract void verifyAvailability();

    protected abstract void reserveResources();

    protected abstract void finalizeLoan();
}
