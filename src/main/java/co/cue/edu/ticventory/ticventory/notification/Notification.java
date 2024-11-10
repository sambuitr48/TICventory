package co.cue.edu.ticventory.ticventory.notification;
import co.cue.edu.ticventory.ticventory.people.Person;

import java.util.Date;
/**
 * Clase que representa una notificación que se envía a un destinatario.
 * La notificación contiene información como la fecha, el destinatario,
 * el mensaje, el tipo de notificación y el canal de comunicación.
 */
public class Notification {
    private Date date;
    private Person recipient;
    private String message;
    private NotificationType notificationType;
    private NotificationChannel channel;
    /**
     * Constructor de la clase Notification.
     *
     * @param date La fecha en la que se crea la notificación.
     * @param recipient La persona que recibirá la notificación.
     * @param message El mensaje de la notificación.
     * @param notificationType El tipo de la notificación (por ejemplo, alerta, recordatorio).
     * @param channel El canal a través del cual se enviará la notificación (por ejemplo, correo electrónico, SMS).
     */
    public Notification(Date date, Person recipient, String message, NotificationType notificationType, NotificationChannel channel) {
        this.date = date;
        this.recipient = recipient;
        this.message = message;
        this.notificationType = notificationType;
        this.channel = channel;
    }

    // Getters and Setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "date=" + date +
                ", recipient=" + recipient +
                ", message='" + message + '\'' +
                ", notificationType=" + notificationType +
                ", channel=" + channel +
                '}';
    }
}
