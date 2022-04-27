package src;
import java.security.SecureRandom;

/** @author Daniel Barbera */
public class Nino {
    private final int usuario;
    private String clase; 
    private int nivel, numPartGanadas, numPartJugadas;
    private Partida partida; // TODO: Manejar 

    public Nino(String clase) {
        SecureRandom rand = new SecureRandom(); 
        usuario = rand.nextInt(0x3f3f3f3f);
        this.clase = clase;
        partida = null;
    } 

    public int getUsuario() {return usuario;}
    public String getClase() {return clase;}
    public int getNivel() {return nivel;}
    public int getNumPartGanadas() {return numPartGanadas;}
    public int getNumPartJugadas() {return numPartJugadas;}

    public void setClase(String clase) {this.clase = clase;}

    public void incrNivel(){++nivel;}
    public void incrPartidasGanadas(){++numPartGanadas;}
    public void incrPartidasJugadas(){++numPartJugadas;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Nino other = (Nino) obj;
        return other.usuario == usuario; 
    }

    @Override
    public String toString() {
        return "Nino [clase=" + clase + ", nivel=" + nivel + ", numPartGanadas=" + numPartGanadas + ", numPartJugadas="
                + numPartJugadas + ", usuario=" + usuario + "]";
    }
    
    public Partida jugar() {
        if (partida == null) {
            throw new Exception("¡No tienes una partida guardada! Escoge un nivel.");
            return null;
        }
        return partida;
    }


    private Tablero leerFichero() {
        // TODO: Leer fichero
    }
}
