package src;
import java.io.Serializable;
import java.security.SecureRandom;

/** @author Daniel Barbera */
public class Nino implements Comparable<Nino>, Serializable {
    // TODO: Preguntar a Estefanía si los niños tienen nombre (para la interfaz?)
    public static final int NIVEL_MAXIMO = 14;
    private final int usuario;
    private String clase; 
    private int nivel, numPartGanadas, numPartJugadas;

    public Nino(String clase) {
        SecureRandom rand = new SecureRandom(); 
        this.usuario = rand.nextInt(0x3f3f3f3f);
        this.nivel = 1;
        this.clase = clase;
    } 

    public int getUsuario() {
        return usuario;
    }
    public String getClase() {
        return clase;
    }
    public int getNivel() {
        return nivel;
    }
    public int getNivelMaximo() {
        return NIVEL_MAXIMO;
    }
    public int getNumPartidasGanadas() {
        return numPartGanadas;
    }
    public int getNumPartidasJugadas() {
        return numPartJugadas;
    }

    public void setClase(String clase) {this.clase = clase;}

    public boolean incrNivel() {
        if (nivel < NIVEL_MAXIMO) {
            ++nivel;
            return true;
        }
        return false;
    }
    public void incrPartidasGanadas(){++numPartGanadas;}
    public void incrPartidasJugadas(){++numPartJugadas;}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + usuario;
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
        Nino other = (Nino) obj;
        if (usuario != other.usuario)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Nino [clase=" + clase + ", nivel=" + nivel + ", numPartGanadas=" + numPartGanadas + ", numPartJugadas="
                + numPartJugadas + ", usuario=" + usuario + "]";
    }
    

    @Override
    public int compareTo(Nino other) {
        return Integer.compare(this.usuario, other.usuario);
    }
}
