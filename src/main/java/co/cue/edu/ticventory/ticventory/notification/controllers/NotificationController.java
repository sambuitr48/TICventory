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

@RestController  // Indica que esta clase es un controlador REST en Spring
@RequestMapping("/api/notifications")  // Mapea las solicitudes HTTP a la URL especificada
public class NotificationController {

    private final NotificationService notificationService;  // Se inyecta una instancia de NotificationService

    // El constructor de la clase que recibe NotificationService como dependencia
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;  // Inicializa la variable con el servicio correspondiente
    }

    /**
     * **Método: sendNotification**
     * Este método recibe una solicitud HTTP POST para enviar una notificación.
     * - Recibe un objeto de tipo NotificationRequest que contiene los detalles de la notificación.
     * - Se delega la lógica de envío al NotificationService.
     * - Devuelve una respuesta HTTP que indica el éxito o el fallo del envío de la notificación.
     *
     * **Patrón aplicado:**
     * - **Facade**: Este patrón está presente al simplificar la interacción con el servicio NotificationService a través de la API. El controlador actúa como una fachada para que el cliente interactúe con la lógica de negocio sin necesidad de conocer los detalles internos.
     *
     * **Principios SOLID:**
     * - **Single Responsibility Principle (SRP)**: El controlador tiene una sola responsabilidad: recibir las solicitudes HTTP y delegar la lógica de negocio a los servicios correspondientes.
     * - **Dependency Injection (DI)**: El servicio `NotificationService` se inyecta a través del constructor, lo que facilita el desacoplamiento y la prueba unitaria del controlador.
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        try {
            // Delegación de la lógica al servicio NotificationService
            notificationService.sendNotification(request);
            return ResponseEntity.ok("Notificación enviada");
        } catch (NotificationException ex) {
            // Manejo de error específico de la notificación
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar la notificación: " + ex.getMessage());
        } catch (Exception ex) {
            // Manejo de cualquier otro error inesperado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error inesperado: " + ex.getMessage());
        }
    }

    /**
     * **Método: getNotificationHistory**
     * Este método recibe una solicitud HTTP GET para obtener el historial de notificaciones.
     * - Llama al servicio `NotificationService` para obtener los registros de las notificaciones enviadas.
     * - Devuelve una lista de objetos NotificationLog como respuesta HTTP.
     *
     * **Patrón aplicado:**
     * - **Facade**: Al igual que en el método anterior, el controlador proporciona una interfaz simplificada para que el cliente interactúe con el servicio de notificaciones y obtenga los registros.
     *
     * **Principios SOLID:**
     * - **Single Responsibility Principle (SRP)**: El controlador se encarga exclusivamente de recibir y responder a las solicitudes HTTP, delegando la lógica de negocio al servicio.
     * - **Dependency Injection (DI)**: Al igual que en el primer método, la dependencia de `NotificationService` está inyectada a través del constructor.
     */
    @GetMapping("/history")
    public ResponseEntity<List<NotificationLog>> getNotificationHistory() {
        try {
            // Llamada al servicio NotificationService para obtener el historial de notificaciones
            List<NotificationLog> logs = notificationService.getNotificationHistory();
            return ResponseEntity.ok(logs);
        } catch (Exception ex) {
            // Manejo de errores, en caso de que falle la obtención de registros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ArrayList<>());  // Devuelve una lista vacía en caso de error
        }
    }
}
