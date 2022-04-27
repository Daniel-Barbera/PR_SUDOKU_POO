package src;

/** @author Daniel Barbera */
public class Ficha {
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
