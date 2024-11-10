package co.cue.edu.ticventory.ticventory.people;

/**
 * Fábrica de objetos que crea instancias de diferentes tipos de usuarios (Admin, PersonalTICs, User)
 * basados en el tipo proporcionado. Utiliza el patrón Factory para centralizar la creación de objetos.
 */
public class UserFactory {

    /**
     * Crea un objeto de tipo `Person` según el tipo de usuario especificado.
     *
     * @param type El tipo de usuario (ADMIN, PERSONAL_TICS, ESTUDIANTE, DOCENTE, VARIADO).
     * @param nombre El nombre del usuario.
     * @param documentoIdentidad El documento de identidad del usuario.
     * @param correo El correo electrónico del usuario.
     * @param telefono El número de teléfono del usuario.
     * @param estado El estado del usuario (por ejemplo, activo o inactivo).
     * @param sedeActual La sede actual del personal TICs.
     * @param nivelAdmin El nivel de administración para los administradores.
     * @param userType El tipo de usuario (por ejemplo, estudiante, docente) para el caso de `User`.
     * @param facultad La facultad a la que pertenece el usuario.
     * @return Un objeto de tipo `Person` correspondiente al tipo de usuario solicitado.
     * @throws IllegalArgumentException Si el tipo de usuario no es válido.
     */
    public static Person createUser(UserType type, String nombre, String documentoIdentidad, String correo, long telefono, int estado, Sedes sedeActual, NivelAdmin nivelAdmin, UserType userType, Facultades facultad) {
        // Se utiliza un switch para determinar el tipo de usuario y crear la instancia adecuada.
        switch(type) {
            case ADMIN:
                // Si el tipo es ADMIN, se crea un objeto de la clase Admin.
                return new Admin(nombre, documentoIdentidad, correo, telefono, estado, nivelAdmin);
            case PERSONAL_TICS:
                // Si el tipo es PERSONAL_TICS, se crea un objeto de la clase PersonalTICs.
                // La disponibilidad se asume como true por defecto.
                return new PersonalTICs(nombre, documentoIdentidad, correo, telefono, estado, true, sedeActual);
            case ESTUDIANTE:
            case DOCENTE:
            case VARIADO:
                // Si el tipo es ESTUDIANTE, DOCENTE o VARIADO, se crea un objeto de la clase User.
                return new User(nombre, documentoIdentidad, correo, telefono, estado, userType, facultad);
            default:
                // Si el tipo no es válido, se lanza una excepción.
                throw new IllegalArgumentException("Tipo de usuario no válido: " + type);
        }
    }
}
