package co.cue.edu.ticventory.ticventory.space.model;

public abstract class UniversityComponent {
    private String name;

    public UniversityComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void add(UniversityComponent component);

    public abstract void remove(UniversityComponent component);

    public abstract void display();
}
