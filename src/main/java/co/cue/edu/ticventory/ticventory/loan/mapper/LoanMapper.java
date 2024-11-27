package co.cue.edu.ticventory.ticventory.loan.mapper;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import co.cue.edu.ticventory.ticventory.loan.dto.LoanDTO;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;

import java.util.stream.Collectors;

public class LoanMapper {
    public static LoanDTO toDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setSolicitante(loan.getRequester().getNombre());
        dto.setRecursos(loan.getResources().stream()
                .map(Resource::getCode)
                .collect(Collectors.toList()));
        dto.setFechaPrestamo(loan.getLoanDate());
        dto.setFechaDevolucion(loan.getReturnDate());
        dto.setEstado(loan.getState().name());
        return dto;
    }

    public static Loan toEntity(LoanDTO dto) {
        Loan loan = new Loan();
        loan.setId(dto.getId());
        // Completa el mapeo de los demás atributos aquí
        return loan;
    }
}
