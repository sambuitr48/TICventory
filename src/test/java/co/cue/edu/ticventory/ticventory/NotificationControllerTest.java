package co.cue.edu.ticventory.ticventory;

import co.cue.edu.ticventory.ticventory.notification.controllers.NotificationController;
import co.cue.edu.ticventory.ticventory.notification.exceptions.NotificationException;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;
import co.cue.edu.ticventory.ticventory.notification.services.NotificationService;
import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        notificationRequest = new NotificationRequest();
        notificationRequest.setMessage("Mensaje de prueba");
        notificationRequest.setNotificationType(NotificationType.PRESTAMO);
        notificationRequest.setChannel(NotificationChannel.EMAIL);
        notificationRequest.setRecipient(new Recipient("Juan Pérez", "12345", "juan@email.com", "555123456"));
    }

    @Test
    void testSendNotificationSuccess() throws Exception {
        doNothing().when(notificationService).sendNotification(any(NotificationRequest.class));

        mockMvc.perform(post("/api/notifications/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"Mensaje de prueba\", \"notificationType\":\"PRESTAMO\", \"channel\":\"EMAIL\", \"recipient\":{\"name\":\"Juan Pérez\", \"documentId\":\"12345\", \"email\":\"juan@email.com\", \"phone\":\"555123456\"}}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Notificación enviada"));

        verify(notificationService, times(1)).sendNotification(any(NotificationRequest.class));
    }

    @Test
    void testSendNotificationError() throws Exception {
        doThrow(new NotificationException("Error al enviar la notificación")).when(notificationService).sendNotification(any(NotificationRequest.class));

        mockMvc.perform(post("/api/notifications/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"Mensaje de prueba\", \"notificationType\":\"PRESTAMO\", \"channel\":\"EMAIL\", \"recipient\":{\"name\":\"Juan Pérez\", \"documentId\":\"12345\", \"email\":\"juan@email.com\", \"phone\":\"555123456\"}}"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Error al enviar la notificación: Error al enviar la notificación"));

        verify(notificationService, times(1)).sendNotification(any(NotificationRequest.class));
    }

    @Test
    void testGetNotificationHistorySuccess() throws Exception {
        NotificationLog log = new NotificationLog("Mensaje de prueba", "PRESTAMO", "EMAIL", "Juan Pérez", "12345", new java.util.Date());
        List<NotificationLog> logs = Arrays.asList(log);
        when(notificationService.getNotificationHistory()).thenReturn(logs);

        mockMvc.perform(get("/api/notifications/history"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].message").value("Mensaje de prueba"))
                .andExpect(jsonPath("$[0].recipientName").value("Juan Pérez"));

        verify(notificationService, times(1)).getNotificationHistory();
    }

    @Test
    void testGetNotificationHistoryError() throws Exception {
        when(notificationService.getNotificationHistory()).thenThrow(new RuntimeException("Error al obtener historial"));

        mockMvc.perform(get("/api/notifications/history"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Error al obtener historial"));

        verify(notificationService, times(1)).getNotificationHistory();
    }
}
