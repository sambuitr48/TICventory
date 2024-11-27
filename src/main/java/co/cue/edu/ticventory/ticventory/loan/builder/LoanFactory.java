package co.cue.edu.ticventory.ticventory.loan.builder;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import co.cue.edu.ticventory.ticventory.people.User;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.loan.Space;

import java.time.LocalDate;
import java.util.List;

public class LoanFactory {
    public static Loan createStandardLoan(User requester, List<Resource> resources, Space space, LocalDate startDate, LocalDate endDate) {
        return new LoanBuilder()
                .withRequester(requester)
                .withResources(resources)
                .withSpace(space)
                .withLoanDate(startDate)
                .withReturnDate(endDate)
                .build();
    }
}
