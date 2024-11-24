package co.cue.edu.ticventory.ticventory.notification.services;

import co.cue.edu.ticventory.ticventory.notification.factories.NotificationSenderFactory;
import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.models.Notification;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.repository.NotificationLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * **Clase NotificationService**
 *
 * - Proporciona la lógica de negocio principal para el envío de notificaciones y el manejo de su historial.
 *
 * **Patrones aplicados:**
 * - **Factory Method:** Utiliza `NotificationSenderFactory` para obtener el enviador adecuado según el canal.
 * - **Builder:** Usa `Notification.Builder` para construir instancias de `Notification` de manera controlada.
 * - **Repository:** Interactúa con `NotificationLogRepository` para manejar el almacenamiento y recuperación de registros.
 *
 * **Uso en el sistema:**
 * - Esta clase es invocada por el controlador `NotificationController` para manejar las operaciones relacionadas con las notificaciones.
 */
@Service
public class NotificationService {

    // Repositorio para manejar los registros de notificaciones
    private final NotificationLogRepository logRepository;

    /**
     * **Constructor**
     *
     * - Recibe el repositorio como una dependencia inyectada por Spring.
     * - **Principio SOLID:** Dependency Inversion Principle (DIP).
     *   - Depende de una abstracción (`NotificationLogRepository`) en lugar de una implementación concreta.
     */
    public NotificationService(NotificationLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    /**
     * **Método sendNotification**
     *
     * - Gestiona el proceso completo de envío de una notificación.
     * - Aplica varios patrones de diseño:
     *   - **Builder:** Para construir la instancia de `Notification`.
     *   - **Factory Method:** Para obtener el enviador adecuado según el canal.
     *   - **Repository:** Para registrar la notificación en el historial.
     *
     * @param request Objeto `NotificationRequest` que contiene los datos de la notificación.
     */
    public void sendNotification(NotificationRequest request) {
        // **Patrón: Builder**
        // Construye una instancia de `Notification` utilizando el Builder para evitar constructores complejos.
        Notification notification = new Notification.Builder()
                .date(new java.util.Date())
                .recipient(request.getRecipient())
                .message(request.getMessage())
                .notificationType(request.getNotificationType())
                .channel(request.getChannel())
                .build();

        // **Patrón: Factory Method**
        // Obtiene el enviador correspondiente según el canal especificado en la solicitud.
        var sender = NotificationSenderFactory.getSender(request.getChannel());
        sender.send(notification.getMessage(), notification.getRecipient());

        // **Patrón: Repository**
        // Crea un registro de la notificación y lo guarda en el repositorio.
        NotificationLog log = new NotificationLog(
                notification.getMessage(),
                notification.getNotificationType().toString(),
                notification.getChannel().toString(),
                notification.getRecipient().getName(),
                notification.getRecipient().getDocumentId(),
                notification.getDate()
        );

        logRepository.save(log); // Guarda el registro en el repositorio.
    }

    /**
     * **Método getNotificationHistory**
     *
     * - Recupera el historial completo de notificaciones registradas.
     * - **Patrón aplicado:** Repository.
     *   - Delegación de la lógica de almacenamiento y recuperación al repositorio `NotificationLogRepository`.
     *
     */
    public List<NotificationLog> getNotificationHistory() {
        return logRepository.findAll();
    }
}
