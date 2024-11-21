package co.cue.edu.ticventory.ticventory.notification.repository;

import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para manejar el historial de notificaciones.
 */
@Repository
public interface NotificationLogRepository extends MongoRepository<NotificationLog, String> {
}

