package co.cue.edu.ticventory.ticventory.auth.state;

import co.cue.edu.ticventory.ticventory.auth.domain.AuthStatus;

public interface AuthState {
    void handle(AuthContext context);
    AuthStatus getStatus();
}
