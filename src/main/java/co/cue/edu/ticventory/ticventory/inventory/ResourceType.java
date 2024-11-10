package co.cue.edu.ticventory.ticventory.inventory;

/**
 * Esta clase representa el tipo de un recurso.
 * Cada recurso puede tener un tipo asociado, y este tipo se define por un nombre y una descripción.
 *
 * La clase permite almacenar, acceder y modificar el nombre y la descripción del tipo de recurso.
 * Además, se sobrescribe el método `toString()` para representar el tipo de recurso en formato de cadena.
 */
public class ResourceType {
    private String nombre;
    private String descripcion;

    public ResourceType(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoRecurso{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
