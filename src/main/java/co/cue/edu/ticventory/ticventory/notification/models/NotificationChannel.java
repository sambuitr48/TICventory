package co.cue.edu.ticventory.ticventory.notification.models;

/**
 * **Enumeración NotificationChannel**
 *
 * - Representa los diferentes canales de notificación disponibles en el sistema.
 * - Cada valor de esta enumeración identifica un canal específico: EMAIL, SMS o PUSH.
 *
 * **Patrón aplicado: Singleton (implícito en enums)**
 * - En Java, las enumeraciones son una implementación implícita del patrón Singleton, ya que garantizan
 *   que cada valor de la enumeración (EMAIL, SMS, PUSH) sea único y exista una única instancia en toda la aplicación.
 *
 * **Uso en el sistema:**
 * - Se utiliza en otras partes del sistema, como en la clase `Notification` y en el `NotificationSenderFactory`,
 *   para determinar el canal por el cual se debe enviar una notificación.
 */
public enum NotificationChannel {
    EMAIL,
    SMS,
    PUSH
}
