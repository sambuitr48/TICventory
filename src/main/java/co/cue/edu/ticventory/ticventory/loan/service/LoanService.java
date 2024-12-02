package co.cue.edu.ticventory.ticventory.loan.service;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;

import java.util.List;

public interface LoanService {
    Loan createLoan(Loan loan);
    Loan getLoanById(int id);
    List<Loan> getAllLoans();
    Loan updateLoan(int id, Loan updatedLoan);
    void deleteLoan(int id);
}
