package co.cue.edu.ticventory.ticventory.inventory;
/**
 * Clase que representa el estado en el que un recurso está disponible.
 * Implementa la interfaz ResourceState, que define los diferentes estados de un recurso.
 * Esta clase maneja el comportamiento del recurso cuando está disponible, imprimiendo un mensaje que indica su estado.
 */
public class AvailableState implements ResourceState {
    /**
     * Método que maneja el comportamiento cuando el recurso está disponible.
     * En este caso, simplemente imprime un mensaje que indica que el recurso está disponible.
     */
    @Override
    public void handle() {
        System.out.println("El recurso está disponible.");
    }
}
