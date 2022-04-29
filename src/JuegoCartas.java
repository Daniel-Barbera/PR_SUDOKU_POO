package src;

import java.io.Serializable;
import java.util.Map;

/** @author Daniel Barbera */
public class JuegoCartas implements Serializable {
    private Ficha[] fichas;
    private TipoConjunto conjunto;

    public JuegoCartas(TipoConjunto tConjunto) {
        this.conjunto = tConjunto;
        int i = 0;
        switch(tConjunto) {
            case FIGURAS:
                this.fichas = new Ficha[4];
                Map<TipoCarta, String> figuras = Carta.getFiguras();

                for (TipoCarta figura: figuras.keySet()) {
                    fichas[i] = new Ficha(new Carta(figura));
                    ++i;
                }
                break;
            case NUMEROS:
                this.fichas = new Ficha[4];
                Map<TipoCarta, String> numeros = Carta.getFiguras();

                for (TipoCarta numero: numeros.keySet()) {
                    fichas[i] = new Ficha(new Carta(numero));
                    ++i;
                }
                break;
            case ANIMALES:
                this.fichas = new Ficha[6];
                Map<TipoCarta, String> animales = Carta.getFiguras();

                for (TipoCarta animal: animales.keySet()) {
                    fichas[i] = new Ficha(new Carta(animal));
                    ++i;
                }
                break;
            default:
                this.fichas = null;
                break;
        }
    }

    public Ficha[] getFichas() {
        /** Para poder pinchar en las fichas. */
        return fichas;
    }
    public TipoConjunto getConjunto() {
        return conjunto;
    }
    public int size() {
        return fichas.length;
    }
}
