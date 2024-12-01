package co.cue.edu.ticventory.ticventory.loan.service;

import co.cue.edu.ticventory.ticventory.auth.model.User;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAPIClient {

    private final RestTemplate restTemplate;

    public ExternalAPIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserById(Long userId) {
        String url = "http://localhost:8080/api/auth/users/" + userId;
        try {
            ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
            if (response.getBody() == null) {
                throw new IllegalArgumentException("Usuario no encontrado: " + userId);
            }
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new IllegalArgumentException("Usuario no encontrado: " + userId);
        } catch (Exception e) {
            throw new RuntimeException("Error al comunicarse con el servicio de Auth", e);
        }
    }

    public Resource getResourceById(String resourceId) {
        String url = "http://localhost:8080/api/inventory/resources/" + resourceId;
        try {
            ResponseEntity<Resource> response = restTemplate.getForEntity(url, Resource.class);
            if (response.getBody() == null) {
                throw new IllegalArgumentException("Recurso no encontrado: " + resourceId);
            }
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new IllegalArgumentException("Recurso no encontrado: " + resourceId);
        } catch (Exception e) {
            throw new RuntimeException("Error al comunicarse con el servicio de Inventory", e);
        }
    }
}

