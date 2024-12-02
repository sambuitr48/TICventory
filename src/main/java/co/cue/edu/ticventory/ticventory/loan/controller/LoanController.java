package co.cue.edu.ticventory.ticventory.loan.controller;

import co.cue.edu.ticventory.ticventory.loan.dto.LoanDTO;
import co.cue.edu.ticventory.ticventory.loan.facade.LoanFacade;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanFacade loanFacade;

    public LoanController(LoanFacade loanFacade) {
        this.loanFacade = loanFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createLoan(@Valid @RequestBody LoanDTO loanDTO) {
        try {
            LoanDTO createdLoan = loanFacade.createLoan(loanDTO);
            return ResponseEntity.status(201).body(createdLoan);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(Map.of("error", "Error interno del servidor: " + ex.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<LoanDTO>> getAllLoans() {
        try {
            List<LoanDTO> loans = loanFacade.getAllLoans();
            return ResponseEntity.ok(loans);
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
