package co.cue.edu.ticventory.ticventory;

import co.cue.edu.ticventory.ticventory.space.builder.SpaceBuilder;
import co.cue.edu.ticventory.ticventory.space.enums.SpaceType;
import co.cue.edu.ticventory.ticventory.space.model.Campus;
import co.cue.edu.ticventory.ticventory.space.model.Space;
import co.cue.edu.ticventory.ticventory.space.service.UniversityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpacesTest {

    private UniversityService universityService;

    @BeforeEach
    void setUp() {
        universityService = new UniversityService();
    }

    @Test
    void testSpaceBuilderCreatesSpace() {
        Space space = new SpaceBuilder()
                .setName("Lab A")
                .setType(SpaceType.LABORATORIO_DE_INGENIERIAS)
                .setIdentifier("LA001")
                .build();

        assertEquals("Lab A", space.getName());
    }

    @Test
    void testAddCampus() {
        Campus campus = new Campus("Sede Principal");
        universityService.addCampus(campus);

        List<String> structure = universityService.getCampusStructure();
        assertTrue(structure.stream().anyMatch(s -> s.contains("Sede Principal")));
    }

    @Test
    void testAddSpaceToExistingCampus() {
        Campus campus = new Campus("Sede Principal");
        universityService.addCampus(campus);

        Space space = new SpaceBuilder()
                .setName("Lab A")
                .setType(SpaceType.LABORATORIO_DE_INGENIERIAS)
                .setIdentifier("LA001")
                .build();

        universityService.addSpaceToCampus("Sede Principal", space);

        assertTrue(campus.getComponents().stream()
                .anyMatch(c -> c.getName().equals("Lab A")));
    }

    @Test
    void testAddSpaceToNonexistentCampus() {
        Space space = new SpaceBuilder()
                .setName("Lab A")
                .setType(SpaceType.LABORATORIO_DE_INGENIERIAS)
                .setIdentifier("LA001")
                .build();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                universityService.addSpaceToCampus("Sede No Existe", space));

        assertEquals("Campus not found: Sede No Existe", exception.getMessage());
    }

    @Test
    void testGetCampusStructure() {
        Campus campus = new Campus("Sede Principal");
        Space space = new SpaceBuilder()
                .setName("Lab A")
                .setType(SpaceType.LABORATORIO_DE_INGENIERIAS)
                .setIdentifier("LA001")
                .build();

        universityService.addCampus(campus);
        universityService.addSpaceToCampus("Sede Principal", space);

        List<String> structure = universityService.getCampusStructure();

        assertTrue(structure.stream().anyMatch(s -> s.contains("Lab A")));
        assertTrue(structure.stream().anyMatch(s -> s.contains("Sede Principal")));
    }

    @Test
    void testFullWorkflowIntegration() {
        String campusName = "Sede Nogal";
        Campus campus = new Campus(campusName);
        universityService.addCampus(campus);

        Space space = new SpaceBuilder()
                .setName("Auditorio")
                .setType(SpaceType.AUDITORIO)
                .setIdentifier("AUD001")
                .build();

        universityService.addSpaceToCampus(campusName, space);

        List<String> structure = universityService.getCampusStructure();

        assertTrue(structure.stream().anyMatch(s -> s.contains("Auditorio")));
        assertTrue(structure.stream().anyMatch(s -> s.contains("Sede Nogal")));
    }
}
