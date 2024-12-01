package co.cue.edu.ticventory.ticventory.people;

public class User {
    private String id;
    private String username;
    private String role; // Puede ser String, o usa un enum similar a `AuthRole`

    // Constructor vacío
    public User() {}

    // Constructor completo
    public User(String id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    // Getters y Setters
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
