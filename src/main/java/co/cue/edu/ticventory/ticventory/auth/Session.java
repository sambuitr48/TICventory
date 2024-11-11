package co.cue.edu.ticventory.ticventory.auth;

import java.util.Date;
import co.cue.edu.ticventory.ticventory.people.User;
/**
 * La clase `Session` representa una sesión de usuario en el sistema.
 * Contiene información como el usuario, la fecha de inicio y fin de la sesión y su estado.
 *
 * Funcionalidad: `Session` permite almacenar y gestionar el estado de la sesión, incluyendo la fecha
 * de inicio, la fecha de fin y un estado que indica si la sesión está activa o finalizada.
 */
public class Session {
    private long id;
    private User user;
    private Date fechaInicio;
    private Date fechaFin;
    private char estado;

    public Session(long id, User user, Date fechaInicio, char estado) {
        this.id = id;
        this.user = user;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
    }

    public void finalizarSesion(Date fechaFin) {
        this.fechaFin = fechaFin;
        this.estado = 'F'; // 'F' indica sesión finalizada
    }

    public long getId() {
        return id;
    }

    public User getUsuario() {
        return user;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public char getEstado() {
        return estado;
    }
}
