package co.cue.edu.ticventory.ticventory.notification.senders;

import co.cue.edu.ticventory.ticventory.notification.interfaces.INotificationSender;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;

/**
 * **Clase PushNotificationSender**
 *
 * - Implementa una estrategia específica para enviar notificaciones push.
 *
 * **Patrón aplicado: Strategy**
 * - La clase utiliza el patrón Strategy al implementar la interfaz `INotificationSender`.
 * - Proporciona una estrategia concreta para enviar notificaciones a través del canal push.
 *
 * **Uso en el sistema:**
 * - Esta clase es utilizada por `NotificationSenderFactory` para instanciar un enviador cuando
 *   el canal de notificación especificado es `PUSH`.
 * - También es invocada por `NotificationService` para enviar notificaciones utilizando esta estrategia.
 */
public class PushNotificationSender implements INotificationSender {

    /**
     * **Método: send**
     *
     * - Implementa el contrato definido por la interfaz `INotificationSender`.
     * - Proporciona la lógica específica para enviar notificaciones push.
     */
    @Override
    public void send(String message, Recipient recipient) {
        // Simula el envío de una notificación push imprimiendo en la consola.
        System.out.println("Enviando notificación push a: " + recipient.getName());
        System.out.println(" con el mensaje: " + message);
    }
}
