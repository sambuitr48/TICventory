package co.cue.edu.ticventory.ticventory.loan.composite;

import java.util.ArrayList;
import java.util.List;

public class LoanGroup extends LoanComponent {
    private List<LoanComponent> loans = new ArrayList<>();

    @Override
    public void add(LoanComponent component) {
        loans.add(component);
    }

    @Override
    public void remove(LoanComponent component) {
        loans.remove(component);
    }

    @Override
    public void processLoan() {
        for (LoanComponent loan : loans) {
            loan.processLoan();
        }
    }
}
