package co.cue.edu.ticventory.ticventory;

import co.cue.edu.ticventory.ticventory.auth.dto.UserDTO;
import co.cue.edu.ticventory.ticventory.auth.model.User;
import co.cue.edu.ticventory.ticventory.auth.repository.UserRepository;
import co.cue.edu.ticventory.ticventory.auth.service.AuthFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

}
