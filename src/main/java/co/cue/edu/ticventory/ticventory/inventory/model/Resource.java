package co.cue.edu.ticventory.ticventory.inventory.model;

import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resources")  // Define la colección en MongoDB
public class Resource {

    @Id
    private String id;  // MongoDB maneja el ID de manera automática

    private String code;
    private String description;
    private ResourceType resourceType;
    private Sede sedeLocation;
    private String brand;
    private ResourceStatus state;

    // Constructor
    public Resource(String code, String description, ResourceType resourceType, Sede sedeLocation, String brand, ResourceStatus state) {
        this.code = code;
        this.description = description;
        this.resourceType = resourceType;
        this.sedeLocation = sedeLocation;
        this.brand = brand;
        this.state = state;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ResourceStatus getState() {
        return state;
    }

    public void setState(ResourceStatus state) {
        this.state = state;
    }
}
