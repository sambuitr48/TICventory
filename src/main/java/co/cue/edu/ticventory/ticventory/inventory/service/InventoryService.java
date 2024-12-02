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

    // Agregar un recurso
    public void addResource(ResourceDTO resourceDTO) {
        Resource resource = ResourceMapper.toEntity(resourceDTO);
        resourceRepository.save(resource);  // MongoDB persistirá el recurso
    }

    // Obtener recurso por código
    public ResourceDTO getResource(String code) {
        Resource resource = resourceRepository.findByCode(code);  // Consulta por código
        return resource != null ? ResourceMapper.toDTO(resource) : null;
    }

    // Eliminar recurso por código
    public void deleteResource(String code) {
        resourceRepository.deleteByCode(code);  // Elimina por código
    }

    // Obtener todos los recursos
    public List<ResourceDTO> getAllResources() {
        return resourceRepository.findAll().stream().map(ResourceMapper::toDTO).toList();
    }
}
