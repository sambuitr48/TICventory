package co.cue.edu.ticventory.ticventory.notification.service;

import co.cue.edu.ticventory.ticventory.notification.models.Notification;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import co.cue.edu.ticventory.ticventory.people.Person;
import java.util.Date;

/**
 * Fábrica para crear instancias de Notification.
 * Aplica el patrón Factory Method para abstraer la creación de notificaciones.
 */
public class NotificationFactory {

    /**
     * Crea y devuelve una nueva notificación.
     *
     * @param recipient Destinatario de la notificación.
     * @param message Mensaje de la notificación.
     * @param notificationType Tipo de la notificación.
     * @param channel Canal de la notificación.
     * @return una instancia de Notification.
     */
    public static Notification createNotification(Person recipient, String message, NotificationType notificationType, NotificationChannel channel) {
        return new Notification(new Date(), recipient, message, notificationType, channel);
    }
}
