package co.cue.edu.ticventory.ticventory.auth.strategy;

import co.cue.edu.ticventory.ticventory.auth.domain.AuthStatus;
import co.cue.edu.ticventory.ticventory.auth.model.User;
import co.cue.edu.ticventory.ticventory.auth.repository.UserRepository;
import co.cue.edu.ticventory.ticventory.auth.strategy.AuthenticationStrategy;

import java.util.Optional;

public class PasswordAuthentication implements AuthenticationStrategy {
    private final UserRepository userRepository;

    public PasswordAuthentication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    @Override
    public AuthStatus getStatus() {
        return AuthStatus.ACTIVE;
    }
}