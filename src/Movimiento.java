package src;

/** @author Daniel Barbera */
public class Movimiento {
    private int fila, columna;
    private Ficha ficha; // puede ser NULA!

    public Movimiento(int f, int c, Ficha fich) {
        this.fila = f;
        this.columna = c;
        this.ficha = fich;
    }
    
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public Ficha getFicha() {
        return ficha;
    }
}
