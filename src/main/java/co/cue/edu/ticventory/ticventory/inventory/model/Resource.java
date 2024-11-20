package co.cue.edu.ticventory.ticventory.inventory.model;

import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import co.cue.edu.ticventory.ticventory.inventory.memento.ResourceMemento;

public class Resource {
    private String code;
    private String description;
    private ResourceType resourceType;
    private Sede sedeLocation;
    private String brand;
    private ResourceStatus state;

    public Resource(String code, String description, ResourceType resourceType, Sede sedeLocation, String brand, ResourceStatus state) {
        this.code = code;
        this.description = description;
        this.resourceType = resourceType;
        this.sedeLocation = sedeLocation;
        this.brand = brand;
        this.state = state;
    }

    public String getCode() { return code; }
    public String getDescription() { return description; }
    public ResourceType getResourceType() { return resourceType; }
    public Sede getSedeLocation() { return sedeLocation; }
    public String getBrand() { return brand; }
    public ResourceStatus getState() { return state; }

    public void setState(ResourceStatus state) {
        this.state = state;
    }

    // Método para guardar el estado actual en un Memento
    public ResourceMemento saveToMemento() {
        return new ResourceMemento(this);
    }

    // Método para restaurar el estado desde un Memento
    public void restoreFromMemento(ResourceMemento memento) {
        this.code = memento.getCode();
        this.description = memento.getDescription();
        this.brand = memento.getBrand();
        this.state = memento.getState();
    }

}
