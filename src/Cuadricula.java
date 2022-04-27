package src;

/** @author Daniel Barbera */
public class Cuadricula {
    private Ficha[][] cuadricula;

    public Cuadricula(Ficha[][] cuad) {
        this.cuadricula = cuad;
    }

    public Ficha[][] getCuadricula() {
        // TODO: Comprobar si este método es necesario
        return cuadricula;
    }

    public void mover(Movimiento mov) {
        cuadricula[mov.getFila()][mov.getColumna()] = mov.getFicha();
    }
    
    public int size() {
        return cuadricula.length; 
    }
}
