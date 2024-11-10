package co.cue.edu.ticventory.ticventory.inventory;
/**
 * Clase que representa un recurso dentro del sistema de inventario.
 * Un recurso puede tener varios atributos como código, descripción, tipo, sede, marca y estado.
 * Además, se puede cambiar su estado mediante el método setState.
 */
public class Resource {
    private String code;
    private String description;
    private ResourceType resourceType;  // Ahora se usa TipoRecurso
    private Sede sedeLocation;
    private String brand;
    private ResourceState state;

    /**
     * Constructor que inicializa todos los atributos del recurso.
     *
     * @param code El código del recurso.
     * @param description La descripción del recurso.
     * @param resourceType El tipo del recurso.
     * @param sedeLocation La sede donde está ubicado el recurso.
     * @param brand La marca del recurso.
     * @param state El estado inicial del recurso.
     */
    public Resource(String code, String description, ResourceType resourceType, Sede sedeLocation, String brand, ResourceState state) {
        this.code = code;
        this.description = description;
        this.resourceType = resourceType;
        this.sedeLocation = sedeLocation;
        this.brand = brand;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public Sede getSedeLocation() {
        return sedeLocation;
    }

    public String getBrand() {
        return brand;
    }

    public ResourceState getState() {
        return state;
    }

    public void setState(ResourceState state) {
        this.state = state;
    }
}
