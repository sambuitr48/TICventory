package co.cue.edu.ticventory.ticventory.people;

public enum Sedes {
    ANOVA(0),
    ALCAZAR(1),
    PRINCIPAL(2),
    NOGAL(3);

    private final int code;

    Sedes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Sedes fromCode(int code) {
        for (Sedes sede : Sedes.values()) {
            if (sede.getCode() == code) {
                return sede;
            }
        }
        throw new IllegalArgumentException("Código de Sede inválido: " + code);
    }
}
