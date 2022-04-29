package src;

import java.io.Serializable;

/** @author Daniel Barbera */
public class Cuadricula implements Serializable {
    private Ficha[][] cuadricula;
    private final int ancho;
    private final int alto;
    public Cuadricula(Ficha[][] cuad) {
        this.cuadricula = cuad;
        this.alto = cuad.length;
        this.ancho = cuad[0].length;
    }

    public Ficha[][] getCuadricula() {
        // TODO: Comprobar si este método es necesario
        return cuadricula;
    }
    public int getAlto() {
        return alto;
    }
    public int getAncho() {
        return ancho;
    }

    public void mover(Movimiento mov) {
        cuadricula[mov.getFila()][mov.getColumna()] = mov.getFicha();
    }
    

}
