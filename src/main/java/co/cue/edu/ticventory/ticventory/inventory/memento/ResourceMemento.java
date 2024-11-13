package co.cue.edu.ticventory.ticventory.inventory.memento;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;

public class ResourceMemento {
    private final String code;
    private final String description;
    private final String brand;
    private final ResourceStatus state;

    public ResourceMemento(Resource resource) {
        this.code = resource.getCode();
        this.description = resource.getDescription();
        this.brand = resource.getBrand();
        this.state = resource.getState();
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public ResourceStatus getState() {
        return state;
    }
}
