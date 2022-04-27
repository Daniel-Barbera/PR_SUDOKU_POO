package src;

/** @author Daniel Barbera */
public class Tablero {
    private Cuadricula cuadricula;
    private JuegoCartas juegoCartas;
    
    public Tablero(Cuadricula cuad, JuegoCartas jCartas) {
        this.cuadricula = cuad;
        this.juegoCartas = jCartas;
    }

    public Cuadricula getCuadricula() {return cuadricula;}    
    public JuegoCartas getJuegoCartas() {return juegoCartas;}
    public void mover(Movimiento mov) {
        cuadricula.mover(mov);
    }
}
