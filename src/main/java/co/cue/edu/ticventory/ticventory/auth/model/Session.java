package co.cue.edu.ticventory.ticventory.auth.model;

public class Session {
    private static Session instance;
    private String userId;

    private Session() {}

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void clearSession() {
        userId = null;
    }
}
