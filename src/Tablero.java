package src;

/** @author Daniel Barbera */
public class Tablero {
    private Cuadricula[][] cuadriculas;
    private JuegoCartas juegoCartas;

    
    public Tablero(Cuadricula[][] cuad, JuegoCartas jCartas) {
        this.cuadriculas = cuad;
        this.juegoCartas = jCartas;
    }

    public Cuadricula[][] getCuadriculas() {return cuadriculas;}    
    public JuegoCartas getJuegoCartas() {return juegoCartas;}

    public void mover(Movimiento mov) {
        final int CUAD_LENGTH = cuadriculas[0][0].size();
        Movimiento movAux = new Movimiento(mov.getFila() % CUAD_LENGTH, mov.getColumna() % CUAD_LENGTH, mov.getFicha());
        Cuadricula cuadricula = cuadriculas[movAux.getFila()][movAux.getColumna()];
        cuadricula.mover(mov);
    }
    
    public boolean esSolucion() {
        // TODO: Implementar algoritmo backtracking
        boolean esSolucion = true;
        // código
        if (esSolucion) return true;
        return false;
    }
}
