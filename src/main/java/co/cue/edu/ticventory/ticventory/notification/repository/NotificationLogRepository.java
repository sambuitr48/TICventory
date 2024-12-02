package co.cue.edu.ticventory.ticventory.notification.repository;

import co.cue.edu.ticventory.ticventory.notification.models.NotificationLog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * **Clase: NotificationLogRepository**
 *
 * - Esta clase actúa como un repositorio para almacenar y recuperar registros de notificaciones (`NotificationLog`).
 * - Utiliza una lista interna (`logs`) como fuente de almacenamiento, lo que implica que no está conectada a una base de datos real.
 * - Se marca con la anotación `@Repository`, lo que indica que esta clase es responsable de interactuar con la capa de persistencia de datos.
 *
 * **Patrón aplicado: Repository**
 * - **Repository** es un patrón de diseño que proporciona una interfaz para acceder a la persistencia de datos.
 * - En este caso, `NotificationLogRepository` maneja el almacenamiento y la recuperación de objetos `NotificationLog`.
 * - Este patrón facilita la separación de la lógica de acceso a datos de la lógica de negocio, haciendo que el código sea más modular y flexible.
 *
 * **Uso en el sistema:**
 * - La clase `NotificationLogRepository` será utilizada por otros componentes del sistema, como servicios o controladores, para almacenar y recuperar registros de notificaciones.
 * - Aunque actualmente usa una lista en memoria, en un escenario de producción este repositorio podría ser extendido para utilizar una base de datos real (por ejemplo, utilizando JPA o JDBC).
 */
@Repository
public class NotificationLogRepository {

    // **Atributo: logs**
    // Lista en memoria que almacena los registros de notificaciones. Esto se podría reemplazar por una base de datos en un entorno real.
    private final List<NotificationLog> logs = new ArrayList<>();

    // **Método: save**
    // Guarda un nuevo registro de notificación en la lista de logs.
    // **Patrón aplicado: Repository**
    // Este método forma parte de la lógica de persistencia del patrón Repository. Permite almacenar un objeto `NotificationLog`.
    public void save(NotificationLog log) {
        try {
            logs.add(log);  // Agrega el log a la lista
        } catch (Exception ex) {
            // En caso de error, se lanza una excepción envolviendo el mensaje original
            throw new RuntimeException("Error al guardar el registro de la notificación: " + ex.getMessage(), ex);
        }
    }

    // **Método: findAll**
    // Recupera todos los registros de notificaciones almacenados.
    // **Patrón aplicado: Repository**
    // Este método también pertenece al patrón Repository y es utilizado para acceder a los objetos `NotificationLog` almacenados.
    public List<NotificationLog> findAll() {
        try {
            return new ArrayList<>(logs);  // Devuelve una copia de la lista de logs
        } catch (Exception ex) {
            // En caso de error, se lanza una excepción envolviendo el mensaje original
            throw new RuntimeException("Error al recuperar los registros de notificaciones: " + ex.getMessage(), ex);
        }
    }
}
