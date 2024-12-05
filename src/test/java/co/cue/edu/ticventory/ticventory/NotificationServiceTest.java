package co.cue.edu.ticventory.ticventory;

import co.cue.edu.ticventory.ticventory.notification.exceptions.NotificationException;
import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.interfaces.INotificationSender;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.repository.NotificationLogRepository;
import co.cue.edu.ticventory.ticventory.notification.services.NotificationService;
import co.cue.edu.ticventory.ticventory.notification.factories.NotificationSenderFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Mock
    private NotificationLogRepository notificationLogRepository;

    @Mock
    private NotificationSenderFactory notificationSenderFactory;

    @Mock
    private INotificationSender notificationSender;

    @InjectMocks
    private NotificationService notificationService;

    private NotificationRequest notificationRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        notificationRequest = new NotificationRequest();
        notificationRequest.setMessage("Mensaje de prueba");
        notificationRequest.setNotificationType(NotificationType.PRESTAMO);
        notificationRequest.setChannel(NotificationChannel.EMAIL);
        notificationRequest.setRecipient(new Recipient("Juan Pérez", "12345", "juan@email.com", "555123456"));
    }

    @Test
    void testSendNotificationSuccess() throws NotificationException {
        when(notificationSenderFactory.getSender(NotificationChannel.EMAIL)).thenReturn(notificationSender);
        doNothing().when(notificationSender).send(anyString(), any(Recipient.class));
        doNothing().when(notificationLogRepository).save(any(NotificationLog.class));

        notificationService.sendNotification(notificationRequest);

        verify(notificationSender, times(1)).send(anyString(), any(Recipient.class));
        verify(notificationLogRepository, times(1)).save(any(NotificationLog.class));
    }

    @Test
    void testSendNotificationFailure() {
        doThrow(new RuntimeException("Error al guardar la notificación")).when(notificationLogRepository).save(any(NotificationLog.class));

        Exception exception = assertThrows(NotificationException.class, () -> {
            notificationService.sendNotification(notificationRequest);
        });

        assertEquals("Error al enviar la notificación: Error al guardar la notificación", exception.getMessage());
    }

    @Test
    void testGetNotificationHistorySuccess() throws NotificationException {
        NotificationLog log = new NotificationLog(
                "Mensaje de prueba",
                "PRESTAMO",
                NotificationChannel.EMAIL.name(),
                "Juan Pérez",
                "12345",
                new java.util.Date()
        );
        List<NotificationLog> logs = Arrays.asList(log);
        when(notificationLogRepository.findAll()).thenReturn(logs);

        List<NotificationLog> result = notificationService.getNotificationHistory();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Mensaje de prueba", result.get(0).getMessage());
    }

    @Test
    void testGetNotificationHistoryFailure() {
        when(notificationLogRepository.findAll()).thenThrow(new RuntimeException("Error al obtener el historial"));

        Exception exception = assertThrows(NotificationException.class, () -> {
            notificationService.getNotificationHistory();
        });

        assertEquals("Error al obtener el historial de notificaciones: Error al obtener el historial", exception.getMessage());
    }
}
