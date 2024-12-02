package co.cue.edu.ticventory.ticventory.loan.mapper;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import co.cue.edu.ticventory.ticventory.loan.dto.LoanDTO;
import co.cue.edu.ticventory.ticventory.loan.LoanStateEnum;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.people.User;

import java.util.List;
import java.util.stream.Collectors;

public class LoanMapper {

    public static LoanDTO toDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setRequester(String.valueOf(loan.getRequester().getId()));
        dto.setResources(loan.getResources().stream()
                .map(Resource::getCode)
                .collect(Collectors.toList()));
        dto.setLoanDate(loan.getLoanDate());
        dto.setReturnDate(loan.getReturnDate());
        dto.setState(loan.getState().name());
        return dto;
    }

    public static Loan toEntity(LoanDTO dto, User requester, List<Resource> resources) {
        Loan loan = new Loan();
        loan.setId(dto.getId());
        loan.setRequester(requester);
        loan.setResources(resources);
        loan.setLoanDate(dto.getLoanDate());
        loan.setReturnDate(dto.getReturnDate());
        loan.setState(LoanStateEnum.valueOf(dto.getState()));
        return loan;
    }
}

