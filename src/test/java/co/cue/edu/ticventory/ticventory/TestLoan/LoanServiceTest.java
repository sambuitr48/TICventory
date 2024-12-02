package co.cue.edu.ticventory.ticventory.TestLoan;
import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.inventory.model.ResourceType;
import co.cue.edu.ticventory.ticventory.inventory.model.Sede;
import co.cue.edu.ticventory.ticventory.loan.LoanStateEnum;
import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import co.cue.edu.ticventory.ticventory.loan.repository.LoanRepository;
import co.cue.edu.ticventory.ticventory.loan.service.LoanServiceImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class LoanServiceTest {
    private final LoanRepository loanRepository = mock(LoanRepository.class);
    private final LoanServiceImpl loanService = new LoanServiceImpl(loanRepository);

    @Test
    void createLoan_Success() {
        // Arrange: Preparar el recurso y el préstamo
        Resource resource = new Resource("RESOURCE001", "Laptop Dell", new ResourceType("Electrónico", "Descripción"),
                Sede.PRINCIPAL, "Dell", ResourceStatus.AVAILABLE); // Crear recurso disponible
        Loan loan = new Loan(); // Crear objeto de préstamo
        loan.setResources(List.of(resource)); // Asignar recurso al préstamo
        loan.setLoanDate(LocalDate.now()); // Fecha de inicio del préstamo
        loan.setReturnDate(LocalDate.now().plusDays(5)); // Fecha de devolución
        loan.setState(LoanStateEnum.PRESTADO); // Estado inicial del préstamo

        when(loanRepository.save(any(Loan.class))).thenReturn(loan); // Simular la operación de guardado en el repositorio

        // Act: Ejecutar el método bajo prueba
        Loan createdLoan = loanService.createLoan(loan);

        // Assert: Verificar que el préstamo fue creado correctamente
        assertNotNull(createdLoan); // El préstamo no debe ser nulo
        assertEquals(1, createdLoan.getResources().size()); // Debe tener un recurso asignado
        assertEquals("RESOURCE001", createdLoan.getResources().get(0).getCode()); // Verificar el código del recurso
        verify(loanRepository, times(1)).save(any(Loan.class)); // Verificar que el método save fue llamado exactamente una vez
    }



    @Test
    void createLoan_Failure_ResourceNotAvailable() {
        // Arrange: Crear un recurso que no está disponible
        Resource resource = new Resource("RESOURCE001", "Laptop Dell", new ResourceType("Electrónico", "Descripción"),
                Sede.PRINCIPAL, "Dell", ResourceStatus.UNAVAILABLE); // Estado RENTED significa no disponible
        Loan loan = new Loan(); // Crear préstamo
        loan.setResources(List.of(resource)); // Asignar recurso no disponible al préstamo

        // Act & Assert: Verificar que se lanza una excepción al intentar crear el préstamo
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(loan); // Ejecutar el método bajo prueba
        });
        assertEquals("El recurso no está disponible: RESOURCE001", exception.getMessage()); // Verificar el mensaje de error
    }


    @Test
    void getLoanById_Success() {
        // Arrange: Preparar los datos simulados
        Loan loan = new Loan();
        loan.setId(1L);
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(5));
        loan.setState(LoanStateEnum.PRESTADO);

        when(loanRepository.findById(1L)).thenReturn(loan);

        // Act: Llamar al servicio
        Loan foundLoan = loanService.getLoanById(1);

        // Assert: Verificar los resultados
        assertNotNull(foundLoan, "El préstamo no debería ser null");
        assertEquals(1L, foundLoan.getId(), "El ID del préstamo no coincide");
        assertEquals(LocalDate.now(), foundLoan.getLoanDate(), "La fecha de préstamo no coincide");
        assertEquals(LocalDate.now().plusDays(5), foundLoan.getReturnDate(), "La fecha de devolución no coincide");
        assertEquals(LoanStateEnum.PRESTADO, foundLoan.getState(), "El estado del préstamo no coincide");

        // Verificar interacción con el repositorio
        verify(loanRepository, times(1)).findById(1L);
        verifyNoMoreInteractions(loanRepository);
    }


    @Test
    void getLoanById_Failure() {
        // Arrange: Configurar el mock para devolver null
        when(loanRepository.findById(1L)).thenReturn(null);

        // Act & Assert: Verificar que lanza la excepción correcta
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> loanService.getLoanById(1));

        // Assert: Verificar el mensaje de la excepción
        assertEquals("Préstamo no encontrado.", exception.getMessage(),
                "El mensaje de excepción no coincide con lo esperado");

        // Verificar interacción con el repositorio
        verify(loanRepository, times(1)).findById(1L);
        verifyNoMoreInteractions(loanRepository);
    }

}
