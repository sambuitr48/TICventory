package co.cue.edu.ticventory.ticventory.notification.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import co.cue.edu.ticventory.ticventory.people.ConcretePerson;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
/**
 * Clase que implementa el patrón Observer para notificaciones.
 */
public class NotificationRequest {

    @JsonProperty("recipient")
    private ConcretePerson recipient;

    @JsonProperty("message")
    private String message;

    @JsonProperty("notificationType")
    private NotificationType notificationType;

    @JsonProperty("channel")
    private NotificationChannel channel;

    // Getters y Setters

    public ConcretePerson getRecipient() {
        return recipient;
    }

    public void setRecipient(ConcretePerson recipient) {
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
}
