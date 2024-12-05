package co.cue.edu.ticventory.ticventory;

import co.cue.edu.ticventory.ticventory.notification.controllers.NotificationController;

import co.cue.edu.ticventory.ticventory.notification.exceptions.NotificationException;

import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;
import co.cue.edu.ticventory.ticventory.notification.services.NotificationService;

import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.exceptions.NotificationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NotificationController.class)
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotificationService notificationService;

    private NotificationRequest notificationRequest;

    @BeforeEach
    void setUp() {
        // Configura el objeto de solicitud con valores de prueba
        notificationRequest = new NotificationRequest();
        notificationRequest.setMessage("Mensaje de prueba");
        notificationRequest.setNotificationType(NotificationType.PRESTAMO);
        notificationRequest.setChannel(NotificationChannel.EMAIL);
        notificationRequest.setRecipient(new Recipient("Juan Pérez", "12345", "juan@email.com", "555123456"));
    }

    /**
     * Test que verifica el comportamiento exitoso del endpoint POST /api/notifications/send.
     * Se simula que el servicio maneja correctamente el envío de una notificación.
     */
    @Test
    void testSendNotificationSuccess() throws NotificationException {
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
    void testSendNotification_success() throws Exception {
        // Simula el comportamiento exitoso del servicio
        doNothing().when(notificationService).sendNotification(any(NotificationRequest.class));

        mockMvc.perform(post("/api/notifications/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"Mensaje de prueba\", \"notificationType\":\"PRESTAMO\", \"channel\":\"EMAIL\", \"recipient\":{\"name\":\"Juan Pérez\", \"documentId\":\"12345\", \"email\":\"juan@email.com\", \"phone\":\"555123456\"}}"))
                .andExpect(status().isOk())  // Espera que el código de estado de la respuesta sea 200 OK
                .andExpect(content().string("Notificación enviada"));  // Verifica que el contenido de la respuesta sea "Notificación enviada"

        // Verifica que el servicio fue llamado correctamente con los parámetros esperados
        verify(notificationService, times(1)).sendNotification(any(NotificationRequest.class));
    }

    /**
     * Test que verifica el comportamiento cuando ocurre un fallo al intentar enviar una notificación.
     * Se simula una excepción NotificationException.
     */
    @Test
    void testSendNotificationError() throws NotificationException {
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
    void testSendNotification_failure() throws Exception {
        // Simula un error en el servicio
        doThrow(new NotificationException("Error al enviar la notificación")).when(notificationService).sendNotification(any(NotificationRequest.class));

        mockMvc.perform(post("/api/notifications/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"Mensaje de prueba\", \"notificationType\":\"PRESTAMO\", \"channel\":\"EMAIL\", \"recipient\":{\"name\":\"Juan Pérez\", \"documentId\":\"12345\", \"email\":\"juan@email.com\", \"phone\":\"555123456\"}}"))
                .andExpect(status().isInternalServerError())  // Espera un código de estado 500 en caso de error
                .andExpect(content().string("Error al enviar la notificación: Error al enviar la notificación"));  // Verifica que el mensaje de error sea el esperado

        // Verifica que el servicio fue llamado correctamente con los parámetros esperados
        verify(notificationService, times(1)).sendNotification(any(NotificationRequest.class));
    }

    /**
     * Test que verifica el comportamiento exitoso del endpoint GET /api/notifications/history.
     * Se simula que el servicio devuelve un historial de notificaciones.
     */
    @Test
    void testGetNotificationHistorySuccess() throws NotificationException {
        // Configuración del mock: el servicio devuelve una lista de logs simulados
        List<NotificationLog> mockLogs = new ArrayList<>();
        mockLogs.add(new NotificationLog("Mensaje 1", "PRESTAMO", "EMAIL", "Juan Pérez", "123456", new java.util.Date()));
        when(notificationService.getNotificationHistory()).thenReturn(mockLogs);


// Llamada al método del controlador
        List<NotificationLog> logs = (List<NotificationLog>) notificationController.getNotificationHistory();
        // Verificaciones:
        // - La lista devuelta debe tener un elemento
        assertEquals(1, logs.size());
        // - El mensaje del primer elemento debe coincidir con el configurado en el mock
        assertEquals("Mensaje 1", logs.get(0).getMessage());
        // - Verificar que el servicio fue llamado una vez

    void testGetNotificationHistory_success() throws Exception {
        // Simula el comportamiento del servicio con un historial de notificaciones
        NotificationLog log = new NotificationLog("Mensaje de prueba", "PRESTAMO", "EMAIL", "Juan Pérez", "12345", new java.util.Date());
        List<NotificationLog> logs = Arrays.asList(log);
        when(notificationService.getNotificationHistory()).thenReturn(logs);

        mockMvc.perform(get("/api/notifications/history"))
                .andExpect(status().isOk())  // Espera que el código de estado de la respuesta sea 200 OK
                .andExpect(jsonPath("$.length()").value(1))  // Verifica que la lista de notificaciones tenga 1 elemento
                .andExpect(jsonPath("$[0].message").value("Mensaje de prueba"))  // Verifica que el mensaje de la primera notificación sea "Mensaje de prueba"
                .andExpect(jsonPath("$[0].recipientName").value("Juan Pérez"));  // Verifica que el nombre del receptor sea "Juan Pérez"

        // Verifica que el servicio fue llamado correctamente con los parámetros esperados
        verify(notificationService, times(1)).getNotificationHistory();
    }

    /**
     * Test que verifica el comportamiento cuando ocurre un fallo al intentar obtener el historial de notificaciones.
     * Se simula una excepción en el servicio.
     */
    @Test
    void testGetNotificationHistoryError() throws NotificationException {
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
    void testGetNotificationHistory_failure() throws Exception {
        // Simula un error en el servicio al obtener el historial
        when(notificationService.getNotificationHistory()).thenThrow(new RuntimeException("Error al obtener el historial"));

        mockMvc.perform(get("/api/notifications/history"))
                .andExpect(status().isInternalServerError())  // Espera un código de estado 500 en caso de error
                .andExpect(content().string("[]"));  // Espera una lista vacía como respuesta

        // Verifica que el servicio fue llamado correctamente con los parámetros esperados
        verify(notificationService, times(1)).getNotificationHistory();
    }
}
