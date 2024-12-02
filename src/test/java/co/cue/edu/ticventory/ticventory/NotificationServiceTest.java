package co.cue.edu.ticventory.ticventory;

import co.cue.edu.ticventory.ticventory.notification.exceptions.NotificationException;
import co.cue.edu.ticventory.ticventory.notification.interfaces.INotificationSender;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;
import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
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
    private INotificationSender notificationSender;  // Mock de NotificationSender

    @InjectMocks
    private NotificationService notificationService;

    private NotificationRequest notificationRequest;

    @BeforeEach
    void setUp() {
        // Inicializa los mocks
        MockitoAnnotations.openMocks(this);

        // Asegúrate de que el canal y otros parámetros están correctamente configurados
        notificationRequest = new NotificationRequest();
        notificationRequest.setMessage("Mensaje de prueba");
        notificationRequest.setNotificationType(NotificationType.PRESTAMO);
        notificationRequest.setChannel(NotificationChannel.EMAIL);  // Asegúrate de que esto no sea null
        notificationRequest.setRecipient(new Recipient("Juan Pérez", "12345", "juan@email.com", "555123456"));
    }

    @Test
    void testSendNotification_success() {
        // Simula que el repositorio guarda la notificación correctamente
        doNothing().when(notificationLogRepository).save(any(NotificationLog.class));

        // Corrección: Usa when() con un método llamado en el mock
        when(notificationSenderFactory.getSender(NotificationChannel.EMAIL))
                .thenReturn(notificationSender);

        // Simula el método de envío
        doNothing().when(notificationSender).send(anyString(), any(Recipient.class));

        try {
            notificationService.sendNotification(notificationRequest);
        } catch (NotificationException e) {
            fail("Exception should not have been thrown");
        }

        // Verifica que el método save del repositorio fue llamado una vez con el objeto esperado
        verify(notificationLogRepository, times(1)).save(any(NotificationLog.class));

        // Verifica que el método de envío fue invocado
        verify(notificationSender, times(1)).send(anyString(), any(Recipient.class));
    }

    @Test
    void testSendNotification_failure() {
        // Simula que el repositorio lanza una excepción al intentar guardar la notificación
        doThrow(new RuntimeException("Error al guardar la notificación")).when(notificationLogRepository).save(any(NotificationLog.class));

        try {
            notificationService.sendNotification(notificationRequest);
            fail("Exception should have been thrown");
        } catch (NotificationException e) {
            assertEquals("Error al enviar la notificación: Error al guardar la notificación", e.getMessage());
        }
    }

    @Test
    void testGetNotificationHistory_success() throws NotificationException {
        NotificationLog log = new NotificationLog("Mensaje de prueba", "PRESTAMO", "EMAIL", "Juan Pérez", "12345", new java.util.Date());
        List<NotificationLog> logs = Arrays.asList(log);
        when(notificationLogRepository.findAll()).thenReturn(logs);

        List<NotificationLog> result = notificationService.getNotificationHistory();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Mensaje de prueba", result.get(0).getMessage());
    }

    @Test
    void testGetNotificationHistory_failure() throws NotificationException {
        when(notificationLogRepository.findAll()).thenThrow(new RuntimeException("Error al obtener el historial"));

        try {
            notificationService.getNotificationHistory();
            fail("Exception should have been thrown");
        } catch (NotificationException e) {
            assertEquals("Error al obtener el historial de notificaciones: Error al obtener el historial", e.getMessage());
        }
    }
}
