package co.cue.edu.ticventory.ticventory.auth.service;

import co.cue.edu.ticventory.ticventory.auth.model.Session;
import co.cue.edu.ticventory.ticventory.auth.model.User;
import co.cue.edu.ticventory.ticventory.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private static AuthService instance;

    @Autowired
    private UserRepository userRepository;

    // Constructor privado para evitar instancias directas
    public AuthService() {}

    // Método estático para obtener la instancia única de AuthService
    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public boolean login(String username, String password) {
        // Lógica de autenticación
        return true;
    }

    public void logout() {
        Session.getInstance().clearSession();
    }

    public static void setInstance(AuthService instance) {
        AuthService.instance = instance;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
