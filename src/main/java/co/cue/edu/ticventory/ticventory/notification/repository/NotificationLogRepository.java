package co.cue.edu.ticventory.ticventory.notification.repository;

import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificationLogRepository {

    private final List<NotificationLog> logs = new ArrayList<>();

    public void save(NotificationLog log) {
        try {
            logs.add(log);
        } catch (Exception ex) {
            throw new RuntimeException("Error al guardar el registro de la notificación: " + ex.getMessage(), ex);
        }
    }

    public List<NotificationLog> findAll() {
        try {
            return new ArrayList<>(logs);
        } catch (Exception ex) {
            throw new RuntimeException("Error al recuperar los registros de notificaciones: " + ex.getMessage(), ex);
        }
    }
}
