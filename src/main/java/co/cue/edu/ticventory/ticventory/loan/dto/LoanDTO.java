package co.cue.edu.ticventory.ticventory.loan.dto;

import java.time.LocalDate;
import java.util.List;

public class LoanDTO {
    private Long id;
    private String requester; // ID del solicitante (usuario)
    private List<String> resources; // Lista de IDs de recursos
    private LocalDate loanDate;
    private LocalDate returnDate;
    private String state; // Estado del préstamo

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRequester() { return requester; }
    public void setRequester(String requester) { this.requester = requester; }

    public List<String> getResources() { return resources; }
    public void setResources(List<String> resources) { this.resources = resources; }

    public LocalDate getLoanDate() { return loanDate; }
    public void setLoanDate(LocalDate loanDate) { this.loanDate = loanDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}
