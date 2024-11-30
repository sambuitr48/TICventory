package co.cue.edu.ticventory.ticventory.space.repository;


import co.cue.edu.ticventory.ticventory.space.model.UniversityComponent;

import java.util.ArrayList;
import java.util.List;

public class UniversityRepository {

    private static UniversityRepository instance;
    private final List<UniversityComponent> campuses = new ArrayList<>();

    private UniversityRepository() {}

    public static synchronized UniversityRepository getInstance() {
        if (instance == null) {
            instance = new UniversityRepository();
        }
        return instance;
    }

    public void addCampus(UniversityComponent campus) {
        campuses.add(campus);
    }

    public List<UniversityComponent> getCampuses() {
        return campuses;
    }
}
