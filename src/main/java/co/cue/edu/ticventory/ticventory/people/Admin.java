package co.cue.edu.ticventory.ticventory.people;
/**
 * Representa a un administrador dentro del sistema, que extiende la clase Person.
 * Un administrador tiene un nivel de acceso definido por el atributo nivelAdmin.
 */
public class Admin extends Person {
    private NivelAdmin nivelAdmin;
    /**
     * Constructor para crear un objeto Admin con los detalles proporcionados.
     *
     * @param nombre El nombre del administrador.
     * @param documentoIdentidad El documento de identidad del administrador.
     * @param correo El correo electrónico del administrador.
     * @param telefono El número de teléfono del administrador.
     * @param estado El estado del administrador (activo, inactivo, etc.).
     * @param nivelAdmin El nivel de acceso del administrador.
     */
    public Admin(String nombre, String documentoIdentidad, String correo, long telefono, int estado, NivelAdmin nivelAdmin) {
        super(nombre, documentoIdentidad, correo, telefono, estado);
        this.nivelAdmin = nivelAdmin;
    }

    public NivelAdmin getNivelAdmin() {
        return nivelAdmin;
    }
}
