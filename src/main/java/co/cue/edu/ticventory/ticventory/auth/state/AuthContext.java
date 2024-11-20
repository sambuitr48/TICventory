package co.cue.edu.ticventory.ticventory.auth.state;

import co.cue.edu.ticventory.ticventory.auth.domain.AuthStatus;
import co.cue.edu.ticventory.ticventory.auth.state.AuthState;

public class AuthContext {
    private AuthState state;

    public AuthContext(AuthState state) {
        this.state = state;
    }

    public void setState(AuthState state) {
        this.state = state;
    }

    public AuthState getState() {
        return state;
    }

    public AuthStatus getStatus() {
        return state.getStatus();
    }

    public void handle() {
        state.handle(this);
    }
}
