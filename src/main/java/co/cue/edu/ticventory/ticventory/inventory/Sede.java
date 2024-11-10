package co.cue.edu.ticventory.ticventory.inventory;
/**
 * Esta enumeración define las diferentes sedes disponibles en el sistema.
 * Cada sede está representada por un valor único que se corresponde con un código entero.
 *
 * Las sedes posibles son:
 * - ANOVA
 * - ALCAZAR
 * - PRINCIPAL
 * - NOGAL
 *
 * Cada sede tiene un código asociado que se puede obtener y utilizar en el sistema.
 */
public enum Sede {
    ANOVA(0),
    ALCAZAR(1),
    PRINCIPAL(2),
    NOGAL(3);

    private final int code;

    Sede(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Sede fromCode(int code) {
        for (Sede sede : Sede.values()) {
            if (sede.getCode() == code) {
                return sede;
            }
        }
        throw new IllegalArgumentException("Código de sede inválido: " + code);
    }
}
