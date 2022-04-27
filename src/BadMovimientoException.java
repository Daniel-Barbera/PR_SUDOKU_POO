package src;

/** @author Daniel Barbera */
public class BadMovimientoException extends Exception {
    public BadMovimientoException(Movimiento mov, int filasSudoku, int columnasSudoku) {
        super(String.format(
    "Movimiento imposible. El movimiento en el bloque %d %d se sale de la cuadrícula de tamaño %d por %d.",
            mov.getFila(), mov.getColumna(), filasSudoku, columnasSudoku
            )
        );
        System.exit(-1);
    }
}
