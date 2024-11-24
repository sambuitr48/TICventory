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

    // **Patrón: Factory Method**
    // Esta clase implementa el patrón Factory Method para crear instancias de enviadores de notificaciones.
    // Facilita la adición de nuevos tipos de enviadores sin modificar el resto del sistema.

    // **Patrón: Registry**
    // Se utiliza un registro (mapa estático) para almacenar las asociaciones entre los canales de notificación
    // y sus correspondientes proveedores de instancias (`Supplier`).
    private static final Map<NotificationChannel, Supplier<INotificationSender>> registry = new HashMap<>();

    // **Bloque estático para inicializar el registro**
    // Aquí se registran los proveedores iniciales de los enviadores de notificaciones.
    static {
        registry.put(NotificationChannel.EMAIL, EmailNotificationSender::new);
        registry.put(NotificationChannel.SMS, SmsNotificationSender::new);
        registry.put(NotificationChannel.PUSH, PushNotificationSender::new);
    }

    // **Método: getSender**
    // **Patrón: Factory Method**
    // Este método utiliza el registro para obtener el enviador apropiado según el canal de notificación solicitado.
    public static INotificationSender getSender(NotificationChannel channel) {
        // Se busca el proveedor correspondiente al canal en el registro.
        Supplier<INotificationSender> sender = registry.get(channel);

        // Si no se encuentra el canal, se lanza una excepción.
        if (sender == null) {
            throw new IllegalArgumentException("Canal no soportado: " + channel);
        }

        // Se obtiene y devuelve una nueva instancia del enviador.
        return sender.get();
    }

    // **Método: registerSender**
    // Este método permite agregar dinámicamente nuevos enviadores al registro.
    // **Patrón: Registry**
    public static void registerSender(NotificationChannel channel, Supplier<INotificationSender> senderSupplier) {
        registry.put(channel, senderSupplier);
    }
}
