package src;
import java.util.HashSet; 
public class Clase {
    private HashSet<Nino> ninosClase; // <- numNinosClase == ninosClase.size()
    private HashSet<String> profesoresClase; // <Profesor> ?? 
    public Clase() {
        ninosClase = new HashSet<>();
        profesoresClase = new HashSet<>();
    }

    public int numNinosClase() {return ninosClase.size();}
    public boolean altaNino(Nino nino) {
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

    // ???????????????????
    public boolean actualizaNino(Nino nino) {
        return true;
    }
    public boolean actualizaProfesor(String profesor) {
        return true;
    }
}
