package co.cue.edu.ticventory.ticventory.inventory.composite;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;

public class ResourceLeaf extends InventoryComponent {
    private final Resource resource;

    public ResourceLeaf(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void showDetails() {
        System.out.println(resource);
    }
}
