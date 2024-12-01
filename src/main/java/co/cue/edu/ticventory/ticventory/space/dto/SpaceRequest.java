package co.cue.edu.ticventory.ticventory.space.dto;


import co.cue.edu.ticventory.ticventory.space.enums.SpaceType;

public class SpaceRequest {
    private String name;
    private SpaceType type;
    private String identifier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpaceType getType() {
        return type;
    }

    public void setType(SpaceType type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
