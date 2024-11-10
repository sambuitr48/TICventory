package co.cue.edu.ticventory.ticventory.people;
/**
 * Clase abstracta que representa a una persona dentro del sistema.
 * Las personas tienen atributos comunes como nombre, documento de identidad, correo, teléfono y estado.
 */
public abstract class Person {
    private String nombre;
    private String documentoIdentidad;
    private String correo;
    private long telefono;
    private int estado;
    /**
     * Constructor que inicializa los atributos de la persona.
     *
     * @param nombre El nombre de la persona.
     * @param documentoIdentidad El documento de identidad de la persona.
     * @param correo El correo electrónico de la persona.
     * @param telefono El número de teléfono de la persona.
     * @param estado El estado de la persona (activo, inactivo, etc.).
     */
    public Person(String nombre, String documentoIdentidad, String correo, long telefono, int estado) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getCorreo() {
        return correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public int getEstado() {
        return estado;
    }
}
