package co.cue.edu.ticventory.ticventory.notification.models;

import co.cue.edu.ticventory.ticventory.people.Person;
import java.util.Date;
/**
 * Clase que representa una notificación dentro del sistema.
 * Incluye información sobre el destinatario, mensaje, tipo de notificación y canal.
 */
public class Notification {
    private Date date;
    private Person recipient;
    private String message;
    private NotificationType notificationType;
    private NotificationChannel channel;

    public Notification(Date date, Person recipient, String message, NotificationType notificationType, NotificationChannel channel) {
        this.date = date;
        this.recipient = recipient;
        this.message = message;
        this.notificationType = notificationType;
        this.channel = channel;
    }

    public String getMessage() {
        return message;
    }

    public Person getRecipient() {
        return recipient;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public NotificationChannel getChannel() {
        return channel;
    }
}
