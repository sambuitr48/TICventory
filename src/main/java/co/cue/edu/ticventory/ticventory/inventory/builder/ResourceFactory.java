package co.cue.edu.ticventory.ticventory.inventory.builder;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.inventory.model.ResourceType;
import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import co.cue.edu.ticventory.ticventory.inventory.model.Sede;

public class ResourceFactory {
    public static Resource createResource(String code, String description, ResourceType resourceType, Sede sedeLocation, String brand, ResourceStatus state) {
        return new ResourceBuilder()
                .setCode(code)
                .setDescription(description)
                .setResourceType(resourceType)
                .setSedeLocation(sedeLocation)
                .setBrand(brand)
                .setState(state)
                .build();
    }
}
