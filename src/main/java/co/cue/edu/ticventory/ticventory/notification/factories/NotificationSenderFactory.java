package co.cue.edu.ticventory.ticventory.notification.factories;

import co.cue.edu.ticventory.ticventory.notification.interfaces.INotificationSender;
import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import co.cue.edu.ticventory.ticventory.notification.senders.EmailNotificationSender;
import co.cue.edu.ticventory.ticventory.notification.senders.PushNotificationSender;
import co.cue.edu.ticventory.ticventory.notification.senders.SmsNotificationSender;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationSenderFactory {

    private static final Map<NotificationChannel, Supplier<INotificationSender>> registry = new HashMap<>();

    static {
        registry.put(NotificationChannel.EMAIL, EmailNotificationSender::new);
        registry.put(NotificationChannel.SMS, SmsNotificationSender::new);
        registry.put(NotificationChannel.PUSH, PushNotificationSender::new);
    }

    public static INotificationSender getSender(NotificationChannel channel) {
        // Verificación para asegurarse de que el canal esté registrado
        Supplier<INotificationSender> sender = registry.get(channel);

        // Si no se encuentra el canal, lanzamos una excepción controlada
        if (sender == null) {
            throw new IllegalArgumentException("Canal no soportado: " + channel);
        }

        // Devolvemos el sender correspondiente
        return sender.get();
    }

    public static void registerSender(NotificationChannel channel, Supplier<INotificationSender> senderSupplier) {
        registry.put(channel, senderSupplier);
    }
}
