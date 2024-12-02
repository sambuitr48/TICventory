package co.cue.edu.ticventory.ticventory.loan;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;

/**
 * La clase `LoanState` enumera los posibles estados de un préstamo.
 * Cada estado está asociado con un código de estado entero, que es útil para realizar operaciones
 * basadas en el estado del préstamo.
 */
public enum LoanStateEnum {
    PRESTADO(0),
    DEVUELTO(1),
    RETRASADO(2);

    private final int stateCode;

    LoanStateEnum(int stateCode) {
        this.stateCode = stateCode;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void handle(Loan loan) {
    }
}

