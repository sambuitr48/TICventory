package co.cue.edu.ticventory.ticventory.auth.strategy;

import co.cue.edu.ticventory.ticventory.auth.domain.AuthStatus;
import co.cue.edu.ticventory.ticventory.auth.strategy.AuthenticationStrategy;

public class TokenAuthentication implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String token, String unused) {
        // Aquí podrías verificar la validez del token
        return isValidToken(token);
    }

    private boolean isValidToken(String token) {
        // Implementar la lógica de validación del token
        return true; // Simulación
    }

    @Override
    public AuthStatus getStatus() {
        return AuthStatus.ACTIVE;
    }
}