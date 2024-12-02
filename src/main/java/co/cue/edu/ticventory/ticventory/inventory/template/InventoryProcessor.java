package co.cue.edu.ticventory.ticventory.inventory.template;

public abstract class InventoryProcessor {
    public final void processInventory() {
        retrieveResources();
        processResources();
        saveResources();
    }

    protected abstract void retrieveResources();
    protected abstract void processResources();
    protected abstract void saveResources();
}
