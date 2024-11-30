package co.cue.edu.ticventory.ticventory.inventory.controller;

import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addResource(@RequestBody ResourceDTO resourceDTO) {
        inventoryService.addResource(resourceDTO);
        return ResponseEntity.ok("Resource added successfully.");
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<ResourceDTO> getResource(@PathVariable String code) {
        ResourceDTO resourceDTO = inventoryService.getResource(code);
        if (resourceDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resourceDTO);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteResource(@PathVariable String code) {
        inventoryService.deleteResource(code);
        return ResponseEntity.ok("Resource deleted successfully.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<ResourceDTO>> listResources() {
        List<ResourceDTO> resources = inventoryService.getAllResources();
        return ResponseEntity.ok(resources);
    }
}
