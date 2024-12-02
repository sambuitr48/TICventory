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

    /**
     * **Map de registro de proveedores (Supplier) para cada tipo de canal.**
     * Utiliza un mapa donde cada canal de notificación está asociado a un Supplier que crea instancias del respectivo INotificationSender.
     *
     * **Patrón aplicado:**
     * - **Factory Method**: La clase actúa como una fábrica para crear objetos de tipo `INotificationSender`. En lugar de crear instancias directamente, delega la creación en el proveedor (Supplier) registrado en el mapa.
     *
     * **Principios SOLID:**
     * - **Single Responsibility Principle (SRP)**: La responsabilidad principal de esta clase es crear y proporcionar instancias de `INotificationSender` para diferentes canales. No se involucra en ningún otro tipo de lógica o negocio.
     * - **Open/Closed Principle (OCP)**: La clase está abierta a la extensión (se pueden agregar nuevos canales de notificación) pero cerrada a la modificación (no es necesario cambiar el código de la fábrica para agregar un nuevo canal).
     */
    private static final Map<NotificationChannel, Supplier<INotificationSender>> registry = new HashMap<>();

    static {
        // Registro de proveedores para los canales de notificación.
        registry.put(NotificationChannel.EMAIL, EmailNotificationSender::new);
        registry.put(NotificationChannel.SMS, SmsNotificationSender::new);
        registry.put(NotificationChannel.PUSH, PushNotificationSender::new);
    }

    /**
     * **Método: getSender**
     * Este método devuelve un `INotificationSender` basado en el canal especificado.
     *
     * **Patrón aplicado:**
     * - **Factory Method**: Este método implementa el patrón Factory Method, ya que crea y devuelve una instancia concreta de `INotificationSender` basada en el canal especificado, sin necesidad de que el cliente conozca la clase concreta.
     *
     * **Principios SOLID:**
     * - **Liskov Substitution Principle (LSP)**: Este principio se sigue correctamente, ya que cualquier implementación de `INotificationSender` puede ser sustituida en este contexto sin afectar la funcionalidad del código.
     * - **Open/Closed Principle (OCP)**: Como el código permite registrar nuevos canales de notificación sin necesidad de modificar el método `getSender`, cumple con este principio. Se pueden agregar nuevas implementaciones de `INotificationSender` sin alterar la clase.
     */
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

    /**
     * **Método: registerSender**
     * Este método permite registrar un nuevo proveedor de instancias de `INotificationSender` para un canal específico.
     *
     * **Patrón aplicado:**
     * - **Factory Method**: De nuevo, este método mantiene el patrón Factory, ya que permite registrar nuevos proveedores de creación de instancias para canales específicos.
     *
     * **Principios SOLID:**
     * - **Open/Closed Principle (OCP)**: Este método cumple con el principio OCP, ya que se pueden registrar nuevos canales de notificación sin tener que modificar la clase existente, simplemente llamando a `registerSender` con un nuevo `Supplier`.
     */
    public static void registerSender(NotificationChannel channel, Supplier<INotificationSender> senderSupplier) {
        registry.put(channel, senderSupplier);
    }
}
