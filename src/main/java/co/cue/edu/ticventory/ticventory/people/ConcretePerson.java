package co.cue.edu.ticventory.ticventory.people;

/**
 * Clase concreta que extiende la clase abstracta Person.
 * Esta clase representa una implementación específica de una persona en el sistema.
 */
public class ConcretePerson extends Person {
    public ConcretePerson(String nombre, String documentoIdentidad, String correo, long telefono, int estado) {
        super(nombre, documentoIdentidad, correo, telefono, estado);
    }

    // Constructor sin parámetros necesario para la deserialización
    public ConcretePerson() {
        super("", "", "", 0L, 0); // Puedes inicializar con valores por defecto
    }
}
