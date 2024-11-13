package co.cue.edu.ticventory.ticventory.inventory.state;

public class AvailableState implements ResourceState {
    @Override
    public void handle() {
        System.out.println("El recurso está disponible.");
    }
}
