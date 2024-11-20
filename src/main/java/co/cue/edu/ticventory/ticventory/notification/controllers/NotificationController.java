package co.cue.edu.ticventory.ticventory.notification.controllers;

import co.cue.edu.ticventory.ticventory.notification.models.Notification;
import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para manejar las notificaciones.
 * Expone un endpoint para enviar notificaciones.
 */
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Endpoint para enviar una notificación
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
}
