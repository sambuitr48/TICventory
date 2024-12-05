package co.cue.edu.ticventory.ticventory;

import co.cue.edu.ticventory.ticventory.auth.dto.UserDTO;
import co.cue.edu.ticventory.ticventory.auth.model.User;
import co.cue.edu.ticventory.ticventory.auth.repository.UserRepository;
import co.cue.edu.ticventory.ticventory.auth.service.AuthFacade;
import co.cue.edu.ticventory.ticventory.auth.domain.AuthRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthFacade authFacade;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testRegister() throws Exception {
        UserDTO userDTO = new UserDTO("1", "testUser", "USER", "password123");
        Mockito.doNothing().when(authFacade).register(Mockito.any(UserDTO.class));

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"));

        Mockito.verify(authFacade, Mockito.times(1)).register(Mockito.any(UserDTO.class));
    }

    @Test
    public void testLoginSuccess() throws Exception {
        Mockito.when(authFacade.login("testUser", "password123")).thenReturn(true);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"testUser\",\"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.matchesRegex("[A-Za-z0-9]{10}")));
    }

    @Test
    public void testLoginFailure() throws Exception {
        Mockito.when(authFacade.login("testUser", "wrongPassword")).thenReturn(false);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"testUser\",\"password\":\"wrongPassword\"}"))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Invalid credentials"));
    }

    @Test
    public void testLoginLogic() {
        User mockUser = new User("1", "testUser", "password123", AuthRole.USER);
        Mockito.when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(mockUser));

        boolean result = authFacade.login("testUser", "password123");
        Assertions.assertTrue(result);

        Mockito.when(userRepository.findByUsername("wrongUser")).thenReturn(Optional.empty());
        result = authFacade.login("wrongUser", "password123");
        Assertions.assertFalse(result);
    }

    @Test
    public void testFullRegistrationAndLoginFlow() throws Exception {
        // Mock repository save
        UserDTO userDTO = new UserDTO("1", "integrationUser", "USER", "password123");
        Mockito.doNothing().when(authFacade).register(Mockito.any(UserDTO.class));
        Mockito.when(authFacade.login("integrationUser", "password123")).thenReturn(true);

        // Registro
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDTO)))
                .andExpect(status().isOk());

        // Inicio de sesión
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"integrationUser\",\"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.matchesRegex("[A-Za-z0-9]{10}")));

        // Verificación de usuario guardado en el repositorio
        Mockito.when(userRepository.findByUsername("integrationUser")).thenReturn(Optional.of(new User("1", "integrationUser", "password123", AuthRole.USER)));
        Assertions.assertTrue(userRepository.findByUsername("integrationUser").isPresent());
    }
}
