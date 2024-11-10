package co.cue.edu.ticventory.ticventory.loan;
/**
 * La clase `LoanState` enumera los posibles estados de un préstamo.
 * Cada estado está asociado con un código de estado entero, que es útil para realizar operaciones
 * basadas en el estado del préstamo.
 */
public enum LoanState {
    PRESTADO(0),
    DVUELTO(1),
    RETRASADO(2),
    CANCELADO(3);

    private final int stateCode;

    LoanState(int stateCode) {
        this.stateCode = stateCode;
    }

    public int getStateCode() {
        return stateCode;
    }

    public static LoanState fromInt(int i) {
        for (LoanState state : LoanState.values()) {
            if (state.getStateCode() == i) {
                return state;
            }
        }
        return null;
    }
}
