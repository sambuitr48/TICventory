package co.cue.edu.ticventory.ticventory.auth.model;


import co.cue.edu.ticventory.ticventory.auth.domain.AuthRole;

public class User {
    private String id;
    private String username;
    private String password;
    private AuthRole role;

    public User(String id, String username, String password, AuthRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthRole getRole() {
        return role;
    }

    public void setRole(AuthRole role) {
        this.role = role;
    }
}
