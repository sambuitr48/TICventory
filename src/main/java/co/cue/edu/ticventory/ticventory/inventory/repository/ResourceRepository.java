package co.cue.edu.ticventory.ticventory.inventory.repository;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ResourceRepository {
    private final Map<String, Resource> resourceStorage = new HashMap<>();

    public void save(Resource resource) {
        resourceStorage.put(resource.getCode(), resource);
    }

    public Resource findByCode(String code) {
        return resourceStorage.get(code);
    }

    public void delete(Resource resource) {
        resourceStorage.remove(resource.getCode());
    }

    public List<Resource> findAll() {
        return resourceStorage.values().stream().collect(Collectors.toList());
    }
}
