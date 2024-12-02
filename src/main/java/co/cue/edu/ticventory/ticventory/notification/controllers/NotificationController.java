package co.cue.edu.ticventory.ticventory.notification.controllers;

import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.services.NotificationService;
import co.cue.edu.ticventory.ticventory.notification.exceptions.NotificationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        try {
            notificationService.sendNotification(request);
            return ResponseEntity.ok("Notificación enviada");
        } catch (NotificationException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar la notificación: " + ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error inesperado: " + ex.getMessage());
        }
    }

    @GetMapping("/history")
    public ResponseEntity<List<NotificationLog>> getNotificationHistory() {
        try {
            List<NotificationLog> logs = notificationService.getNotificationHistory();
            return ResponseEntity.ok(logs);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ArrayList<>());  // Empty list on failure
        }
    }
}
