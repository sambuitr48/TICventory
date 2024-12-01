package co.cue.edu.ticventory.ticventory.auth.controller;

import co.cue.edu.ticventory.ticventory.auth.dto.UserDTO;
import co.cue.edu.ticventory.ticventory.auth.service.AuthFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthFacade authFacade;
    private final Map<String, String> sessionTokens = new HashMap<>(); // Simula las sesiones de los usuarios

    @Autowired
    public AuthController(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        authFacade.register(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        boolean success = authFacade.login(userDTO.getUsername(), userDTO.getPassword());
        if (success) {
            String token = generateRandomToken();
            sessionTokens.put(userDTO.getUsername(), token);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        String username = getUsernameFromToken(token);
        if (username != null) {
            sessionTokens.remove(username);
            return ResponseEntity.ok("Logout successful");
        }
        return ResponseEntity.status(401).body("Invalid session");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> listUsers(@RequestHeader("Authorization") String token) {
        String username = getUsernameFromToken(token);
        if (username == null) {
            return ResponseEntity.status(401).body(null);
        }
        List<UserDTO> users = authFacade.listUsers();
        return ResponseEntity.ok(users);
    }

    // Métodos de soporte

    private String generateRandomToken() {
        int length = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder token = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            token.append(characters.charAt(random.nextInt(characters.length())));
        }

        return token.toString();
    }

    private String getUsernameFromToken(String token) {
        for (Map.Entry<String, String> entry : sessionTokens.entrySet()) {
            if (entry.getValue().equals(token.replace("Bearer ", ""))) {
                return entry.getKey();
            }
        }
        return null; // Token inválido
    }
}
