package co.cue.edu.ticventory.ticventory.inventory;
/**
 * Esta es una interfaz que define el comportamiento de los diferentes estados de un recurso.
 * Los estados pueden variar, por ejemplo, entre disponible, reservado, etc. Cada estado tiene su propia implementación del método `handle()`.
 *
 * Esta interfaz sigue el patrón de diseño **State**, donde el comportamiento de un objeto cambia dependiendo de su estado interno.
 */
interface ResourceState {
    /**
     * Este método define la acción que se debe tomar en función del estado del recurso.
     * Cada implementación de un estado específico de `ResourceState` debe proporcionar su propia lógica de manejo.
     */
    void handle();
}