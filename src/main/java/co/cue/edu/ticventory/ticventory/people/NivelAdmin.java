package co.cue.edu.ticventory.ticventory.people;

public enum NivelAdmin {
    SUPER_ADMIN(0),
    ADMIN(1),
    DIRECTIVOS_HUMBOLDT(2);

    private final int code;

    NivelAdmin(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static NivelAdmin fromCode(int code) {
        for (NivelAdmin nivel : NivelAdmin.values()) {
            if (nivel.getCode() == code) {
                return nivel;
            }
        }
        throw new IllegalArgumentException("Código de NivelAdmin inválido: " + code);
    }
}
