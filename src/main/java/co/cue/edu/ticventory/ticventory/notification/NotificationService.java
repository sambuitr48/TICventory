package co.cue.edu.ticventory.ticventory.notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que gestiona el envío de notificaciones a un conjunto de observadores.
 * Mantiene una lista de observadores que son notificados cuando se envía una notificación.
 */
public class NotificationService {

    // Lista de observadores que recibirán las notificaciones
    private List<NotificationObserver> observers = new ArrayList<>();

    /**
     * Agrega un observador a la lista de observadores.
     *
     * @param observer El observador que debe recibir las notificaciones.
     */
    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    /**
     * Elimina un observador de la lista de observadores.
     *
     * @param observer El observador que debe ser removido.
     */
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifica a todos los observadores con el mensaje proporcionado.
     *
     * @param message El mensaje que se enviará a todos los observadores.
     */
    public void notifyObservers(String message) {
        for (NotificationObserver observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Envía una notificación a los observadores.
     * Este método puede ser ampliado con lógica adicional, como la gestión de canales de notificación.
     *
     * @param notification La notificación que se enviará.
     */
    public void sendNotification(Notification notification) {
        // Aquí se pueden agregar más lógicas, como la gestión de canales
        notifyObservers(notification.getMessage());
    }
}
