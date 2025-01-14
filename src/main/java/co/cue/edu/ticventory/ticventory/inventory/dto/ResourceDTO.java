package co.cue.edu.ticventory.ticventory.inventory.dto;

import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import co.cue.edu.ticventory.ticventory.inventory.model.ResourceType;

public class ResourceDTO {
    private String code;
    private String description;
    private ResourceType type;
    private String location;
    private String brand;
    private ResourceStatus status;

    public ResourceDTO(String code123, String testResource, Object o, Object o1, Object o2, Object o3) {

    }

    // Getters and Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public ResourceType getType() { return type; }
    public void setType(ResourceType type) { this.type = type; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public ResourceStatus getStatus() { return status; }
    public void setStatus(ResourceStatus status) { this.status = status; }
}
