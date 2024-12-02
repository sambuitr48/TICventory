package co.cue.edu.ticventory.ticventory.loan.template;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;

public class SpecificLoanProcessor extends LoanProcessor {

    @Override
    protected void verifyAvailability(Loan loan) {
        System.out.println("Verificando disponibilidad para el préstamo: " + loan.getId());
        // Implementar lógica específica
    }

    @Override
    protected void reserveResources(Loan loan) {
        System.out.println("Reservando recursos para el préstamo: " + loan.getId());
        // Implementar lógica específica
    }

    @Override
    protected void finalizeLoan(Loan loan) {
        System.out.println("Finalizando préstamo: " + loan.getId());
        // Implementar lógica específica
    }
}
