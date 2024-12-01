package co.cue.edu.ticventory.ticventory.inventory.facade;

import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.service.InventoryService;

import java.util.List;

public class InventoryFacade {
    private final InventoryService inventoryService;

    public InventoryFacade(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void addResource(ResourceDTO resourceDTO) {
        inventoryService.addResource(resourceDTO);
    }

    public ResourceDTO getResource(String code) {
        return inventoryService.getResource(code);
    }
    public List<ResourceDTO> getAllResources() {
        return inventoryService.getAllResources();
    }

    public void deleteResource(String code) {
        inventoryService.deleteResource(code);
    }

}
