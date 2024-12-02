package co.cue.edu.ticventory.ticventory.notification.senders;

import co.cue.edu.ticventory.ticventory.notification.interfaces.INotificationSender;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;

/**
 * **Clase PushNotificationSender**
 *
 * - Implementa una estrategia específica para enviar notificaciones push.
 *
 * **Patrón aplicado: Strategy**
 * - La clase utiliza el patrón **Strategy** al implementar la interfaz `INotificationSender`.
 * - Proporciona una estrategia concreta para enviar notificaciones a través del canal push.
 * - **Strategy** permite que el comportamiento de envío de notificaciones sea intercambiable según el canal, sin modificar el código del cliente.
 *
 * **Uso en el sistema:**
 * - Esta clase es utilizada por `NotificationSenderFactory` para instanciar un enviador cuando el canal de notificación especificado es `PUSH`.
 * - También es invocada por `NotificationService` para enviar notificaciones utilizando esta estrategia concreta.
 * - Facilita la extensibilidad, ya que se podrían agregar otras clases para otros canales de notificación (por ejemplo, SMS o EMAIL) sin modificar la lógica de la clase `NotificationService`.
 */
public class PushNotificationSender implements INotificationSender {

    /**
     * **Método: send**
     *
     * - Implementa el contrato definido por la interfaz `INotificationSender`.
     * - Proporciona la lógica específica para enviar notificaciones push.
     * - Este método define cómo el sistema interactúa con el servicio de notificaciones push (actualmente simulado con un `System.out.println`).
     *
     * **Principio SOLID Aplicado:**
     * - **Single Responsibility Principle (SRP):** La clase `PushNotificationSender` tiene una única responsabilidad: enviar notificaciones push. No se encarga de otra lógica, lo que cumple con el principio de responsabilidad única.
     * - **Interface Segregation Principle (ISP):** Al implementar `INotificationSender`, esta clase ofrece solo el comportamiento necesario para enviar notificaciones. No obliga a los clientes a implementar métodos que no sean relevantes, lo cual es una buena práctica según el principio ISP.
     * - **Dependency Inversion Principle (DIP):** Aunque la clase depende de `Recipient` e `INotificationSender`, esta dependencia se inyecta mediante la fábrica `NotificationSenderFactory`, lo que asegura que `PushNotificationSender` puede ser reemplazado o extendido fácilmente sin cambiar la lógica de otras clases.
     */
    @Override
    public void send(String message, Recipient recipient) {
        // Simula el envío de una notificación push imprimiendo en la consola.
        System.out.println("Enviando notificación push a: " + recipient.getName());
        System.out.println(" con el mensaje: " + message);
    }
}
