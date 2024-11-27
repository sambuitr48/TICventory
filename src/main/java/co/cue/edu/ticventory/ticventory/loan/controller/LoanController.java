package co.cue.edu.ticventory.ticventory.loan.controller;

import co.cue.edu.ticventory.ticventory.loan.dto.LoanDTO;
import co.cue.edu.ticventory.ticventory.loan.facade.LoanFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanFacade loanFacade;

    public LoanController(LoanFacade loanFacade) {
        this.loanFacade = loanFacade;
    }

    @PostMapping
    public ResponseEntity<LoanDTO> createLoan(@RequestBody LoanDTO loanDTO) {
        LoanDTO createdLoan = loanFacade.createLoan(loanDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLoan);
    }

    @GetMapping
    public ResponseEntity<List<LoanDTO>> getAllLoans() {
        List<LoanDTO> loans = loanFacade.getAllLoans();
        return ResponseEntity.ok(loans);
    }
}
