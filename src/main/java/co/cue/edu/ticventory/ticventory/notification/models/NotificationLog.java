package co.cue.edu.ticventory.ticventory.notification.models;

import java.util.Date;

/**
 * Clase que representa el historial de notificaciones enviadas.
 */
public class NotificationLog {

    private String message; // Mensaje enviado
    private String notificationType; // Tipo de notificación (e.g., EMAIL, SMS)
    private String channel; // Canal de envío (e.g., SMS, EMAIL)
    private String recipientName; // Nombre del destinatario
    private String recipientDocument; // Documento de identificación del destinatario
    private Date date; // Fecha de envío

    // Constructor completo
    public NotificationLog(String message, String notificationType, String channel,
                           String recipientName, String recipientDocument, Date date) {
        this.message = message;
        this.notificationType = notificationType;
        this.channel = channel;
        this.recipientName = recipientName;
        this.recipientDocument = recipientDocument;
        this.date = date;
    }

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientDocument() {
        return recipientDocument;
    }

    public void setRecipientDocument(String recipientDocument) {
        this.recipientDocument = recipientDocument;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NotificationLog{" +
                "message='" + message + '\'' +
                ", notificationType='" + notificationType + '\'' +
                ", channel='" + channel + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientDocument='" + recipientDocument + '\'' +
                ", date=" + date +
                '}';
    }
}
