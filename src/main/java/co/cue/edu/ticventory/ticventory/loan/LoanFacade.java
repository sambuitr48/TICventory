package co.cue.edu.ticventory.ticventory.loan;

import co.cue.edu.ticventory.ticventory.people.Person;
import co.cue.edu.ticventory.ticventory.inventory.Resource;

import java.util.Date;
/**
 * La clase `LoanFacade` implementa el patrón de diseño *Facade*.
 * Su propósito es proporcionar una interfaz simplificada y unificada para interactuar con el sistema de préstamos.
 */
public class LoanFacade {
    /**
     * Método para crear un préstamo.
     * Utiliza un `LoanBuilder` para construir un objeto `Loan` con los parámetros proporcionados.
     *
     * @param person    La persona que solicita el préstamo.
     * @param resource  El recurso que se va a prestar.
     * @param space     El espacio donde se realiza el préstamo.
     * @param startDate La fecha de inicio del préstamo.
     * @param endDate   La fecha de fin del préstamo.
     * @return El objeto `Loan` completamente configurado.
     */
    public Loan createLoan(Person person, Resource resource, Space space, Date startDate, Date endDate) {
        LoanBuilder builder = new LoanBuilder();
        return builder.withUser(person)
                .withResource(resource)
                .withSpace(space)
                .withDates(startDate, endDate)
                .build();
    }

    public void cancelLoan(Loan loan) {
        loan.setState(LoanState.CANCELADO);
        // Aquí podrías agregar lógica adicional para cancelar el préstamo
    }

    public void returnLoan(Loan loan) {
        loan.setState(LoanState.DVUELTO);
        // Aquí podrías agregar lógica para registrar la devolución
    }

    public void overdueLoan(Loan loan) {
        loan.setState(LoanState.RETRASADO);
        // Aquí podrías agregar lógica para marcar como retrasado
    }
}
