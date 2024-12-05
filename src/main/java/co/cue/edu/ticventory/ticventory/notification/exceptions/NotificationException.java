package co.cue.edu.ticventory.ticventory.notification.exceptions;

public class NotificationException extends Exception {

    /**
     * **Constructor: NotificationException(String message)**
     * Este constructor permite crear una excepción con un mensaje personalizado.
     *
     * **Patrón aplicado:**
     * - **Custom Exception**: Esta clase representa una excepción personalizada para el sistema de notificaciones. Al ser una excepción propia, permite manejar errores de una forma más específica y controlada dentro del contexto de la aplicación.
     *
     * **Principios SOLID:**
     * - **Single Responsibility Principle (SRP)**: Esta clase tiene una única responsabilidad: encapsular los errores relacionados con el sistema de notificaciones.
     * - **Open/Closed Principle (OCP)**: La clase puede ser extendida si se desea agregar más funcionalidades (por ejemplo, nuevos constructores o comportamientos específicos de errores), sin necesidad de modificar la clase original.
     */
    public NotificationException(String message) {
        super(message);  // Llama al constructor de la clase padre (Exception) para establecer el mensaje
    }

    /**
     * **Constructor: NotificationException(String message, Throwable cause)**
     * Este constructor permite crear una excepción con un mensaje personalizado y una causa original (otra excepción que haya causado esta).
     *
     * **Patrón aplicado:**
     * - **Custom Exception**: Al igual que el constructor anterior, esta es una excepción personalizada, pero esta vez permite encadenar excepciones, lo que es útil cuando se quiere propagar una excepción original mientras se maneja en un nivel superior.
     *
     * **Principios SOLID:**
     * - **Single Responsibility Principle (SRP)**: Esta clase sigue siendo responsable únicamente de manejar las excepciones específicas del sistema de notificaciones.
     * - **Open/Closed Principle (OCP)**: Similar al constructor anterior, este diseño permite extender la clase sin modificarla, por ejemplo, si se requieren otros detalles en el manejo de excepciones.
     */
    public NotificationException(String message, Throwable cause) {
        super(message, cause);  // Llama al constructor de la clase Exception para establecer tanto el mensaje como la causa
    }
}
