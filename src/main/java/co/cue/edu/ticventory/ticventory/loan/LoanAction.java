package co.cue.edu.ticventory.ticventory.loan;
/**
 * La clase `LoanAction` representa una acción realizada sobre un préstamo. Cada acción
 * está asociada con un préstamo específico (`Loan`) y un tipo de acción que describe
 * lo que se ha hecho o debe hacerse con el préstamo, como "aprobar", "cancelar" o "renovar".
 */
public class LoanAction {
    private Loan loan;
    private LoanActionType action;

    public LoanAction(Loan loan, LoanActionType action) {
        this.loan = loan;
        this.action = action;
    }

    public Loan getLoan() {
        return loan;
    }

    public LoanActionType getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "LoanAction{" +
                "loan=" + loan +
                ", action=" + action +
                '}';
    }
}
