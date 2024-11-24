package co.cue.edu.ticventory.ticventory.notification.services;

import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;

/**
 * **Clase MessageTemplate**
 *
 * - Representa una plantilla de mensaje para notificaciones.
 * - Permite asociar un tipo de notificación (`NotificationType`) con un mensaje base
 *   y generar un mensaje final basado en ese tipo.
 *
 * **Patrón aplicado: Factory Support**
 * - Esta clase sirve como una plantilla que puede ser utilizada por el patrón Factory
 *   para crear mensajes de notificación dinámicos en base a su tipo.
 * - Además, permite extender la lógica de generación de mensajes en función del tipo de notificación.
 */
public class MessageTemplate {

    // **Atributos**
    private String message;                    // Mensaje base de la plantilla.
    private NotificationType notificationType; // Tipo de notificación asociado a esta plantilla.

    /**
     * **Constructor**
     *
     * - Inicializa los atributos de la plantilla con un mensaje y un tipo de notificación.
     */
    public MessageTemplate(String message, NotificationType notificationType) {
        this.message = message;
        this.notificationType = notificationType;
    }

    /**
     * **Método generateMessage**
     *
     * - Genera el mensaje basado en la plantilla.
     * - **Extensibilidad:** Aquí se puede incluir lógica adicional para personalizar el mensaje
     *   dependiendo del tipo de notificación (`notificationType`).
     *
     * @return El mensaje generado.
     */
    public String generateMessage() {
        // Por ahora, retorna el mensaje base sin modificaciones.
        // Podrías extender este método para generar un mensaje dinámico según el tipo.
        return message;
    }

    // **Getters y Setters**
    // Proveen acceso y modificación controlada a los atributos de la clase.

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
