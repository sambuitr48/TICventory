package co.cue.edu.ticventory.ticventory.loan;

public enum SpaceType {
    AULA(0),
    LABORATORIO(1),
    SALA_REUNIONES(2),
    AUDITORIO(3),
    OFICINA(4);

    private final int code;

    SpaceType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SpaceType fromCode(int code) {
        for (SpaceType tipo : SpaceType.values()) {
            if (tipo.getCode() == code) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código de TipoEspacio inválido: " + code);
    }
}
