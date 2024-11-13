package co.cue.edu.ticventory.ticventory.inventory.service;

import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.mapper.ResourceMapper;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.inventory.repository.ResourceRepository;

public class InventoryService {
    private ResourceRepository resourceRepository;

    public InventoryService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public void addResource(ResourceDTO resourceDTO) {
        Resource resource = ResourceMapper.toEntity(resourceDTO);
        resourceRepository.save(resource);
    }

    public ResourceDTO getResource(String code) {
        Resource resource = resourceRepository.findByCode(code);
        return ResourceMapper.toDTO(resource);
    }
}
