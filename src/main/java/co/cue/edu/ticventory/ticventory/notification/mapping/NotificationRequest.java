package co.cue.edu.ticventory.ticventory.notification.mapping;

import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;

// **Clase: NotificationRequest**
// **Patrón aplicado: DTO (Data Transfer Object)**
// Esta clase actúa como un contenedor de datos para transportar información
// desde la capa de presentación (el cliente) hacia el sistema.
// Facilita la transferencia de datos entre las capas sin exponer modelos internos directamente.
public class NotificationRequest {

    // **Atributo: recipient**
    // Representa al destinatario de la notificación.
    private Recipient recipient;

    // **Atributo: message**
    // Contiene el mensaje que se enviará al destinatario.
    private String message;

    // **Atributo: notificationType**
    // Especifica el tipo de notificación (por ejemplo, PRESTAMO, ALERTA).
    private NotificationType notificationType;

    // **Atributo: channel**
    // Indica el canal de notificación a usar (EMAIL, SMS, PUSH).
    private NotificationChannel channel;

    // **Getters y Setters**
    // Los métodos de acceso permiten que los datos sean leídos y modificados
    // sin exponer directamente los atributos internos de la clase.

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
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
