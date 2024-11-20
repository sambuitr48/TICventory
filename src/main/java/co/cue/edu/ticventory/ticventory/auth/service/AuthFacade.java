package co.cue.edu.ticventory.ticventory.auth.service;

import co.cue.edu.ticventory.ticventory.auth.strategy.AuthenticationStrategy;
import java.time.LocalDateTime;

public class AuthFacade {
    private AuthenticationStrategy authenticationStrategy;
    private final AuthProxy authProxy;

    public AuthFacade(AuthProxy authProxy) {
        this.authProxy = authProxy;
    }

    public void setAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.authenticationStrategy = authenticationStrategy;
    }

    public boolean login(String identifier, String credential) {
        if (authenticationStrategy == null) {
            throw new IllegalStateException("Estrategia de autenticación no definida");
        }
        System.out.println("[INFO] Inicio de sesión - Fecha y hora: " + LocalDateTime.now());
        return authenticationStrategy.authenticate(identifier, credential);
    }

    public void logout() {
        System.out.println("[INFO] Cierre de sesión - Fecha y hora: " + LocalDateTime.now());
        System.out.println("Sesión cerrada correctamente.");
    }
}