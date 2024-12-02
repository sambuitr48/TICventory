package co.cue.edu.ticventory.ticventory;

// Importaciones necesarias para realizar las pruebas
import co.cue.edu.ticventory.ticventory.notification.controllers.NotificationController;
import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.services.NotificationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Clase de prueba para el controlador NotificationController.
 * Se verifica que los métodos del controlador funcionen correctamente en casos de éxito y error.
 */
class NotificationControllerTest {

    // Se inyecta el controlador bajo prueba, simulando sus dependencias
    @InjectMocks
    private NotificationController notificationController;

    // Mock del servicio NotificationService, utilizado como dependencia del controlador
    @Mock
    private NotificationService notificationService;

    /**
     * Constructor que inicializa los mocks utilizando MockitoAnnotations.
     */
    public NotificationControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Prueba para el caso exitoso del método sendNotification.
     * Se verifica que el controlador llame al servicio correctamente y devuelva una respuesta 200.
     */
    @Test
    void testSendNotificationSuccess() {
        // Configuración del mock: no hace nada cuando se llama al servicio
        NotificationRequest request = new NotificationRequest();
        doNothing().when(notificationService).sendNotification(request);

        // Llamada al método del controlador
        ResponseEntity<String> response = notificationController.sendNotification(request);

        // Verificaciones:
        // - El código de respuesta HTTP debe ser 200 (OK)
        assertEquals(200, response.getStatusCodeValue());
        // - El cuerpo de la respuesta debe ser "Notificación enviada"
        assertEquals("Notificación enviada", response.getBody());
        // - Verificar que el servicio fue llamado una vez
        verify(notificationService, times(1)).sendNotification(request);
    }

    /**
     * Prueba para el caso de error del método sendNotification.
     * Se verifica que el controlador maneje correctamente una excepción lanzada por el servicio.
     */
    @Test
    void testSendNotificationError() {
        // Configuración del mock: el servicio lanza una excepción
        NotificationRequest request = new NotificationRequest();
        doThrow(new RuntimeException("Error al enviar notificación"))
                .when(notificationService).sendNotification(request);

        // Verificación:
        // - Se espera que el controlador lance la misma excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            notificationController.sendNotification(request);
        });

        // - El mensaje de la excepción debe coincidir con el configurado en el mock
        assertEquals("Error al enviar notificación", exception.getMessage());
        // - Verificar que el servicio fue llamado una vez
        verify(notificationService, times(1)).sendNotification(request);
    }

    /**
     * Prueba para el caso exitoso del método getNotificationHistory.
     * Se verifica que el controlador devuelva correctamente el historial de notificaciones.
     */
    @Test
    void testGetNotificationHistorySuccess() {
        // Configuración del mock: el servicio devuelve una lista de logs simulados
        List<NotificationLog> mockLogs = new ArrayList<>();
        mockLogs.add(new NotificationLog("Mensaje 1", "PRESTAMO", "EMAIL", "Juan Pérez", "123456", new java.util.Date()));
        when(notificationService.getNotificationHistory()).thenReturn(mockLogs);

        // Llamada al método del controlador
        List<NotificationLog> logs = notificationController.getNotificationHistory();

        // Verificaciones:
        // - La lista devuelta debe tener un elemento
        assertEquals(1, logs.size());
        // - El mensaje del primer elemento debe coincidir con el configurado en el mock
        assertEquals("Mensaje 1", logs.get(0).getMessage());
        // - Verificar que el servicio fue llamado una vez
        verify(notificationService, times(1)).getNotificationHistory();
    }

    /**
     * Prueba para el caso de error del método getNotificationHistory.
     * Se verifica que el controlador maneje correctamente una excepción lanzada por el servicio.
     */
    @Test
    void testGetNotificationHistoryError() {
        // Configuración del mock: el servicio lanza una excepción
        when(notificationService.getNotificationHistory()).thenThrow(new RuntimeException("Error al obtener historial"));

        // Verificación:
        // - Se espera que el controlador lance la misma excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            notificationController.getNotificationHistory();
        });

        // - El mensaje de la excepción debe coincidir con el configurado en el mock
        assertEquals("Error al obtener historial", exception.getMessage());
        // - Verificar que el servicio fue llamado una vez
        verify(notificationService, times(1)).getNotificationHistory();
    }
}
