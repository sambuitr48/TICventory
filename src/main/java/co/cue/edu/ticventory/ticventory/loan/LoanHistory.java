package co.cue.edu.ticventory.ticventory.loan;

import java.util.ArrayList;
import java.util.List;
/**
 * La clase `LoanHistory` almacena un historial de acciones realizadas en un préstamo.
 * Las acciones pueden incluir eventos como la cancelación, devolución o cualquier otro cambio en el préstamo.
 */
public class LoanHistory {
    private List<LoanAction> actions;

    public LoanHistory() {
        actions = new ArrayList<>();
    }

    public void addAction(LoanAction action) {
        actions.add(action);
    }

    public List<LoanAction> getActions() {
        return actions;
    }

    @Override
    public String toString() {
        return "LoanHistory{" +
                "actions=" + actions +
                '}';
    }
}
