package co.cue.edu.ticventory.ticventory.inventory.mapper;

import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.inventory.model.Sede;

public class ResourceMapper {
    public static ResourceDTO toDTO(Resource resource) {
        ResourceDTO dto = new ResourceDTO();
        dto.setCode(resource.getCode());
        dto.setDescription(resource.getDescription());
        dto.setType(resource.getResourceType());
        dto.setLocation(resource.getSedeLocation().toString());
        dto.setBrand(resource.getBrand());
        dto.setStatus(resource.getState());
        return dto;
    }

    public static Resource toEntity(ResourceDTO dto) {
        return new Resource(dto.getCode(), dto.getDescription(),
                dto.getType(),
                Sede.valueOf(dto.getLocation()),
                dto.getBrand(),
                ResourceStatus.valueOf(dto.getStatus().toString()));
    }
}
