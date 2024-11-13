package co.cue.edu.ticventory.ticventory.auth.repository;

import co.cue.edu.ticventory.ticventory.auth.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(String id);
    Optional<User> findByUsername(String username);
    void save(User user);
    void delete(String id);

    List<User> findAll();
}
