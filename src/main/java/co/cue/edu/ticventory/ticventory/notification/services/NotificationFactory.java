package co.cue.edu.ticventory.ticventory.notification.services;

import co.cue.edu.ticventory.ticventory.notification.models.*;
import java.util.Date;

/**
 * Clase NotificationFactory
 * Patrón aplicado: Factory Method
 * - Proporciona un método estático para crear instancias de `Notification`.
 * - Encapsula la complejidad de la creación de objetos de tipo `Notification`, simplificando su uso.
 *
 * Relación con otros patrones:
 * - Usa el patrón Builder dentro del método `createNotification` para construir el objeto.
 */
public class NotificationFactory {

    /**
     * Método estático para crear una instancia de Notification.
     * Aplica el patrón Factory Method al proporcionar un único punto de acceso para la creación de notificaciones.
     */
    public static Notification createNotification(Recipient recipient, String message, NotificationType notificationType, NotificationChannel channel) {
        // Uso del patrón Builder para construir la instancia de Notification.
        return new Notification.Builder()
                .date(new Date())
                .recipient(recipient)
                .message(message)
                .notificationType(notificationType)
                .channel(channel)
                .build();
    }
}
