package co.cue.edu.ticventory.ticventory.notification.repository;

import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * **Clase NotificationLogRepository**
 *
 * - Actúa como un repositorio para gestionar los registros de notificaciones enviadas.
 * - Proporciona métodos para guardar y recuperar registros.
 *
 * **Patrón aplicado: Repository**
 * - Este patrón abstrae la lógica de acceso a datos, permitiendo que otras partes del sistema
 *   interactúen con los registros sin conocer detalles sobre cómo se almacenan.
 *
 * **Uso en el sistema:**
 * - Utilizado por la clase `NotificationService` para registrar y recuperar el historial
 *   de notificaciones enviadas.
 */
@Repository
public class NotificationLogRepository {

    // **Lista interna para almacenar los registros**
    // Actualmente simula una base de datos utilizando una lista en memoria.
    private final List<NotificationLog> logs = new ArrayList<>();

    /**
     * **Método: save**
     *
     * - Guarda un nuevo registro de notificación en la lista.
     * - **Patrón aplicado:** Repository.
     *   Este método abstrae la lógica de almacenamiento, permitiendo que otras partes del sistema
     *   simplemente llamen a `save` sin preocuparse por cómo se implementa el almacenamiento.
     */
    public void save(NotificationLog log) {
        logs.add(log); // Agrega el registro a la lista en memoria.
    }

    /**
     * **Método: findAll**
     *
     * - Recupera todos los registros de notificaciones almacenados.
     * - **Patrón aplicado:** Repository.
     *   Proporciona una interfaz consistente para acceder a los datos almacenados.
     *
     * @return Lista de todos los registros de notificaciones.
     */
    public List<NotificationLog> findAll() {
        return logs; // Devuelve todos los registros almacenados en la lista.
    }
}
