package co.cue.edu.ticventory.ticventory.loan;
/**
 * La enumeración `LoanActionType` representa los diferentes tipos de acciones que se pueden realizar
 * sobre un préstamo en el sistema, como finalizar, cancelar, marcar como entrega tardía o pérdida.
 */
public enum LoanActionType {
    FINALIZADO(0),
    CANCELADO(1),
    ENTREGA_TARDIA(2),
    PERDIDA(3);

    private final int actionCode;

    LoanActionType(int actionCode) {
        this.actionCode = actionCode;
    }

    public int getActionCode() {
        return actionCode;
    }

    public static LoanActionType fromInt(int i) {
        for (LoanActionType action : LoanActionType.values()) {
            if (action.getActionCode() == i) {
                return action;
            }
        }
        return null;
    }
}
