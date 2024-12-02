package co.cue.edu.ticventory.ticventory.loan.state;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;

public class ActiveLoanState extends LoanState {

    @Override
    public void handle(Loan loan) {
        System.out.println("El préstamo está activo: " + loan.getId());
        // Implementar lógica específica para el estado activo
    }
}
