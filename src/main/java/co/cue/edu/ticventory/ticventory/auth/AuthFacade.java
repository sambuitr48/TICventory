package co.cue.edu.ticventory.ticventory.auth;

import co.cue.edu.ticventory.ticventory.people.Person;
/**
 * La clase `AuthFacade` implementa el patrón Facade, que simplifica el uso de un subsistema complejo
 * en este caso el sistema de autenticación, proporcionando una interfaz unificada y fácil de usar.
 *
 * Funcionalidad: `AuthFacade` integra `LoginManager` y `SessionManager` para gestionar el login,
 * el cierre de sesión y la verificación de autenticación del usuario en el sistema.
 */
public class AuthFacade {
    private LoginManager loginManager;
    private SessionManager sessionManager;

    public AuthFacade() {
        loginManager = new LoginManager();
        sessionManager = new SessionManager();
    }

    public boolean login(String id, String password, Person person) {
        if (loginManager.authenticate(id, password)) {
            sessionManager.createSession(person);
            return true;
        }
        return false;
    }

    public void logout() {
        sessionManager.destroySession();
    }

    public boolean isUserLoggedIn() {
        return sessionManager.isUserLoggedIn();
    }

    public Person getCurrentUser() {
        return sessionManager.getCurrentUser();
    }
}

