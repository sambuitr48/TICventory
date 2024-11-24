package co.cue.edu.ticventory.ticventory.notification.models;

import java.util.Date;

/**
 * **Clase NotificationLog**
 *
 * - Representa un registro de una notificación enviada, incluyendo información importante como el mensaje,
 *   el tipo de notificación, el canal utilizado, y los datos del destinatario.
 * - Proporciona una estructura para almacenar los metadatos de cada notificación enviada.
 *
 * **Patrón aplicado: Value Object**
 * - La clase implementa el concepto de un Value Object porque su propósito es representar datos inmutables
 *   relacionados con un evento específico (en este caso, una notificación enviada).
 * - **Inmutabilidad:** Todos los atributos son finales, lo que asegura que no se puedan modificar
 *   después de inicializarse, alineándose con las buenas prácticas de diseño.
 */
public class NotificationLog {

    // **Atributos inmutables**
    // Estos atributos contienen los metadatos de la notificación enviada.
    private final String message;              // Mensaje enviado en la notificación.
    private final String notificationType;     // Tipo de notificación (por ejemplo, PRESTAMO, ALERTA).
    private final String channel;              // Canal utilizado (EMAIL, SMS, PUSH).
    private final String recipientName;        // Nombre del destinatario de la notificación.
    private final String recipientDocument;    // Documento de identidad del destinatario.
    private final Date date;                   // Fecha y hora en que se envió la notificación.

    /**
     * **Constructor**
     *
     * - Inicializa todos los atributos del registro de notificación.
     * - **Inmutabilidad:** Los atributos se inicializan una vez y no pueden cambiar después.
     */
    public NotificationLog(String message, String notificationType, String channel, String recipientName, String recipientDocument, Date date) {
        this.message = message;
        this.notificationType = notificationType;
        this.channel = channel;
        this.recipientName = recipientName;
        this.recipientDocument = recipientDocument;
        this.date = date;
    }

    // **Getters**
    // Proveen acceso de solo lectura a los atributos de la clase, respetando su inmutabilidad.

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

    public String getRecipientDocument() {
        return recipientDocument;
    }

    public Date getDate() {
        return date;
    }
}
