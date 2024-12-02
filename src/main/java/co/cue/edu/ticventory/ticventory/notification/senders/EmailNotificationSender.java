package co.cue.edu.ticventory.ticventory.notification.senders;

import co.cue.edu.ticventory.ticventory.notification.interfaces.INotificationSender;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;
import org.springframework.stereotype.Component;

/**
 * **Clase EmailNotificationSender**
 *
 * - Implementa una estrategia específica para enviar notificaciones por correo electrónico.
 *
 * **Patrón aplicado: Strategy**
 * - La clase utiliza el patrón Strategy al implementar la interfaz `INotificationSender`.
 * - Proporciona una estrategia concreta para enviar notificaciones, en este caso, por correo electrónico.
 *
 * **Uso en el sistema:**
 * - Esta clase es utilizada por `NotificationSenderFactory` para instanciar un enviador cuando
 *   el canal de notificación especificado es `EMAIL`.
 * - También es invocada por `NotificationService` para enviar notificaciones según la estrategia seleccionada.
 */
@Component
public class EmailNotificationSender implements INotificationSender {

    /**
     * **Método: send**
     *
     * - Implementa el contrato definido por la interfaz `INotificationSender`.
     * - Proporciona la lógica específica para enviar notificaciones por correo electrónico.
     */
    @Override
    public void send(String message, Recipient recipient) {
        // Simula el envío de un correo electrónico imprimiendo en la consola.
        System.out.println("Enviando email a: " + recipient.getEmail());
        System.out.println(" con el mensaje: " + message);
    }
}
