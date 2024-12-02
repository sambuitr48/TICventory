package co.cue.edu.ticventory.ticventory.inventory.dto;

import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import co.cue.edu.ticventory.ticventory.inventory.model.ResourceType;
import co.cue.edu.ticventory.ticventory.inventory.model.Sede;

public class ResourceDTO {

    private String code;
    private String description;
    private ResourceType resourceType;
    private Sede sedeLocation;
    private String brand;
    private ResourceStatus state; // Revertido a 'ResourceStatus'

    public ResourceDTO(String code, String description, ResourceType resourceType, Sede sedeLocation, String brand, ResourceStatus state) {
        this.code = code;
        this.description = description;
        this.resourceType = resourceType;
        this.sedeLocation = sedeLocation;
        this.brand = brand;
        this.state = state;
    }

    // Getters y Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Sede getSedeLocation() {
        return sedeLocation;
    }

    public void setSedeLocation(Sede sedeLocation) {
        this.sedeLocation = sedeLocation;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ResourceStatus getState() {  // Se utiliza ResourceStatus
        return state;
    }

    public void setState(ResourceStatus state) { // Se utiliza ResourceStatus
        this.state = state;
    }
}
