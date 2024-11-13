package co.cue.edu.ticventory.ticventory.inventory.state;


public class UnavailableState implements ResourceState {
    @Override
    public void handle() {
        System.out.println("El recurso no está disponible.");
    }
}
