package co.cue.edu.ticventory.ticventory.auth.state;

import co.cue.edu.ticventory.ticventory.auth.domain.AuthStatus;

public class UnauthenticatedState implements AuthState {
    @Override
    public void handle(AuthContext context) {
        System.out.println("El usuario no está autenticado.");
    }

    @Override
    public AuthStatus getStatus() {
        return AuthStatus.INACTIVE;
    }
}