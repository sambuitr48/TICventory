package co.cue.edu.ticventory.ticventory.loan;

import co.cue.edu.ticventory.ticventory.people.Person;
import co.cue.edu.ticventory.ticventory.inventory.Resource;


import java.util.Date;
/**
 * La clase `Loan` representa un préstamo de recursos a una persona en un espacio determinado.
 * Esta clase almacena información sobre el préstamo, como el usuario que solicita el recurso,
 * el recurso en sí, el espacio donde se usará el recurso, las fechas de inicio y fin del préstamo,
 * y el estado del préstamo.
 *
 * Además, incluye los métodos necesarios para acceder y modificar los valores de estas propiedades.
 */
public class Loan {
    private int id;
    private Person person;
    private Resource resource;
    private Space space;
    private Date startDate;
    private Date endDate;
    private LoanState state;
    /**
     * Constructor que inicializa todos los atributos del préstamo.
     *
     * @param id Identificador único del préstamo
     * @param person Persona que solicita el préstamo
     * @param resource Recurso que se va a prestar
     * @param space Espacio donde se utilizará el recurso
     * @param startDate Fecha de inicio del préstamo
     * @param endDate Fecha de fin del préstamo
     * @param state Estado actual del préstamo
     */
    public Loan(int id, Person person, Resource resource, Space space, Date startDate, Date endDate, LoanState state) {
        this.id = id;
        this.person = person;
        this.resource = resource;
        this.space = space;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getUser() {
        return person;
    }

    public void setUser(Person person) {
        this.person = person;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public LoanState getState() {
        return state;
    }

    public void setState(LoanState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Loan{id=" + id + ", user=" + person + ", resource=" + resource + ", space='" + space + '\'' +
                ", startDate=" + startDate + ", endDate=" + endDate + ", state=" + state + '}';
    }
}
