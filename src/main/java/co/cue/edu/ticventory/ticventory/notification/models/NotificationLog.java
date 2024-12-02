package co.cue.edu.ticventory.ticventory.notification.models;

import java.util.Date;

/**
 * **Clase: NotificationLog**
 *
 * - Esta clase representa un registro de la notificación enviada. Contiene información relevante sobre el mensaje
 *   enviado, el tipo de notificación, el canal utilizado, el destinatario, el identificador del documento asociado,
 *   y la fecha en que se envió.
 *
 * **Patrón aplicado: No se aplica un patrón específico aquí.**
 * - Esta clase no sigue un patrón de diseño específico como las anteriores (por ejemplo, Builder, Singleton).
 *   Sin embargo, su propósito es ser un simple modelo de datos o DTO (Data Transfer Object) que transporta la información
 *   de las notificaciones enviadas.
 * - La clase puede ser vista como parte de una implementación de patrón **Repository** si se utiliza para persistir registros
 *   de notificaciones en una base de datos.
 *
 * **Uso en el sistema:**
 * - Se utiliza para almacenar y representar información acerca de las notificaciones enviadas para su posterior registro o auditoría.
 * - Es útil para almacenar información que podría necesitarse más tarde, por ejemplo, en un historial de notificaciones enviadas.
 */
public class NotificationLog {

    private String message;
    private String notificationType;
    private String channel;
    private String recipientName;
    private String documentId;
    private Date date;

    // **Constructor**
    // Inicializa todos los atributos necesarios para representar un log de notificación.
    public NotificationLog(String message, String notificationType, String channel, String recipientName, String documentId, Date date) {
        this.message = message;
        this.notificationType = notificationType;
        this.channel = channel;
        this.recipientName = recipientName;
        this.documentId = documentId;
        this.date = date;
    }

    // **Getters**
    // Estos métodos permiten acceder a los valores de los atributos de la clase de manera segura e inmutable.
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
