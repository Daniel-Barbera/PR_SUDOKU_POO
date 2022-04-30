package src;
import java.io.Serializable;

/** @author Daniel Barbera */
public class Cuadricula implements Serializable {
    private Ficha[][] fichas;
    private final int ancho;
    private final int alto;

    public Cuadricula(Ficha[][] fichas) {
        this.fichas = fichas;
        this.alto = fichas.length;
        this.ancho = fichas[0].length;
    }

    public Cuadricula(Cuadricula otro) {
        this.fichas = new Ficha[otro.fichas.length][];
        for (int i = 0; i < otro.fichas.length; ++i) {
            Ficha[] filaFichasOtro = otro.fichas[i];
            this.fichas[i] = new Ficha[filaFichasOtro.length];
            
            for (int j = 0; j < filaFichasOtro.length; ++j) {
                this.fichas[i][j] = new Ficha(filaFichasOtro[j]);
            }
        }
        this.alto = this.fichas.length;
        this.ancho = this.fichas[0].length;
    }

    public Ficha[][] getFichas() {
        // TODO: Comprobar si este método es necesario
        return fichas;
    }
    public int getAlto() {
        return alto;
    }
    public int getAncho() {
        return ancho;
    }

    public void mover(Movimiento mov) {
        this.fichas[mov.getFila()][mov.getColumna()] = mov.getFicha();
    }
    

}
