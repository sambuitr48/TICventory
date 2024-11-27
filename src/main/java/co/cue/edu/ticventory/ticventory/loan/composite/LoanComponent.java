package co.cue.edu.ticventory.ticventory.loan.composite;

public abstract class LoanComponent {
    public void add(LoanComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(LoanComponent component) {
        throw new UnsupportedOperationException();
    }

    public LoanComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    public abstract void processLoan();
}
