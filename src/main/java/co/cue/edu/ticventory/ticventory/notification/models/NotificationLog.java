package co.cue.edu.ticventory.ticventory.notification.models;

import java.util.Date;

public class NotificationLog {

    private String message;
    private String notificationType;
    private String channel;
    private String recipientName;
    private String documentId;
    private Date date;

    public NotificationLog(String message, String notificationType, String channel, String recipientName, String documentId, Date date) {
        this.message = message;
        this.notificationType = notificationType;
        this.channel = channel;
        this.recipientName = recipientName;
        this.documentId = documentId;
        this.date = date;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public String getChannel() {
        return channel;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public Date getDate() {
        return date;
    }
}
