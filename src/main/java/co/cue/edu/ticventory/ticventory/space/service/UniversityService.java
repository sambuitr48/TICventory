package co.cue.edu.ticventory.ticventory.space.service;


import co.cue.edu.ticventory.ticventory.space.model.Campus;
import co.cue.edu.ticventory.ticventory.space.model.Space;
import co.cue.edu.ticventory.ticventory.space.model.UniversityComponent;
import co.cue.edu.ticventory.ticventory.space.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    private final UniversityRepository repository = UniversityRepository.getInstance();

    public void addCampus(Campus campus) {
        repository.addCampus(campus);
    }

    public Optional<Campus> findCampusByName(String campusName) {
        return repository.getCampuses().stream()
                .filter(campus -> campus.getName().equalsIgnoreCase(campusName))
                .map(campus -> (Campus) campus)
                .findFirst();
    }

    public void addSpaceToCampus(String campusName, Space space) {
        Optional<Campus> campus = findCampusByName(campusName);
        if (campus.isPresent()) {
            campus.get().add(space);
        } else {
            throw new IllegalArgumentException("Campus not found: " + campusName);
        }
    }

    public List<String> getCampusStructure() {
        List<String> structure = new ArrayList<>();
        for (UniversityComponent campus : repository.getCampuses()) {
            StringBuilder campusInfo = new StringBuilder("Campus: " + campus.getName());
            ((Campus) campus).getComponents().forEach(component ->
                    campusInfo.append("\n  ").append(component.getName()));
            structure.add(campusInfo.toString());
        }
        return structure;
    }
}
