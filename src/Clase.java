package src;
import java.io.Serializable;
import java.util.HashSet; 

/** @author Daniel Barbera */
public class Clase implements Serializable {
    private final String nombre;
    private HashSet<Nino> ninosClase;
    private String profesor;

    public Clase(String nombre, String nombreProfesor) {
        this.nombre = nombre;
        this.ninosClase = new HashSet<>();
        this.profesor = nombreProfesor;
    }

    public String getNombre() {
        return nombre;
    }
    public HashSet<Nino> getNinosClase() {
        return ninosClase;
    }
    public String getProfesor() {
        return profesor;
    }

    public float mediaPartidasEchadasXNino() {
        int partidasJugadas = 0;
        for (Nino nino: ninosClase) {
            partidasJugadas += nino.getNumPartidasJugadas();
        }
        return Math.round((float) partidasJugadas / numNinosClase());
    }
    
    public float mediaPartidasGanadasXNino() {
        int partidasGanadas = 0;
        for (Nino nino: ninosClase) {
            partidasGanadas += nino.getNumPartidasGanadas();
        }
        return Math.round((float) partidasGanadas / numNinosClase());
    }

    public int numNinosClase() {
        return ninosClase.size();
    }

    public boolean altaNino(Nino nino) {
        if (nino.getClase() != null) return false; // El niño ya tiene clase
        if (!ninosClase.add(nino)) return false; // El niño ya está en la clase
        nino.setClase(this.nombre);
        return true;  
    }

    public boolean bajaNino(Nino nino) {
        if (!ninosClase.remove(nino)) return false;
        nino.setClase(null);
        return true;
    }

    public boolean altaProfesor(String nombre) {
        if (this.profesor != null) {
            this.profesor = nombre;
            return true;
        }
        return false;
    }

    public boolean actualizaNino(Nino nino) {
        ninosClase.remove(nino);
        ninosClase.add(nino);
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
        if (profesor != null && !profesor.isBlank()) {
            this.profesor = profesor;
            return true;
        }
        return false; 
    }
}
