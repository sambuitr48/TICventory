package co.cue.edu.ticventory.ticventory.notification.service;

import co.cue.edu.ticventory.ticventory.notification.models.NotificationChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa el patrón Observer para notificaciones.
 * Permite registrar, desregistrar y notificar a los observadores.
 *
 * En este caso, los observadores son los diferentes canales de notificación
 * (como SMS, correo electrónico, etc.), que recibirán las notificaciones
 * cuando se envíen.
 */
public class NotificationObserver {

    private List<NotificationChannel> channels = new ArrayList<>();

    /**
     * Añade un canal de notificación al observador.
     * Este método se usa para registrar un canal que desea recibir notificaciones.
     *
     * @param channel El canal de notificación a añadir.
     */
    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    /**
     * Envía la notificación a todos los canales registrados.
     * Este método notifica a todos los canales registrados sobre el mensaje enviado.
     *
     * @param message El mensaje de la notificación.
     */
    public void notifyObservers(String message) {
        for (NotificationChannel channel : channels) {
            System.out.println("Enviando mensaje a través de: " + channel);
            // Aquí podrías agregar lógica real de envío
        }
        clearChannels(); // Limpia los canales después de enviar la notificación
    }

//    este metodo sirve para que las notificaciones anteriores no queden guardadas
//        al momento de mandar otras notificaciones
    public void clearChannels() {
        channels.clear();
    }
}
