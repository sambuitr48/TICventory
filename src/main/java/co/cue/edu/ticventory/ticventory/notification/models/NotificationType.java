package co.cue.edu.ticventory.ticventory.notification.models;

/**
 * **Enumeración NotificationType**
 *
 * - Define los diferentes tipos de notificaciones que el sistema puede manejar.
 * - Cada valor de esta enumeración representa un tipo específico de notificación:
 *   - `PRESTAMO`: Notificaciones relacionadas con préstamos.
 *   - `CANCELACION`: Notificaciones sobre cancelaciones.
 *   - `SOLICITUD`: Notificaciones relacionadas con solicitudes.
 *   - `VENCIMIENTO`: Notificaciones sobre vencimientos.
 *
 * **Patrón aplicado: Singleton (implícito en enums)**
 * - En Java, las enumeraciones son una implementación implícita del patrón Singleton, lo que garantiza
 *   que cada tipo de notificación (PRESTAMO, CANCELACION, etc.) tenga una única instancia en toda la aplicación.
 *
 * **Uso en el sistema:**
 * - Se utiliza en la clase `Notification` para identificar el tipo de notificación que se está enviando.
 * - También se usa en el flujo de lógica del sistema para personalizar el manejo según el tipo.
 */
public enum NotificationType {
    PRESTAMO,      // Notificaciones de préstamo.
    CANCELACION,   // Notificaciones de cancelación.
    SOLICITUD,     // Notificaciones relacionadas con solicitudes.
    VENCIMIENTO    // Notificaciones sobre vencimientos.
}
