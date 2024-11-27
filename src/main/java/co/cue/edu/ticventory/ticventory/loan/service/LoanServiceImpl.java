package co.cue.edu.ticventory.ticventory.loan.service;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import co.cue.edu.ticventory.ticventory.loan.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(int id) {
        Optional<Loan> loan = loanRepository.findById(id);
        if (loan.isEmpty()) {
            throw new IllegalArgumentException("Loan not found.");
        }
        return loan.get();
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan updateLoan(int id, Loan updatedLoan) {
        Loan existingLoan = getLoanById(id);
        existingLoan.setResources(updatedLoan.getResources());
        existingLoan.setReturnDate(updatedLoan.getReturnDate());
        existingLoan.setState(updatedLoan.getState());
        return loanRepository.save(existingLoan);
    }

    @Override
    public void deleteLoan(int id) {
        loanRepository.deleteById(id);
    }
}
