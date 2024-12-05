package co.cue.edu.ticventory.ticventory;

import co.cue.edu.ticventory.ticventory.notification.exceptions.NotificationException;
import co.cue.edu.ticventory.ticventory.notification.mapping.NotificationRequest;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import co.cue.edu.ticventory.ticventory.notification.models.Recipient;
import co.cue.edu.ticventory.ticventory.notification.repository.NotificationLogRepository;
import co.cue.edu.ticventory.ticventory.notification.services.NotificationService;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Clase de prueba unitaria para NotificationService.
 */
class NotificationServiceTest {

    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private NotificationLogRepository notificationLogRepository;

    public NotificationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Prueba para el caso exitoso del método sendNotification.
     */
    @Test
    void testSendNotificationSuccess() {
        // Configuración de datos válidos
        NotificationRequest request = new NotificationRequest();
        request.setMessage("Mensaje de prueba");
        request.setChannel(NotificationChannel.EMAIL); // Usamos el tipo correcto (NotificationChannel)
        request.setNotificationType(NotificationType.PRESTAMO); // Establecemos el tipo de notificación

        // Asegurarse de crear un destinatario válido (suponiendo que 'Recipient' tiene un constructor que acepta un email)
        Recipient recipient = new Recipient("Juan Pérez", "1234", "test@example.com", "123456789");
        request.setRecipient(recipient); // Asignación correcta del destinatario

        // Configurar el comportamiento del mock para que no haga nada al guardar el log
        doNothing().when(notificationLogRepository).save(any(NotificationLog.class));

        // Llamar al método del servicio y verificar que no lanza ninguna excepción
        assertDoesNotThrow(() -> notificationService.sendNotification(request));

        // Verificar que el repositorio fue llamado correctamente
        verify(notificationLogRepository, times(1)).save(any(NotificationLog.class));
    }

    /**
     * Prueba para el caso de error del método sendNotification.
     */
    @Test
    void testSendNotificationError() {
        // Configuración de datos inválidos (canal no soportado)
        NotificationRequest request = new NotificationRequest();
        request.setMessage("Mensaje de prueba");
        request.setChannel(null); // Canal inválido para provocar el error

        // Llamar al método y verificar que lanza una excepción
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            notificationService.sendNotification(request);
        });

        // Verificar el mensaje de la excepción
        assertEquals("Canal no soportado: null", exception.getMessage());
    }

    /**
     * Prueba para el caso exitoso del método getNotificationHistory.
     */
    @Test
    void testGetNotificationHistorySuccess() throws NotificationException {
        // Configuración de datos simulados
        List<NotificationLog> mockLogs = new ArrayList<>();
        mockLogs.add(new NotificationLog(
                "Mensaje 1",
                "ALERTA",
                NotificationChannel.EMAIL.name(), // Canal como String
                "Juan Pérez",
                "123456",
                new java.util.Date()
        ));

        // Configurar el comportamiento del mock
        when(notificationLogRepository.findAll()).thenReturn(mockLogs);

        // Llamar al método
        List<NotificationLog> result = notificationService.getNotificationHistory();

        // Verificar el resultado
        assertEquals(1, result.size());
        assertEquals("Mensaje 1", result.get(0).getMessage());

        // Verificar que el repositorio fue llamado una vez
        verify(notificationLogRepository, times(1)).findAll();
    }

    /**
     * Prueba para el caso de error del método getNotificationHistory.
     */
    @Test
    void testGetNotificationHistoryError() {
        // Configurar el mock para lanzar una excepción
        when(notificationLogRepository.findAll()).thenThrow(new RuntimeException("Error al obtener historial"));

        // Llamar al método y verificar que lanza una excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            notificationService.getNotificationHistory();
        });

        // Verificar el mensaje de la excepción
        assertEquals("Error al obtener historial", exception.getMessage());
    }
}
