package co.cue.edu.ticventory.ticventory.space.model;


import co.cue.edu.ticventory.ticventory.space.enums.SpaceType;

public class Space extends UniversityComponent {

    private SpaceType type;
    private String identifier;

    public Space(String name, SpaceType type, String identifier) {
        super(name);
        this.type = type;
        this.identifier = identifier;
    }

    @Override
    public void add(UniversityComponent component) {
        throw new UnsupportedOperationException("Cannot add to a leaf node.");
    }

    @Override
    public void remove(UniversityComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf node.");
    }

    @Override
    public void display() {
        System.out.println("  Space: " + getName() + " | Type: " + type + " | Identifier: " + identifier);
    }
}
