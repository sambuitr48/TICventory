package co.cue.edu.ticventory.ticventory.inventory.builder;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.inventory.model.ResourceType;
import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import co.cue.edu.ticventory.ticventory.inventory.model.Sede;

public class ResourceBuilder {
    private String code;
    private String description;
    private ResourceType resourceType;
    private Sede sedeLocation;
    private String brand;
    private ResourceStatus state;

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

    public ResourceBuilder setState(ResourceStatus state) {
        this.state = state;
        return this;
    }

    public Resource build() {
        return new Resource(code, description, resourceType, sedeLocation, brand, state);
    }
}
