package co.cue.edu.ticventory.ticventory.notification;
/**
 * Clase que representa una plantilla de mensaje para notificaciones.
 * Esta clase permite crear un mensaje basado en un tipo de notificación
 * y proporciona la lógica para generar el mensaje correspondiente.
 */
public class MessageTemplate {
    private String message;
    private NotificationType notificationType;

    public MessageTemplate(String message, NotificationType notificationType) {
        this.message = message;
        this.notificationType = notificationType;
    }

    public String generateMessage() {
        // Aquí podrías aplicar una lógica para cambiar el mensaje según el tipo
        return message;
    }

    // Getters and Setters
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
}
