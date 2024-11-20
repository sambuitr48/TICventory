package co.cue.edu.ticventory.ticventory.auth.strategy;

import co.cue.edu.ticventory.ticventory.auth.model.User;
import co.cue.edu.ticventory.ticventory.auth.repository.UserRepository;
import co.cue.edu.ticventory.ticventory.auth.domain.AuthStatus;
import java.util.Optional;

public interface AuthenticationStrategy {
    boolean authenticate(String identifier, String credential);
    AuthStatus getStatus();
}