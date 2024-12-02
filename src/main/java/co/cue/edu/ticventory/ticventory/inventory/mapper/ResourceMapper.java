package co.cue.edu.ticventory.ticventory.inventory.mapper;

import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;

public class ResourceMapper {

    // Convierte de ResourceDTO a Resource
    public static Resource toEntity(ResourceDTO resourceDTO) {
        return new Resource(
                resourceDTO.getCode(),
                resourceDTO.getDescription(),
                resourceDTO.getResourceType(),
                resourceDTO.getSedeLocation(),
                resourceDTO.getBrand(),
                resourceDTO.getState()
        );
    }

    // Convierte de Resource a ResourceDTO
    public static ResourceDTO toDTO(Resource resource) {
        return new ResourceDTO(
                resource.getCode(),
                resource.getDescription(),
                resource.getResourceType(),
                resource.getSedeLocation(),
                resource.getBrand(),
                resource.getState()
        );
    }
}
