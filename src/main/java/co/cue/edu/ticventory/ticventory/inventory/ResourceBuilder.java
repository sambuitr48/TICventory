package co.cue.edu.ticventory.ticventory.inventory;
/**
 * Esta clase es un Builder para crear objetos de tipo Resource.
 * El patrón Builder se utiliza para simplificar la creación de un objeto complejo (Resource) al permitir la construcción paso a paso.
 * Proporciona métodos encadenados para establecer los diferentes atributos del recurso y finalmente construirlo.
 */
public class ResourceBuilder {
    private String code;
    private String description;
    private ResourceType resourceType;
    private Sede sedeLocation;
    private String brand;
    private ResourceState state;

    public ResourceBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public ResourceBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ResourceBuilder setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    public ResourceBuilder setSedeLocation(Sede sedeLocation) {
        this.sedeLocation = sedeLocation;
        return this;
    }

    public ResourceBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ResourceBuilder setState(ResourceState state) {
        this.state = state;
        return this;
    }

    public Resource build() {
        return new Resource(code, description, resourceType, sedeLocation, brand, state);
    }
}
