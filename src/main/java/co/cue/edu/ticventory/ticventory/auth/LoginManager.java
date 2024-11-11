package co.cue.edu.ticventory.ticventory.auth;

import java.util.HashMap;
import java.util.Map;
/**
 * La clase `LoginManager` es responsable de gestionar la autenticación de los usuarios.
 * Utiliza un `Map` para almacenar las credenciales de usuario, que sirve como una base de datos simplificada.
 *
 * Funcionalidad: `LoginManager` valida las credenciales del usuario y permite verificar si un ID y
 * contraseña proporcionados son correctos.
 */
public class LoginManager {
    private Map<String, String> userCredentials;

    public LoginManager() {
        userCredentials = new HashMap<>();
        userCredentials.put("admin_id", "admin_password"); // Ejemplo de credenciales
    }

    public boolean authenticate(String id, String password) {
        return userCredentials.containsKey(id) && userCredentials.get(id).equals(password);
    }
}
