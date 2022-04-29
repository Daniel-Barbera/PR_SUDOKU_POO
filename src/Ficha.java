package src;

import java.io.Serializable;

/** @author Daniel Barbera */
public class Ficha implements Serializable {
    private String img;
    private Carta carta;

    public Ficha (Carta carta) {
        this.carta = carta;
        this.img = carta.getImagen();
    }

    public String getImagen() {
        return img;
    }
    public Carta getCarta() {
        return carta;
    }
}
