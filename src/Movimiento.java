package src;

import java.io.Serializable;

/** @author Daniel Barbera */
public class Movimiento implements Serializable {
    private int columna, fila;
    private Ficha ficha; // puede ser NULA!

    public Movimiento(int c, int f, Ficha fich) {
        this.columna = c;
        this.fila = f;
        this.ficha = fich;
    }
    
    public int getColumna() {
        return columna;
    }
    public int getFila() {
        return fila;
    }
    public Ficha getFicha() {
        return ficha;
    }
}
