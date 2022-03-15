package src;
import java.security.SecureRandom;

public class Nino {
    private final int usuario;
    private String clase; 
    private int nivel, numPartGanadas, numPartJugadas;

    public Nino(String clase) {
        SecureRandom rand = new SecureRandom(); 
        usuario = rand.nextInt(0x3f3f3f3f);
        this.clase = clase;
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

}
