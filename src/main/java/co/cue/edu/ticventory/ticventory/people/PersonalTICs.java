package co.cue.edu.ticventory.ticventory.people;

/**
 * Clase que representa al personal TIC dentro del sistema, que extiende la clase Person.
 * Este tipo de persona tiene atributos adicionales relacionados con su disponibilidad y la sede en la que se encuentra actualmente.
 */
public class PersonalTICs extends Person {
    private boolean disponibilidad;
    private Sedes sedeActual;
    /**
     * Constructor que inicializa los atributos de la clase PersonalTICs.
     *
     * @param nombre El nombre del personal TIC.
     * @param documentoIdentidad El documento de identidad del personal TIC.
     * @param correo El correo electrónico del personal TIC.
     * @param telefono El número de teléfono del personal TIC.
     * @param estado El estado del personal TIC (por ejemplo, activo o inactivo).
     * @param disponibilidad Indica si el personal TIC está disponible.
     * @param sedeActual La sede actual en la que se encuentra el personal TIC.
     */
    public PersonalTICs(String nombre, String documentoIdentidad, String correo, long telefono, int estado, boolean disponibilidad, Sedes sedeActual) {
        super(nombre, documentoIdentidad, correo, telefono, estado);
        this.disponibilidad = disponibilidad;
        this.sedeActual = sedeActual;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public Sedes getSedeActual() {
        return sedeActual;
    }
}
