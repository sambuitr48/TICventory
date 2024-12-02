package co.cue.edu.ticventory.ticventory.loan.model;

public class LoanHistory {
    private final Loan loanSnapshot;

    public LoanHistory(Loan loan) {
        this.loanSnapshot = new Loan(loan); // Crear un constructor de copia en Loan
    }

    public Loan getLoanSnapshot() {
        return loanSnapshot;
    }
}
