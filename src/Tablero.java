package src;

import java.io.Serializable;

/** @author Daniel Barbera */
public class Tablero implements Serializable {
    // TODO: Preguntar si se pueden revertir movimientos
    // TODO: Preguntar si el feedback parcial puede ser no dejar al niño hacer jugadas erróneas
    private Cuadricula[][] cuadriculas;
    private JuegoCartas juegoCartas;

    public Tablero(Cuadricula[][] cuad, JuegoCartas jCartas) {
        this.cuadriculas = cuad;
        this.juegoCartas = jCartas;
    }

    public Cuadricula[][] getCuadriculas() {
        return cuadriculas;
    }    
    public JuegoCartas getJuegoCartas() {
        return juegoCartas;
    }

    public void mover(Movimiento mov) {
        int altoCuadricula = cuadriculas[0][0].getAlto(), anchoCuadricula = cuadriculas[0][0].getAncho(); 
        Movimiento movAux = new Movimiento(mov.getFila() % anchoCuadricula, mov.getColumna() % altoCuadricula, mov.getFicha());
        Cuadricula cuadricula = cuadriculas[mov.getFila() % cuadriculas.length][movAux.getColumna() % cuadriculas.length];
        cuadricula.mover(movAux);
    }
    
    public boolean esSolucion() {
        // TODO: Implementar algoritmo backtracking // ¿Quizás solución precomputada? 
        boolean esSolucion = true;
        // código
        if (esSolucion) return true;
        return false;
    }
}
