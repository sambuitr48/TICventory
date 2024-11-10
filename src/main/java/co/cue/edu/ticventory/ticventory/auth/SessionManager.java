package co.cue.edu.ticventory.ticventory.auth;

import co.cue.edu.ticventory.ticventory.people.Person;

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
