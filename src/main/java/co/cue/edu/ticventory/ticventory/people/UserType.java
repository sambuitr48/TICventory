package co.cue.edu.ticventory.ticventory.people;

public enum UserType {
    ESTUDIANTE(0),
    DOCENTE(1),
    VARIADO(2),
    ADMIN(3),
    PERSONAL_TICS(4);

    private final int code;

    UserType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UserType fromCode(int code) {
        for (UserType type : UserType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Código de UserType inválido: " + code);
    }
}

