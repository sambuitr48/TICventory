package co.cue.edu.ticventory.ticventory.loan;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import co.cue.edu.ticventory.ticventory.people.Person;

import java.util.Date;
/**
 * El patrón de diseño "Builder" permite construir objetos complejos paso a paso.
 * En este caso, se utiliza para construir un objeto de préstamo de manera flexible.
 */
public class LoanBuilder {
    private Loan loan;

    public LoanBuilder() {
        loan = new Loan(0, null, null, null, null, null, LoanState.PRESTADO);  // Estado inicial: Prestado
    }

    public LoanBuilder withId(int id) {
        loan.setId(id);
        return this;
    }

    public LoanBuilder withUser(Person person) {
        loan.setUser(person);
        return this;
    }

    public LoanBuilder withResource(Resource resource) {
        loan.setResource(resource);
        return this;
    }

    public LoanBuilder withSpace(Space space) {
        loan.setSpace(space);
        return this;
    }

    public LoanBuilder withDates(Date startDate, Date endDate) {
        loan.setStartDate(startDate);
        loan.setEndDate(endDate);
        return this;
    }

    public LoanBuilder withState(LoanState state) {
        loan.setState(state);
        return this;
    }

    public Loan build() {
        return loan;
    }
}
