package co.cue.edu.ticventory.ticventory.inventory;
/**
 * Clase que representa el estado en el que un recurso está reservado.
 * Implementa la interfaz ResourceState, que define los diferentes estados posibles de un recurso.
 * Esta clase maneja el comportamiento del recurso cuando está en estado de reserva,
 * imprimiendo un mensaje que indica que el recurso está reservado.
 */
public class ReservedState implements ResourceState {
    /**
     * Método que maneja el comportamiento cuando el recurso está reservado.
     * En este caso, simplemente imprime un mensaje que indica que el recurso está reservado.
     */
    @Override
    public void handle() {
        System.out.println("El recurso está reservado.");
    }
}
