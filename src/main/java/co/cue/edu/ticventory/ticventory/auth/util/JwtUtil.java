package co.cue.edu.ticventory.ticventory.auth.util;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        String randomKey = generateRandomKey();
        long timestamp = new Date().getTime();
        return "KEY-" + randomKey + "-" + timestamp;
    }

    private String generateRandomKey() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder key = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            key.append(characters.charAt(random.nextInt(characters.length())));
        }

        return key.toString();
    }
}
