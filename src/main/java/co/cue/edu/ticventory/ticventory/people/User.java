package co.cue.edu.ticventory.ticventory.people;

/**
 * Clase que representa a un usuario dentro del sistema, que extiende la clase Person.
 * Un usuario tiene un tipo asociado y una facultad, además de los atributos heredados de la clase Person.
 */
public class User extends Person {

    // Atributo que define el tipo de usuario (por ejemplo, estudiante, docente, etc.)
    private UserType userType;

    // Atributo que define la facultad a la que pertenece el usuario
    private Facultades facultad;

    /**
     * Constructor que inicializa los atributos de la clase User.
     *
     * @param nombre El nombre del usuario.
     * @param documentoIdentidad El documento de identidad del usuario.
     * @param correo El correo electrónico del usuario.
     * @param telefono El número de teléfono del usuario.
     * @param estado El estado del usuario (por ejemplo, activo o inactivo).
     * @param userType El tipo de usuario (ej. estudiante, docente).
     * @param facultad La facultad a la que pertenece el usuario.
     */
    public User(String nombre, String documentoIdentidad, String correo, long telefono, int estado, UserType userType, Facultades facultad) {
        super(nombre, documentoIdentidad, correo, telefono, estado); // Llamada al constructor de la clase base Person
        this.userType = userType;
        this.facultad = facultad;
    }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return El tipo de usuario (por ejemplo, estudiante, docente).
     */
    public UserType getTipoUsuario() {
        return userType;
    }

    /**
     * Obtiene la facultad a la que pertenece el usuario.
     *
     * @return La facultad del usuario.
     */
    public Facultades getFacultad() {
        return facultad;
    }
}
