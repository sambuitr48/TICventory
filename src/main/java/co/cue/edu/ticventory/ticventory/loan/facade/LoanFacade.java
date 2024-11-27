package co.cue.edu.ticventory.ticventory.loan.facade;

import co.cue.edu.ticventory.ticventory.loan.dto.LoanDTO;
import co.cue.edu.ticventory.ticventory.loan.mapper.LoanMapper;
import co.cue.edu.ticventory.ticventory.loan.service.LoanService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanFacade {
    private final LoanService loanService;

    public LoanFacade(LoanService loanService) {
        this.loanService = loanService;
    }

    public LoanDTO createLoan(LoanDTO loanDTO) {
        return LoanMapper.toDTO(loanService.createLoan(LoanMapper.toEntity(loanDTO)));
    }

    public List<LoanDTO> getAllLoans() {
        return loanService.getAllLoans().stream()
                .map(LoanMapper::toDTO)
                .collect(Collectors.toList());
    }
}
