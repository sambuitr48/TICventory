package co.cue.edu.ticventory.ticventory.notification.senders;

import co.cue.edu.ticventory.ticventory.notification.interfaces.INotificationSender;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;

/**
 * **Clase SmsNotificationSender**
 *
 * - Implementa una estrategia específica para enviar notificaciones mediante SMS.
 *
 * **Patrón aplicado: Strategy**
 * - Esta clase utiliza el patrón Strategy al implementar la interfaz `INotificationSender`.
 * - Proporciona una estrategia concreta para el envío de notificaciones a través del canal SMS.
 *
 * **Uso en el sistema:**
 * - Utilizada por `NotificationSenderFactory` para crear un enviador cuando el canal especificado es `SMS`.
 * - Invocada por `NotificationService` para enviar notificaciones utilizando esta estrategia.
 */
public class SmsNotificationSender implements INotificationSender {

    /**
     * **Método: send**
     *
     * - Implementa el contrato definido por la interfaz `INotificationSender`.
     * - Proporciona la lógica específica para enviar notificaciones mediante SMS.
     */
    @Override
    public void send(String message, Recipient recipient) {
        // Simula el envío de un mensaje SMS imprimiendo en la consola.
        System.out.println("Enviando SMS a: " + recipient.getPhone());
        System.out.println(" con el mensaje: " + message);
    }
}
