package co.cue.edu.ticventory.ticventory.auth.state;

import co.cue.edu.ticventory.ticventory.auth.domain.AuthStatus;

public class AuthenticatedState implements AuthState {
    @Override
    public void handle(AuthContext context) {
        System.out.println("El usuario está autenticado.");
    }

    @Override
    public AuthStatus getStatus() {
        return AuthStatus.ACTIVE;
    }
}