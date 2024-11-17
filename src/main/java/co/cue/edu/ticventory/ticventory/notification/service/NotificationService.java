package co.cue.edu.ticventory.ticventory.notification.service;

import co.cue.edu.ticventory.ticventory.notification.models.Notification;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import co.cue.edu.ticventory.ticventory.people.Person;
import org.springframework.stereotype.Service;

/**
 * Servicio para manejar la lógica de notificaciones.
 *
 * Este servicio aplica el patrón de diseño Factory para crear notificaciones
 * usando la clase NotificationFactory y el patrón Observer para enviar
 * notificaciones a través de diferentes canales.
 */
@Service
public class NotificationService {
    private NotificationObserver observer = new NotificationObserver();

    /**
     * Crea y envía una notificación.
     *
     * Aplica el patrón Factory para crear una instancia de Notification y
     * el patrón Observer para notificar a todos los canales registrados.
     *
     * @param recipient Destinatario de la notificación.
     * @param message Mensaje de la notificación.
     * @param notificationType Tipo de la notificación.
     * @param channel Canal a través del cual se enviará la notificación.
     * @return La notificación creada.
     */
    public Notification createAndSendNotification(Person recipient, String message, NotificationType notificationType, NotificationChannel channel) {
        // Usamos la fábrica para crear la notificación
        Notification notification = NotificationFactory.createNotification(recipient, message, notificationType, channel);

        // Añadimos el canal al observador y notificamos
        observer.addChannel(channel);
        observer.notifyObservers(notification.getMessage());

        return notification;
    }
}
