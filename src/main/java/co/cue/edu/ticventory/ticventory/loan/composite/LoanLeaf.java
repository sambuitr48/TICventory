package co.cue.edu.ticventory.ticventory.loan.composite;

public class LoanLeaf extends LoanComponent {
    @Override
    public void processLoan() {
        System.out.println("Processing individual loan...");
    }
}
