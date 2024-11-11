package co.cue.edu.ticventory.ticventory.auth;

import co.cue.edu.ticventory.ticventory.people.Person;
/**
 * La clase `SessionManager` se encarga de gestionar las sesiones de usuario dentro del sistema.
 * Permite crear, destruir y consultar la sesión activa de un usuario.
 *
 * Funcionalidad: `SessionManager` proporciona métodos para verificar si un usuario está autenticado,
 * iniciar una sesión y finalizarla.
 */
public class SessionManager {
    private Person currentPerson;

    public void createSession(Person person) {
        this.currentPerson = person;
    }

    public void destroySession() {
        this.currentPerson = null;
    }

    public Person getCurrentUser() {
        return currentPerson;
    }

    public boolean isUserLoggedIn() {
        return currentPerson != null;
    }
}
