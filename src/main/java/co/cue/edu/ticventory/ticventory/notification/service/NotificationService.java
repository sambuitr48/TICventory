package co.cue.edu.ticventory.ticventory.notification.service;

import co.cue.edu.ticventory.ticventory.notification.models.Notification;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.people.Person;
import co.cue.edu.ticventory.ticventory.notification.repository.NotificationLogRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Servicio para manejar la lógica de notificaciones.
 *
 * Este servicio aplica el patrón de diseño Factory para crear notificaciones
 * usando la clase NotificationFactory y el patrón Observer para enviar
 * notificaciones a través de diferentes canales. Además, registra las notificaciones en un historial.
 */
@Service
public class NotificationService {
    private final NotificationObserver observer = new NotificationObserver(); // Implementación del patrón Observer
    private final NotificationLogRepository logRepository; // Repositorio para almacenar logs

    /**
     * Constructor del servicio que inyecta el repositorio de logs de notificaciones.
     *
     * @param logRepository Repositorio para almacenar el historial de notificaciones.
     */
    public NotificationService(NotificationLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    /**
     * Crea y envía una notificación.
     *
     * Aplica el patrón Factory para crear una instancia de Notification y
     * el patrón Observer para notificar a todos los canales registrados. También guarda la notificación en el historial.
     *
     * @param recipient Destinatario de la notificación.
     * @param message Mensaje de la notificación.
     * @param notificationType Tipo de la notificación.
     * @param channel Canal a través del cual se enviará la notificación.
     * @return La notificación creada.
     */
    public Notification createAndSendNotification(Person recipient, String message, NotificationType notificationType, NotificationChannel channel) {
        // Usamos la fábrica para crear la notificación
        Notification notification = NotificationFactory.createNotification(recipient, message, notificationType, channel);

        // Añadimos el canal al observador y notificamos
        observer.addChannel(channel);
        observer.notifyObservers(notification.getMessage());

        // Guardamos la notificación en el historial usando el repositorio
        logRepository.save(new NotificationLog(
                recipient.getNombre(), // Nombre del destinatario
                recipient.getDocumentoIdentidad(), // Documento del destinatario
                message, // Mensaje enviado
                notificationType.name(), // Tipo de notificación
                channel.name(), // Canal de envío
                new Date() // Fecha de envío
        ));

        return notification;
    }

    /**
     * Retorna el historial completo de notificaciones.
     *
     * @return Lista de todas las notificaciones registradas en el historial.
     */
    public List<NotificationLog> getNotificationHistory() {
        return logRepository.findAll();
    }
}
