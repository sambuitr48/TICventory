package co.cue.edu.ticventory.ticventory.people;

public enum Facultades {
    DERECHO(0),
    MEDICINA(1),
    ENFERMERIA(2),
    MEDICINA_VETERINARIA(3),
    INGENIERIA_CIVIL(4),
    INGENIERIA_DE_SOFTWARE(5),
    INGENIERIA_INDUSTRIAL(6),
    MARKETING_DIGITAL(7),
    ADMINISTRACION_DE_EMPRESAS(8),
    PSICOLOGIA(9);

    private final int code;

    Facultades(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Facultades fromCode(int code) {
        for (Facultades facultad : Facultades.values()) {
            if (facultad.getCode() == code) {
                return facultad;
            }
        }
        throw new IllegalArgumentException("Código de Facultad inválido: " + code);
    }
}
