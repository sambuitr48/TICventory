package co.cue.edu.ticventory.ticventory.inventory.controller;

import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.service.InventoryService;

public class InventoryController {
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void addResource(ResourceDTO resourceDTO) {
        inventoryService.addResource(resourceDTO);
    }

    public ResourceDTO getResource(String code) {
        return inventoryService.getResource(code);
    }
}