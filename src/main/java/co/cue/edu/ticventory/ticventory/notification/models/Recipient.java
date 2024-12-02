package co.cue.edu.ticventory.ticventory.notification.models;

/**
 * **Clase Recipient**
 *
 * - Representa al destinatario de una notificación, con atributos esenciales como nombre, identificación,
 *   correo electrónico y número de teléfono.
 * - Es utilizada en el sistema para identificar a quién se enviará una notificación.
 *
 * **Patrón aplicado: POJO (Plain Old Java Object)**
 * - La clase sigue el patrón POJO, ya que se utiliza principalmente como un contenedor de datos
 *   con atributos, un constructor, getters y setters, y el método `toString`.
 *
 * **Uso en el sistema:**
 * - Es una parte clave del modelo de dominio, utilizada en clases como `Notification` y `NotificationRequest`
 *   para definir al destinatario de una notificación.
 */
public class Recipient {

    // **Atributos**
    // Representan la información básica del destinatario de la notificación.
    private String name;          // Nombre del destinatario.
    private String documentId;    // Identificación del destinatario.
    private String email;         // Correo electrónico del destinatario.
    private String phone;         // Número de teléfono del destinatario.

    /**
     * **Constructor**
     *
     * - Inicializa todos los atributos necesarios para crear un destinatario.
     * - Cumple con el principio de responsabilidad única (SRP) de SOLID, ya que la clase tiene
     *   la única responsabilidad de manejar los datos del destinatario.
     */
    public Recipient(String name, String documentId, String email, String phone) {
        this.name = name;
        this.documentId = documentId;
        this.email = email;
        this.phone = phone;
    }

    // **Getters y Setters**
    // Proveen acceso y modificación controlada a los atributos de la clase.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * **Método toString**
     *
     * - Proporciona una representación textual de un objeto `Recipient`,
     *   útil para depuración o registros.
     */
    @Override
    public String toString() {
        return "Recipient{" +
                "name='" + name + '\'' +
                ", documentId='" + documentId + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
