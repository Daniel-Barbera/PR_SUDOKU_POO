package src;
import java.util.HashSet; 

/** @author Daniel Barbera */
public class Clase {
    private HashSet<Nino> ninosClase; // <- numNinosClase == ninosClase.size()
    private HashSet<String> profesoresClase; 
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

    
    public boolean actualizaNino(Nino nino) {
        // TODO: Implementar estados de partida para método
        // Cambiar todos los datos tras terminar una partida
        return true;
    }
    
    
    public boolean actualizaProfesor(String profesor) {
        // TODO: Preguntar a Estefanía
        return true;
    }
}
