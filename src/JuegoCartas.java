package src;

/** @author Daniel Barbera */
public class JuegoCartas {
    private Ficha[] fichas;

    public JuegoCartas(Ficha[] fichas) {
        this.fichas = fichas;
    }

    // Para poder pinchar en las fichas del juego.
    public Ficha[] getFichas() {
        return fichas;
    }
}
