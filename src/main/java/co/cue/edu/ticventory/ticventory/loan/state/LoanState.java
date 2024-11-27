package co.cue.edu.ticventory.ticventory.loan.state;


import co.cue.edu.ticventory.ticventory.loan.model.Loan;

public abstract class LoanState {
    public abstract void handle(Loan loan);
}
