package co.cue.edu.ticventory.ticventory.loan.state;
import co.cue.edu.ticventory.ticventory.loan.model.Loan;

public class ActiveLoanState extends LoanState {
    @Override
    public void handle(Loan loan) {
        System.out.println("Loan is now active.");
    }
}

