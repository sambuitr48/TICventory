package co.cue.edu.ticventory.ticventory.space.builder;


import co.cue.edu.ticventory.ticventory.space.enums.SpaceType;
import co.cue.edu.ticventory.ticventory.space.model.Space;

public class SpaceBuilder {

    private String name;
    private SpaceType type;
    private String identifier;

    public SpaceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SpaceBuilder setType(SpaceType type) {
        this.type = type;
        return this;
    }

    public SpaceBuilder setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public Space build() {
        return new Space(name, type, identifier);
    }
}
