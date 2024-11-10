package co.cue.edu.ticventory.ticventory.loan;

import co.cue.edu.ticventory.ticventory.inventory.Resource;
import co.cue.edu.ticventory.ticventory.people.Sedes;

import java.util.List;

/**
 * La clase `Space` representa un espacio físico dentro de una sede.
 * Un espacio puede contener recursos y tener un tipo y estado específico.
 */
public class Space {
    private String identificador;
    private Sedes sede;
    private List<Resource> recursosEnSala;
    private SpaceType spaceType;
    private int estado;

    // Constructor
    public Space(String identificador, Sedes sede, List<Resource> recursosEnSala, SpaceType spaceType, int estado) {
        this.identificador = identificador;
        this.sede = sede;
        this.recursosEnSala = recursosEnSala;
        this.spaceType = spaceType;
        this.estado = estado;
    }

    // Getters y Setters
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Sedes getSede() {
        return sede;
    }

    public void setSede(Sedes sede) {
        this.sede = sede;
    }

    public List<Resource> getRecursosEnSala() {
        return recursosEnSala;
    }

    public void setRecursosEnSala(List<Resource> recursosEnSala) {
        this.recursosEnSala = recursosEnSala;
    }

    public SpaceType getTipoEspacio() {
        return spaceType;
    }

    public void setTipoEspacio(SpaceType spaceType) {
        this.spaceType = spaceType;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
