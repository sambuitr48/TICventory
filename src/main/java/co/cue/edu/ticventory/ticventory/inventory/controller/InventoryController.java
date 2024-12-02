package co.cue.edu.ticventory.ticventory.inventory.controller;

import co.cue.edu.ticventory.ticventory.inventory.dto.ResourceDTO;
import co.cue.edu.ticventory.ticventory.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // Agregar un recurso
    @PostMapping
    public ResponseEntity<Void> addResource(@RequestBody ResourceDTO resourceDTO) {
        inventoryService.addResource(resourceDTO);
        return ResponseEntity.ok().build();
    }

    // Obtener recurso por código
    @GetMapping("/{code}")
    public ResponseEntity<ResourceDTO> getResource(@PathVariable String code) {
        ResourceDTO resourceDTO = inventoryService.getResource(code);
        return resourceDTO != null ? ResponseEntity.ok(resourceDTO) : ResponseEntity.notFound().build();
    }

    // Obtener todos los recursos
    @GetMapping
    public ResponseEntity<List<ResourceDTO>> getAllResources() {
        List<ResourceDTO> resources = inventoryService.getAllResources();
        return ResponseEntity.ok(resources);
    }

    // Eliminar recurso por código
    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteResource(@PathVariable String code) {
        inventoryService.deleteResource(code);
        return ResponseEntity.ok().build();
    }
}
