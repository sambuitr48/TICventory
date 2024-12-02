package co.cue.edu.ticventory.ticventory.TestLoan;
import co.cue.edu.ticventory.ticventory.loan.controller.LoanController;
import co.cue.edu.ticventory.ticventory.loan.dto.LoanDTO;
import co.cue.edu.ticventory.ticventory.loan.facade.LoanFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;
@SpringBootTest
@AutoConfigureMockMvc
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LoanFacade loanFacade; // Usar MockBean para los mocks

    @Test
    void createLoan_Success() throws Exception {
        // Arrange: Crear un préstamo válido
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setRequester("1");
        loanDTO.setResources(List.of("RESOURCE001"));
        loanDTO.setLoanDate(LocalDate.now());
        loanDTO.setReturnDate(LocalDate.now().plusDays(5));
        loanDTO.setState("PRESTADO");

        when(loanFacade.createLoan(any(LoanDTO.class))).thenReturn(loanDTO);

        // Act & Assert: Realizar la solicitud y verificar resultados
        mockMvc.perform(post("/api/loans/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loanDTO)))
                .andExpect(status().isCreated()) // Verificar estado HTTP 201
                .andExpect(jsonPath("$.requester").value("1")) // Validar el solicitante
                .andExpect(jsonPath("$.resources[0]").value("RESOURCE001")) // Validar recurso
                .andExpect(jsonPath("$.state").value("PRESTADO")); // Validar estado

        verify(loanFacade, times(1)).createLoan(any(LoanDTO.class)); // Verificar interacción con el facade
    }

    @Test
    void createLoan_Failure() {
        // Arrange: Configurar excepción
        LoanDTO loanDTO = new LoanDTO();
        when(loanFacade.createLoan(any(LoanDTO.class))).thenThrow(new IllegalArgumentException("Error al crear préstamo"));

        // Act: Llamar al controlador directamente
        ResponseEntity<?> response = new LoanController(loanFacade).createLoan(loanDTO);

        // Assert: Verificar respuesta
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(((Map<?, ?>) response.getBody()).containsKey("error"));
    }

    @Test
    void getAllLoans_Success() throws Exception {
        // Arrange: Crear datos de prueba
        LoanDTO loan1 = new LoanDTO();
        loan1.setRequester("1");
        loan1.setResources(List.of("RESOURCE001"));
        loan1.setLoanDate(LocalDate.now());
        loan1.setReturnDate(LocalDate.now().plusDays(5));
        loan1.setState("PRESTADO");

        LoanDTO loan2 = new LoanDTO();
        loan2.setRequester("2");
        loan2.setResources(List.of("RESOURCE002"));
        loan2.setLoanDate(LocalDate.now());
        loan2.setReturnDate(LocalDate.now().plusDays(7));
        loan2.setState("DEVUELTO");

        when(loanFacade.getAllLoans()).thenReturn(List.of(loan1, loan2));

        // Act & Assert: Realizar la solicitud y verificar resultados
        mockMvc.perform(get("/api/loans")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Verificar estado HTTP 200
                .andExpect(jsonPath("$[0].requester").value("1"))
                .andExpect(jsonPath("$[1].requester").value("2"))
                .andExpect(jsonPath("$[0].state").value("PRESTADO"))
                .andExpect(jsonPath("$[1].state").value("DEVUELTO"));

        verify(loanFacade, times(1)).getAllLoans(); // Verificar interacción con el facade
    }
    @Test
    void createLoan_Failure_UserNotFound() throws Exception {
        // Arrange: Preparar LoanDTO con un usuario inexistente
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setRequester("99"); // Usuario inexistente
        loanDTO.setResources(List.of("RESOURCE001")); // ID del recurso
        loanDTO.setLoanDate(LocalDate.now()); // Fecha de préstamo
        loanDTO.setReturnDate(LocalDate.now().plusDays(5)); // Fecha de devolución

        when(loanFacade.createLoan(any(LoanDTO.class)))
                .thenThrow(new IllegalArgumentException("Usuario no válido.")); // Simular error en LoanFacade

        // Act & Assert: Realizar la solicitud POST y verificar la respuesta de error
        mockMvc.perform(post("/api/loans/add")
                        .contentType(MediaType.APPLICATION_JSON) // Tipo de contenido JSON
                        .content(objectMapper.writeValueAsString(loanDTO))) // Convertir LoanDTO a JSON
                .andExpect(status().isBadRequest()) // Verificar que el estado HTTP sea 400 (BAD REQUEST)
                .andExpect(jsonPath("$.error").value("Usuario no válido.")); // Verificar el mensaje de error

        verify(loanFacade, times(1)).createLoan(any(LoanDTO.class)); // Verificar que LoanFacade fue llamado una vez
    }

}
