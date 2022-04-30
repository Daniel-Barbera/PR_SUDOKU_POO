package src;
import java.io.Serializable;

/** @author Daniel Barbera */
public class Tablero implements Serializable {
    private Cuadricula[][] cuadriculas;
    private JuegoCartas juegoCartas;
    public static int siguienteId;
    private final int id;

    public Tablero(Cuadricula[][] cuad, JuegoCartas jCartas) {
        this.cuadriculas = cuad;
        this.juegoCartas = jCartas;
        this.id = siguienteId;
        ++siguienteId;
    }

    public Tablero(Tablero otro) {
        this.cuadriculas = new Cuadricula[otro.cuadriculas.length][];
        for (int i = 0; i < otro.cuadriculas.length; ++i) {
            Cuadricula[] filaCuadriculasOtro = otro.cuadriculas[i];
            this.cuadriculas[i] = new Cuadricula[otro.cuadriculas[0].length];

            for (int j = 0; j < filaCuadriculasOtro.length; ++j) {
                this.cuadriculas[i][j] = new Cuadricula(filaCuadriculasOtro[j]);
            }
        }
        this.juegoCartas = otro.juegoCartas;
        this.id = siguienteId;
        ++siguienteId;
    }

    public Cuadricula[][] getCuadriculas() {
        return cuadriculas;
    }    
    public JuegoCartas getJuegoCartas() {
        return juegoCartas;
    }
    public static int getSiguienteId() {
        return siguienteId;
    }
    public static void setSiguienteId(int siguienteId) {
        Tablero.siguienteId = siguienteId;
    }

    public void mover(Movimiento mov) {
        int altoCuadricula = cuadriculas[0][0].getAlto(), anchoCuadricula = cuadriculas[0][0].getAncho(); 
        Movimiento movAux = new Movimiento(mov.getFila() % anchoCuadricula, mov.getColumna() % altoCuadricula, mov.getFicha());
        Cuadricula cuadricula = cuadriculas[mov.getFila() % cuadriculas.length][movAux.getColumna() % cuadriculas[0].length];
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
