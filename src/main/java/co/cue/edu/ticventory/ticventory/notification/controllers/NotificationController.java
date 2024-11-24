package co.cue.edu.ticventory.ticventory.notification.controllers;

import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    // Inyección de dependencias para delegar la lógica de negocio al servicio correspondiente.
    private final NotificationService notificationService;

    // **Patrón: Dependency Injection**
    // Spring inyecta `NotificationService` en el constructor para promover el desacoplamiento.
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        // **Patrón: Facade**
        // Este método simplifica el proceso de enviar notificaciones al cliente,
        // delegando toda la lógica al servicio `NotificationService`.
        notificationService.sendNotification(request);

        // Respuesta directa para el cliente sin exponer la complejidad interna.
        return ResponseEntity.ok("Notificación enviada");
    }

    @GetMapping("/history")
    public List<NotificationLog> getNotificationHistory() {
        // **Patrón: Facade**
        // Este método proporciona una interfaz simple para obtener el historial de notificaciones,
        // delegando al servicio toda la interacción con la capa de persistencia.
        return notificationService.getNotificationHistory();
    }
}
