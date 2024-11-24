package co.cue.edu.ticventory.ticventory.notification.interfaces;

import co.cue.edu.ticventory.ticventory.notification.models.Recipient;

// **Interfaz: INotificationSender**
// **Patrón aplicado: Strategy**
// Esta interfaz define una estrategia común para todos los enviadores de notificaciones.
// Cada implementación concreta (por ejemplo, EmailNotificationSender, SmsNotificationSender)
// tendrá su propia lógica para enviar notificaciones.
public interface INotificationSender {

    // **Método: send**
    // Este método define el contrato que deben implementar todos los enviadores de notificaciones.
    // **Principio SOLID:** Interface Segregation Principle (ISP).
    // La interfaz es específica para el comportamiento necesario en este contexto,
    // evitando que las implementaciones deban definir métodos innecesarios.
    void send(String message, Recipient recipient);
}
