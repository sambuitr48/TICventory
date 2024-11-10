package co.cue.edu.ticventory.ticventory.notification;
/**
 * Interfaz que define el comportamiento de los observadores que reciben notificaciones.
 * Implementada por clases que desean recibir actualizaciones cuando una notificación es enviada.
 */
public interface NotificationObserver {
    /**
     * Método que es llamado cuando una notificación es enviada.
     *
     * @param message El mensaje de la notificación que se va a actualizar.
     */
    void update(String message);
}
