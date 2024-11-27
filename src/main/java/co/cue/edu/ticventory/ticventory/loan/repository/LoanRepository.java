package co.cue.edu.ticventory.ticventory.loan.repository;

import co.cue.edu.ticventory.ticventory.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}

