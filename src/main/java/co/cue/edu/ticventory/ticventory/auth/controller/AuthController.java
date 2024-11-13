package co.cue.edu.ticventory.ticventory.auth.controller;

import co.cue.edu.ticventory.ticventory.auth.dto.UserDTO;
import co.cue.edu.ticventory.ticventory.auth.mapper.UserMapper;
import co.cue.edu.ticventory.ticventory.auth.model.User;
import co.cue.edu.ticventory.ticventory.auth.service.AuthFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthFacade authFacade;

    @Autowired
    public AuthController(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        // Extraemos el password del DTO
        String password = userDTO.getPassword();
        User user = UserMapper.toEntity(userDTO); // Ahora pasamos ambos argumentos

        boolean success = authFacade.login(user.getUsername(), user.getPassword());
        return success ? "Login successful" : "Invalid credentials";
    }

    @PostMapping("/logout")
    public String logout() {
        authFacade.logout();
        return "Logout successful";
    }
}
