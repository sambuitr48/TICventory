package co.cue.edu.ticventory.ticventory.notification;


import co.cue.edu.ticventory.ticventory.people.Person;

import java.util.Date;
/**
 * Clase Factory que se encarga de crear instancias de la clase Notification.
 * Utiliza el patrón de diseño Factory para generar objetos Notification de manera sencilla.
 */
public class NotificationFactory {
    /**
     * Método estático que crea una nueva notificación.
     *
     * @param recipient La persona que recibirá la notificación.
     * @param message El mensaje que contiene la notificación.
     * @param notificationType El tipo de notificación (por ejemplo, alerta, recordatorio).
     * @param channel El canal a través del cual se enviará la notificación (por ejemplo, correo electrónico, SMS).
     * @return Una nueva instancia de Notification con la fecha actual, el destinatario, el mensaje, el tipo de notificación y el canal.
     */
    public static Notification createNotification(Person recipient, String message, NotificationType notificationType, NotificationChannel channel) {
        return new Notification(new Date(), recipient, message, notificationType, channel);
    }
}
