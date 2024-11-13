package co.cue.edu.ticventory.ticventory.inventory.repository;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;

import java.util.HashMap;
import java.util.Map;

public class ResourceRepository {
    private Map<String, Resource> resourceStorage = new HashMap<>();

    public void save(Resource resource) {
        resourceStorage.put(resource.getCode(), resource);
    }

    public Resource findByCode(String code) {
        return resourceStorage.get(code);
    }
}
