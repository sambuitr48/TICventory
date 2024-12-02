package co.cue.edu.ticventory.ticventory.inventory.service;

import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.mapper.ResourceMapper;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.inventory.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public InventoryService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public void addResource(ResourceDTO resourceDTO) {
        Resource resource = ResourceMapper.toEntity(resourceDTO);
        resourceRepository.save(resource);
    }

    public ResourceDTO getResource(String code) {
        Resource resource = resourceRepository.findByCode(code);
        return resource != null ? ResourceMapper.toDTO(resource) : null;
    }

    public void deleteResource(String code) {
        Resource resource = resourceRepository.findByCode(code);
        if (resource != null) {
            resourceRepository.delete(resource);
        }
    }

    public List<ResourceDTO> getAllResources() {
        return resourceRepository.findAll().stream().map(ResourceMapper::toDTO).toList();
    }
}
