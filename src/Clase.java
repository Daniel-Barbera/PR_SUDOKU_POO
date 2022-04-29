package src;
import java.io.Serializable;
import java.util.HashSet; 

/** @author Daniel Barbera */
public class Clase implements Serializable {
    private final String nombre;
    private HashSet<Nino> ninosClase; // <- numNinosClase == ninosClase.size()
    private HashSet<String> profesoresClase; 

    public Clase(String nombre) {
        this.nombre = nombre;
        ninosClase = new HashSet<>();
        profesoresClase = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }
    public HashSet<Nino> getNinosClase() {
        return ninosClase;
    }
    public HashSet<String> getProfesoresClase() {
        return profesoresClase;
    }

    public int numPartidasJugadas() {
        int partidasJugadas = 0;
        for (Nino nino: ninosClase) {
            partidasJugadas += nino.getNumPartidasJugadas();
        }
        return partidasJugadas;
    }
    
    public float mediaPartidasGanadas() {
        int partidasJugadas = 0, partidasGanadas = 0;
        for (Nino nino: ninosClase) {
            partidasJugadas += nino.getNumPartidasJugadas();
            partidasGanadas += nino.getNumPartidasGanadas();
        }
        return Math.round((float) partidasGanadas / (float) partidasJugadas);
    }

    public int numNinosClase() {
        return ninosClase.size();
    }

    public boolean altaNino(Nino nino) {
        if (nino.getClase() != nombre) return false;
        if (!ninosClase.add(nino)) return false;
        return true; 
    }

    public boolean bajaNino(Nino nino) {
        if (!ninosClase.remove(nino)) return false;
        return true;
    }

    public boolean altaProfesor(String nombre) {
        if (!profesoresClase.add(nombre)) return false;
        return true;
    }

    public boolean actualizaNino(Nino nino) {
        // TODO: Preguntar a Estefanía para qué sirve este método
        // ¿Cambiar todos los datos tras terminar una partida?
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Clase other = (Clase) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    public boolean actualizaProfesor(String profesor) {
        // TODO: Preguntar a Estefanía en qué consiste un profesor, y para qué serviría este método
        return true;
    }
}
