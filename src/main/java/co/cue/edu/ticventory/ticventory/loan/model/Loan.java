package co.cue.edu.ticventory.ticventory.loan.model;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.loan.LoanStateEnum;
import co.cue.edu.ticventory.ticventory.people.User;
import co.cue.edu.ticventory.ticventory.loan.Space;

import java.time.LocalDate;
import java.util.List;

public class Loan {
    private Long id;
    private User requester;
    private List<Resource> resources;
    private Space space;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private LoanStateEnum state;

    // Constructor, Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStateEnum getState() {
        return state;
    }

    public void setState(LoanStateEnum state) {
        this.state = state;
    }
}
