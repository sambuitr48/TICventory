package co.cue.edu.ticventory.ticventory.loan.repository;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LoanRepository {

    private final Map<Long, Loan> loanStorage = new HashMap<>();
    private long currentId = 1;

    public Loan save(Loan loan) {
        if (loan.getId() == null) {
            loan.setId(currentId++);
        }
        loanStorage.put(loan.getId(), loan);
        return loan;
    }

    public Loan findById(Long id) {
        return loanStorage.get(id);
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loanStorage.values());
    }

    public void delete(Long id) {
        loanStorage.remove(id);
    }
}
