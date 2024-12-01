package co.cue.edu.ticventory.ticventory.loan.facade;

import co.cue.edu.ticventory.ticventory.auth.model.User;
import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.loan.dto.LoanDTO;
import co.cue.edu.ticventory.ticventory.loan.mapper.LoanMapper;
import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import co.cue.edu.ticventory.ticventory.loan.service.ExternalAPIClient;
import co.cue.edu.ticventory.ticventory.loan.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanFacade {

    private final LoanService loanService;
    private final ExternalAPIClient externalAPIClient;

    public LoanFacade(LoanService loanService, ExternalAPIClient externalAPIClient) {
        this.loanService = loanService;
        this.externalAPIClient = externalAPIClient;
    }

    public LoanDTO createLoan(LoanDTO loanDTO) {
        // Validar usuario
        co.cue.edu.ticventory.ticventory.auth.model.User authUser = externalAPIClient.getUserById(Long.parseLong(loanDTO.getRequester()));
        if (authUser == null) {
            throw new IllegalArgumentException("Usuario no válido.");
        }

        // Convertir `auth.User` a `people.User`
        co.cue.edu.ticventory.ticventory.people.User user = mapAuthUserToPeopleUser(authUser);

        // Validar y cargar recursos
        List<Resource> resources = loanDTO.getResources().stream()
                .map(resourceId -> {
                    Resource resource = externalAPIClient.getResourceById(resourceId);
                    if (!resource.getState().equals(ResourceStatus.AVAILABLE)) {
                        throw new IllegalArgumentException("Recurso no disponible: " + resourceId);
                    }
                    return resource;
                })
                .collect(Collectors.toList());

        // Crear entidad de préstamo
        Loan loan = LoanMapper.toEntity(loanDTO, user, resources);
        Loan savedLoan = loanService.createLoan(loan);

        // Mapear a DTO y retornar
        return LoanMapper.toDTO(savedLoan);
    }


    public List<LoanDTO> getAllLoans() {
        // Obtiene todos los préstamos y los convierte en DTOs
        return loanService.getAllLoans().stream()
                .map(LoanMapper::toDTO)
                .collect(Collectors.toList());
    }
    private co.cue.edu.ticventory.ticventory.people.User mapAuthUserToPeopleUser(co.cue.edu.ticventory.ticventory.auth.model.User authUser) {
        co.cue.edu.ticventory.ticventory.people.User user = new co.cue.edu.ticventory.ticventory.people.User();
        user.setId(authUser.getId());
        user.setUsername(authUser.getUsername());
        user.setRole(authUser.getRole().name()); // Convierte AuthRole a String usando name()
        return user;
    }


}
