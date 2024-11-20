package co.cue.edu.ticventory.ticventory.auth.service;

import co.cue.edu.ticventory.ticventory.auth.model.User;

public class AuthProxy {
    private final AuthService authService;

    public AuthProxy(AuthService authService) {
        this.authService = authService;
    }

    public boolean authenticate(String username, String password) {
        return authService.login(username, password);
    }
}
