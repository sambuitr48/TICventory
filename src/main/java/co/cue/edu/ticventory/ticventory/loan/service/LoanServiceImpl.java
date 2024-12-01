package co.cue.edu.ticventory.ticventory.loan.service;

import co.cue.edu.ticventory.ticventory.inventory.domain.ResourceStatus;
import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
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
        // Verificar disponibilidad de recursos
        for (Resource resource : loan.getResources()) {
            if (!resource.getState().equals(ResourceStatus.AVAILABLE)) {
                throw new IllegalArgumentException("El recurso no está disponible: " + resource.getCode());
            }
        }

        // Cambiar estado de recursos
        loan.getResources().forEach(resource -> resource.setState(ResourceStatus.RESERVED));

        // Guardar préstamo
        return loanRepository.save(loan);
    }


    @Override
    public Loan getLoanById(int id) {
        Loan loan = loanRepository.findById((long) id);
        if (loan == null) {
            throw new IllegalArgumentException("Préstamo no encontrado.");
        }
        return loan;
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
        loanRepository.delete((long) id);
    }
}
