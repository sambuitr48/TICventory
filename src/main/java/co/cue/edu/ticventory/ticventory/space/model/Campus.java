package co.cue.edu.ticventory.ticventory.space.model;

import java.util.ArrayList;
import java.util.List;

public class Campus extends UniversityComponent {

    private final List<UniversityComponent> components = new ArrayList<>();

    public Campus(String name) {
        super(name);
    }

    @Override
    public void add(UniversityComponent component) {
        components.add(component);
    }

    @Override
    public void remove(UniversityComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Campus: " + getName());
        for (UniversityComponent component : components) {
            component.display();
        }
    }

    public List<UniversityComponent> getComponents() {
        return components;
    }
}
