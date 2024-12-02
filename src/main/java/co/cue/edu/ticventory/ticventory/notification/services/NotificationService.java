package co.cue.edu.ticventory.ticventory.notification.services;

import co.cue.edu.ticventory.ticventory.notification.factories.NotificationSenderFactory;
import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.models.Notification;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.repository.NotificationLogRepository;
import co.cue.edu.ticventory.ticventory.notification.exceptions.NotificationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationLogRepository logRepository;

    public NotificationService(NotificationLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    /**
     * **Método para enviar una notificación**
     *
     * Este método crea una notificación basada en la información del request,
     * la envía a través del canal adecuado y guarda un registro del envío en el repositorio.
     *
     * **Excepciones:**
     * Lanza una `NotificationException` si ocurre algún error en el proceso de envío o registro de la notificación.
     *
     * @param request Información de la notificación a enviar.
     * @throws NotificationException Si ocurre un error en el envío de la notificación o el guardado del log.
     */
    public void sendNotification(NotificationRequest request) throws NotificationException {
        try {
            // Crear la notificación
            Notification notification = new Notification.Builder()
                    .date(new java.util.Date())
                    .recipient(request.getRecipient())
                    .message(request.getMessage())
                    .notificationType(request.getNotificationType())
                    .channel(request.getChannel())
                    .build();

            // Asegurarse de que el documentId sea un String
            String documentId = String.valueOf(notification.getRecipient().getDocumentId()); // Convertir el documentId a String

            // Enviar la notificación usando el sender adecuado
            var sender = NotificationSenderFactory.getSender(request.getChannel());
            sender.send(notification.getMessage(), notification.getRecipient());

            // Crear el log de la notificación
            NotificationLog log = new NotificationLog(
                    notification.getMessage(),
                    notification.getNotificationType().toString(),
                    notification.getChannel().toString(),
                    notification.getRecipient().getName(),
                    documentId,  // Usamos el documentId como String
                    notification.getDate()
            );

            // Guardar el log
            logRepository.save(log);
        } catch (Exception ex) {
            // Lanzamos una NotificationException con el mensaje y la causa
            throw new NotificationException("Error al enviar la notificación: " + ex.getMessage(), ex);
        }
    }

    /**
     * **Método para obtener el historial de notificaciones**
     *
     * Este método recupera todos los registros de notificaciones almacenados.
     *
     * @return Lista de registros de notificaciones.
     * @throws NotificationException Si ocurre un error al recuperar el historial de notificaciones.
     */
    public List<NotificationLog> getNotificationHistory() throws NotificationException {
        try {
            return logRepository.findAll();
        } catch (Exception ex) {
            throw new NotificationException("Error al obtener el historial de notificaciones: " + ex.getMessage(), ex);
        }
    }
}
