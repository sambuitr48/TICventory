package co.cue.edu.ticventory.ticventory.people;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    private String nombre;
    private String documentoIdentidad;
    private String correo;
    private long telefono;
    private int estado;

    // Constructor vacío
    protected Person() {
    }

    // Constructor completo
    protected Person(String nombre, String documentoIdentidad, String correo, long telefono, int estado) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
