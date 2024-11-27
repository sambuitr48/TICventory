package co.cue.edu.ticventory.ticventory.loan.template;

public class SpecificLoanProcessor extends LoanProcessor {
    @Override
    protected void verifyAvailability() {
        System.out.println("Verifying resource availability...");
    }

    @Override
    protected void reserveResources() {
        System.out.println("Reserving resources...");
    }

    @Override
    protected void finalizeLoan() {
        System.out.println("Finalizing loan...");
    }
}

