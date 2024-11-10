package co.cue.edu.ticventory.ticventory.inventory;
/**
 * Esta clase representa el estado en el que un recurso no está disponible.
 * Implementa la interfaz `ResourceState` y sobrescribe el método `handle()` para
 * imprimir un mensaje que indica que el recurso no está disponible.
 *
 * Esta clase es utilizada en el contexto de un patrón de diseño de estado,
 * donde el estado de un recurso puede cambiar dinámicamente.
 */
public class UnavailableState implements ResourceState {
    /**
     * Sobrescribe el método `handle` de la interfaz `ResourceState`.
     * Este método imprime un mensaje que indica que el recurso no está disponible.
     */
    @Override
    public void handle() {
        System.out.println("El recurso no está disponible.");
    }
}
