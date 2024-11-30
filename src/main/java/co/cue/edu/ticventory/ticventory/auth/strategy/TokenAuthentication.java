package co.cue.edu.ticventory.ticventory.auth.strategy;


import co.cue.edu.ticventory.ticventory.auth.domain.AuthStatus;

public class TokenAuthentication implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String token, String unused) {
        return isValidToken(token);
    }

    private boolean isValidToken(String token) {
        return true;
    }

    @Override
    public AuthStatus getStatus() {
        return AuthStatus.ACTIVE;
    }
}
