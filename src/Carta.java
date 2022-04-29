package src;
import java.io.Serializable;
import java.util.Map;

/** @author Daniel Barbera */
public class Carta implements Serializable {
    private TipoCarta tipo;
    private TipoConjunto conjunto;
    // El método Map.of() hace que los siguientes mapas sean inmutables.
    // TODO: Decidir si buscar imágenes por internet o usar las incluidas.
    private static final Map<TipoCarta, String> FIGURAS = Map.of(
        TipoCarta.ESTRELLA, "<ruta a imagen>",
        TipoCarta.CIRCULO, "<ruta a imagen>",
        TipoCarta.ROMBO, "<ruta a imagen>",
        TipoCarta.TRIANGULO, "<ruta a imagen>"
    );
    private static final Map<TipoCarta, String> NUMEROS = Map.of(
        TipoCarta.UNO, "<ruta a imagen>",
        TipoCarta.DOS, "<ruta a imagen>",
        TipoCarta.TRES, "<ruta a imagen>",
        TipoCarta.CUATRO, "<ruta a imagen>"
    );
    private static final Map<TipoCarta, String> ANIMALES = Map.of(
        TipoCarta.HIPPO, "<ruta a imagen>",
        TipoCarta.RANA, "<ruta a imagen>",
        TipoCarta.LEON, "<ruta a imagen>",
        TipoCarta.CERDO, "<ruta a imagen>",
        TipoCarta.POLLITO, "<ruta a imagen>",
        TipoCarta.GATO, "<ruta a imagen>"
    );


    public Carta (TipoCarta tipo) {
        this.tipo = tipo;
        if (FIGURAS.containsKey(tipo)) this.conjunto = TipoConjunto.FIGURAS;
        else if (NUMEROS.containsKey(tipo)) this.conjunto = TipoConjunto.NUMEROS;
        else if (ANIMALES.containsKey(tipo)) this.conjunto = TipoConjunto.ANIMALES;
        else this.conjunto = TipoConjunto.NINGUNO;
    }

    public Carta(char c, TipoConjunto conjunto) {
        this.conjunto = conjunto;

        switch(conjunto) {
            case FIGURAS:
                switch(c) {
                    case 'E':
                        this.tipo = TipoCarta.ESTRELLA;
                        break;
                    case 'C':
                        this.tipo = TipoCarta.CIRCULO;
                        break;
                    case 'R':
                        this.tipo = TipoCarta.ROMBO;
                        break;
                    case 'T':
                        this.tipo = TipoCarta.TRIANGULO;
                        break;
                }
                break;
            case NUMEROS:
                switch(c) {
                    case '1':
                        this.tipo = TipoCarta.UNO;
                        break;
                    case '2':
                        this.tipo = TipoCarta.DOS;
                        break;
                    case '3':
                        this.tipo = TipoCarta.TRES;
                        break;
                    case '4':
                        this.tipo = TipoCarta.CUATRO;
                        break;
                }
            case ANIMALES:
                switch(c) {
                    case 'H':
                        this.tipo = TipoCarta.HIPPO;
                        break;
                    case 'R':
                        this.tipo = TipoCarta.RANA;
                        break;
                    case 'L':
                        this.tipo = TipoCarta.LEON;
                        break;
                    case 'C':
                        this.tipo = TipoCarta.CERDO;
                        break;
                    case 'P':
                        this.tipo = TipoCarta.POLLITO;
                        break;
                    case 'G':
                        this.tipo = TipoCarta.GATO;
                        break;
                }
                default:
                    this.tipo = TipoCarta.NULA;
                    break;
            }
    }

    public TipoCarta getTipoCarta() {
        return tipo;
    }

    public static Map<TipoCarta, String> getFiguras() {
        return FIGURAS;
    }
    public static Map<TipoCarta, String> getNumeros() {
        return NUMEROS;
    }
    public static Map<TipoCarta, String> getAnimales() {
        return ANIMALES;
    }

    public String getImagen() {
        switch(conjunto) {
            case ANIMALES:
                return ANIMALES.get(tipo);
            case NUMEROS:
                return NUMEROS.get(tipo);
            case FIGURAS:
                return FIGURAS.get(tipo);
            default:
                return "<imagen de carta nula>";
        }
    }
}
