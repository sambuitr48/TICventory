package co.cue.edu.ticventory.ticventory.notification.models;

import java.util.Date;

// **Clase: Notification**
// Esta clase representa una notificación con todos los datos relevantes necesarios para enviarla.
// **Patrón aplicado: Builder**
// Permite la creación de instancias de `Notification` de forma clara y controlada,
// especialmente útil cuando hay múltiples atributos opcionales.
public class Notification {

    // **Atributos inmutables**
    // Estos atributos solo se inicializan en el constructor y no se pueden modificar después.
    private final Date date;
    private final Recipient recipient;
    private final String message;
    private final NotificationType notificationType;
    private final NotificationChannel channel;

    // **Constructor privado**
    // El constructor utiliza el patrón Builder para inicializar los atributos.
    private Notification(Builder builder) {
        this.date = builder.date;
        this.recipient = builder.recipient;
        this.message = builder.message;
        this.notificationType = builder.notificationType;
        this.channel = builder.channel;
    }

    // **Clase interna estática: Builder**
    // **Patrón aplicado: Builder**
    // Esta clase interna facilita la creación de instancias de `Notification` al permitir
    // un enfoque fluido (fluent interface) y evitar constructores con demasiados parámetros.
    public static class Builder {
        private Date date;
        private Recipient recipient;
        private String message;
        private NotificationType notificationType;
        private NotificationChannel channel;

        // **Método: date**
        // Permite establecer la fecha de la notificación.
        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        // **Método: recipient**
        // Permite establecer el destinatario de la notificación.
        public Builder recipient(Recipient recipient) {
            this.recipient = recipient;
            return this;
        }

        // **Método: message**
        // Permite establecer el mensaje de la notificación.
        public Builder message(String message) {
            this.message = message;
            return this;
        }

        // **Método: notificationType**
        // Permite establecer el tipo de la notificación.
        public Builder notificationType(NotificationType notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        // **Método: channel**
        // Permite establecer el canal de notificación (EMAIL, SMS, PUSH).
        public Builder channel(NotificationChannel channel) {
            this.channel = channel;
            return this;
        }

        // **Método: build**
        // Construye una instancia de `Notification` con los valores especificados.
        public Notification build() {
            return new Notification(this);
        }
    }

    // **Getters**
    // Permiten acceder a los atributos de la clase de manera inmutable.
    public Date getDate() {
        return date;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public NotificationChannel getChannel() {
        return channel;
    }
}
