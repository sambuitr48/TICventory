package co.cue.edu.ticventory.ticventory.loan.model;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.loan.LoanStateEnum;
import co.cue.edu.ticventory.ticventory.loan.state.LoanState;
import co.cue.edu.ticventory.ticventory.people.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


public class Loan {


    private Long id;


    private User requester;


    private List<Resource> resources;


    private LocalDate loanDate;

    private LocalDate returnDate;


    private LoanStateEnum state;


    private LoanState loanState;

    // Constructor vacío requerido por JPA
    public Loan() {
    }

    // Constructor para crear una copia del préstamo (para Memento)
    public Loan(Loan loan) {
        this.id = loan.id;
        this.requester = loan.requester;
        this.resources = loan.resources;
        this.loanDate = loan.loanDate;
        this.returnDate = loan.returnDate;
        this.state = loan.state;
    }

    // Memento: Crear un historial del préstamo
    public LoanHistory saveToHistory() {
        return new LoanHistory(new Loan(this));
    }

    // Memento: Restaurar el estado del préstamo desde el historial
    public void restoreFromHistory(LoanHistory history) {
        Loan snapshot = history.getLoanSnapshot();
        this.id = snapshot.id;
        this.requester = snapshot.requester;
        this.resources = snapshot.resources;
        this.loanDate = snapshot.loanDate;
        this.returnDate = snapshot.returnDate;
        this.state = snapshot.state;
    }

    // Método para procesar el estado actual (Patrón State)
    public void processState() {
        if (loanState != null) {
            loanState.handle(this);
        } else {
            throw new IllegalStateException("LoanState is not initialized.");
        }
    }

    // Getters y Setters
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

    public LoanState getLoanState() {
        return loanState;
    }

    public void setLoanState(LoanState loanState) {
        this.loanState = loanState;
    }
}
