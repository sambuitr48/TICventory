package co.cue.edu.ticventory.ticventory.notification.services;

import java.util.ArrayList;
import java.util.List;

/**
 * **Clase NotificationObserver**
 *
 * - Implementa un mecanismo para observar eventos relacionados con las notificaciones.
 * - Permite registrar observadores (listeners) y notificarles cuando ocurre un evento.
 *
 * **Patrón aplicado: Observer**
 * - Este patrón permite que los objetos (observadores) sean notificados automáticamente
 *   cuando ocurre un cambio en el estado del objeto observado (en este caso, el sistema de notificaciones).
 *
 * **Uso en el sistema:**
 * - Los observadores registrados en esta clase podrían ser canales específicos (EMAIL, SMS, PUSH)
 *   o cualquier otra lógica que deba ejecutarse en respuesta a un evento de notificación.
 */
public class NotificationObserver {

    // **Lista de observadores**
    // Almacena los observadores registrados que serán notificados cuando ocurra un evento.
    private final List<Runnable> observers = new ArrayList<>();

    /**
     * **Método addObserver**
     *
     * - Permite registrar un nuevo observador (listener).
     * - Cada observador debe ser una instancia de `Runnable`, lo que asegura que puede ejecutarse como una tarea.
     *
     * @param observer El observador que se registrará.
     */
    public void addObserver(Runnable observer) {
        observers.add(observer); // Agrega el observador a la lista.
    }

    /**
     * **Método notifyObservers**
     *
     * - Notifica a todos los observadores registrados, ejecutando su lógica.
     * - Recorre la lista de observadores y llama al método `run` de cada uno.
     */
    public void notifyObservers() {
        for (Runnable observer : observers) {
            observer.run(); // Ejecuta la lógica del observador.
        }
    }
}
