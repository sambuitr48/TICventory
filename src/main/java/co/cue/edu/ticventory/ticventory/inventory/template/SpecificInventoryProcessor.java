package co.cue.edu.ticventory.ticventory.inventory.template;

public class SpecificInventoryProcessor extends InventoryProcessor {
    @Override
    protected void retrieveResources() {
        System.out.println("Recuperando los recursos...");
    }

    @Override
    protected void processResources() {
        System.out.println("Procesando los recursos...");
    }

    @Override
    protected void saveResources() {
        System.out.println("Guardando los recursos...");
    }
}
