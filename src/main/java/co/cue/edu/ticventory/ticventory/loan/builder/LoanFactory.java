package co.cue.edu.ticventory.ticventory.loan.builder;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import co.cue.edu.ticventory.ticventory.people.User;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;

import java.time.LocalDate;
import java.util.List;

public class LoanFactory {
    public static Loan createLoan(User requester, List<Resource> resources, LocalDate startDate, LocalDate endDate) {
        Loan loan = new Loan();
        loan.setRequester(requester);
        loan.setResources(resources);
        loan.setLoanDate(startDate);
        loan.setReturnDate(endDate);
        return loan;
    }
}
