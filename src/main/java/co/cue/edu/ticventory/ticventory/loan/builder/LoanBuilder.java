package co.cue.edu.ticventory.ticventory.loan.builder;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import co.cue.edu.ticventory.ticventory.people.User;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.loan.Space;

import java.time.LocalDate;
import java.util.List;

public class LoanBuilder {
    private Loan loan;

    public LoanBuilder() {
        this.loan = new Loan();
    }

    public LoanBuilder withRequester(User requester) {
        loan.setRequester(requester);
        return this;
    }

    public LoanBuilder withResources(List<Resource> resources) {
        loan.setResources(resources);
        return this;
    }

    public LoanBuilder withSpace(Space space) {
        loan.setSpace(space);
        return this;
    }

    public LoanBuilder withLoanDate(LocalDate loanDate) {
        loan.setLoanDate(loanDate);
        return this;
    }

    public LoanBuilder withReturnDate(LocalDate returnDate) {
        loan.setReturnDate(returnDate);
        return this;
    }

    public Loan build() {
        return loan;
    }
}
