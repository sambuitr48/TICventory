package co.cue.edu.ticventory.ticventory.notification.senders;

import co.cue.edu.ticventory.ticventory.notification.interfaces.INotificationSender;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;

/**
 * **Clase SmsNotificationSender**
 *
 * - Implementa una estrategia específica para enviar notificaciones mediante SMS.
 *
 * **Patrón aplicado: Strategy**
 * - Esta clase utiliza el patrón **Strategy** al implementar la interfaz `INotificationSender`.
 * - Proporciona una estrategia concreta para el envío de notificaciones a través del canal SMS.
 * - **Strategy** permite que el comportamiento de envío de notificaciones sea intercambiable según el canal, sin modificar el código del cliente.
 *
 * **Uso en el sistema:**
 * - Utilizada por `NotificationSenderFactory` para crear un enviador cuando el canal especificado es `SMS`.
 * - Invocada por `NotificationService` para enviar notificaciones utilizando esta estrategia concreta.
 * - Facilita la extensibilidad, ya que se pueden agregar otras clases para diferentes canales de notificación, como `EmailNotificationSender` o `PushNotificationSender`, sin necesidad de modificar otras partes del sistema.
 */
public class SmsNotificationSender implements INotificationSender {

    /**
     * **Método: send**
     *
     * - Implementa el contrato definido por la interfaz `INotificationSender`.
     * - Proporciona la lógica específica para enviar notificaciones mediante SMS.
     * - Este método define cómo el sistema interactúa con el servicio de notificación SMS (actualmente simulado con un `System.out.println`).
     *
     * **Principio SOLID Aplicado:**
     * - **Single Responsibility Principle (SRP):** La clase `SmsNotificationSender` tiene **una única responsabilidad**: enviar notificaciones por SMS. No se encarga de ninguna otra lógica, lo que cumple con el principio de responsabilidad única.
     * - **Interface Segregation Principle (ISP):** Al implementar `INotificationSender`, esta clase ofrece solo el comportamiento necesario para enviar notificaciones. No obliga a los clientes a implementar métodos que no sean relevantes, lo cual es una buena práctica según el principio ISP.
     * - **Dependency Inversion Principle (DIP):** La clase depende de `Recipient` e `INotificationSender`, pero estas dependencias se inyectan a través de la fábrica `NotificationSenderFactory`. Esto asegura que `SmsNotificationSender` puede ser reemplazado o extendido fácilmente sin cambiar la lógica de otras clases.
     */
    @Override
    public void send(String message, Recipient recipient) {
        // Simula el envío de un mensaje SMS imprimiendo en la consola.
        System.out.println("Enviando SMS a: " + recipient.getPhone());
        System.out.println(" con el mensaje: " + message);
    }
}
