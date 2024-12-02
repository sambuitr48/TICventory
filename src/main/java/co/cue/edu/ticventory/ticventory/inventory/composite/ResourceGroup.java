package co.cue.edu.ticventory.ticventory.inventory.composite;

import java.util.ArrayList;
import java.util.List;

public class ResourceGroup extends InventoryComponent {
    private final List<InventoryComponent> components = new ArrayList<>();

    @Override
    public void add(InventoryComponent component) {
        components.add(component);
    }

    @Override
    public void remove(InventoryComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        for (InventoryComponent component : components) {
            component.showDetails();
        }
    }
}
