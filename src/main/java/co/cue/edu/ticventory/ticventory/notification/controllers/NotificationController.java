package co.cue.edu.ticventory.ticventory.notification.controllers;

import co.cue.edu.ticventory.ticventory.notification.models.Notification;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar las notificaciones.
 * Expone endpoints para enviar notificaciones y consultar el historial.
 */
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Endpoint para enviar una notificación.
     *
     * @param request Datos de la notificación.
     * @return La notificación creada.
     */
    @PostMapping("/send")
    public Notification sendNotification(@RequestBody NotificationRequest request) {
        Notification notification = notificationService.createAndSendNotification(
                request.getRecipient(),
                request.getMessage(),
                request.getNotificationType(),
                request.getChannel()
        );
        return notification;
    }

    /**
     * Endpoint para consultar el historial de notificaciones.
     *
     * @return Lista de logs de notificaciones.
     */
    @GetMapping("/history")
    public List<NotificationLog> getNotificationHistory() {
        return notificationService.getNotificationHistory();
    }
}
