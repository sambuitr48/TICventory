package co.cue.edu.ticventory.ticventory.space.controller;


import co.cue.edu.ticventory.ticventory.space.builder.SpaceBuilder;
import co.cue.edu.ticventory.ticventory.space.model.Campus;
import co.cue.edu.ticventory.ticventory.space.model.Space;
import co.cue.edu.ticventory.ticventory.space.model.SpaceRequest;
import co.cue.edu.ticventory.ticventory.space.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UniversityController {

    private final UniversityService service;

    @Autowired
    public UniversityController(UniversityService service) {
        this.service = service;
    }

    @PostMapping("/campus")
    public ResponseEntity<String> createCampus(@RequestBody Map<String, String> campusRequest) {
        String campusName = campusRequest.get("name");
        if (campusName == null || campusName.isBlank()) {
            return ResponseEntity.badRequest().body("Campus name is required");
        }
        service.addCampus(new Campus(campusName));
        return ResponseEntity.ok("Campus created: " + campusName);
    }


    @PostMapping("/campus/{campusName}/space")
    public ResponseEntity<String> createSpace(
            @PathVariable String campusName,
            @RequestBody SpaceRequest spaceRequest) {

        Space space = new SpaceBuilder()
                .setName(spaceRequest.getName())
                .setType(spaceRequest.getType())
                .setIdentifier(spaceRequest.getIdentifier())
                .build();

        service.addSpaceToCampus(campusName, space);
        return ResponseEntity.ok("Space added to campus: " + campusName);
    }

    @GetMapping("/campus/structure")
    public ResponseEntity<List<String>> displayStructure() {
        return ResponseEntity.ok(service.getCampusStructure());
    }
}
