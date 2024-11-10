package co.cue.edu.ticventory.ticventory.inventory;
/**
 * Esta clase sirve como contexto para manejar el estado de un recurso.
 * Utiliza el patrón **State** para cambiar y aplicar el comportamiento de un recurso dependiendo de su estado.
 *
 * El contexto mantiene una referencia al estado actual y delega la ejecución de comportamientos al mismo.
 * El estado puede cambiar dinámicamente mediante el método `setState()`, y el comportamiento del recurso se aplica a través de `applyState()`.
 */
public class ResourceStateContext {
    private ResourceState state;

    public ResourceStateContext() {
        this.state = new AvailableState(); // El estado inicial puede ser Disponible
    }

    public void setState(ResourceState state) {
        this.state = state;
    }

    public void applyState() {
        this.state.handle();
    }
}
