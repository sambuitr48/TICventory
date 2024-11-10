package co.cue.edu.ticventory.ticventory.auth;

import java.util.HashMap;
import java.util.Map;

public class LoginManager {
    private Map<String, String> userCredentials;

    public LoginManager() {
        userCredentials = new HashMap<>();
        userCredentials.put("admin_id", "admin_password");  // Ejemplo de credenciales
    }

    public boolean authenticate(String id, String password) {
        return userCredentials.containsKey(id) && userCredentials.get(id).equals(password);
    }
}
