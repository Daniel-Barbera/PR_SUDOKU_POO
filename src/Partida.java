package src;
import java.io.Serializable;
import java.util.ArrayList;

/** @author Daniel Barbera */
public class Partida implements Serializable {
    private Tablero tablero_inicial;
    private Tablero tablero_visual;
    private ArrayList<Movimiento> movimientos;
    private EstadoPartida estado;
    private enum EstadoPartida {
        EN_CURSO, GANADA, PERDIDA
    }

    public Partida(Tablero tablero) {
        this.tablero_inicial = tablero;
        this.tablero_visual = new Tablero(tablero_inicial.getCuadriculas(), new JuegoCartas(TipoConjunto.NINGUNO));
        this.movimientos = new ArrayList<Movimiento>();
        this.estado = EstadoPartida.EN_CURSO;
    }

    public Tablero getTableroInicial() {
        return tablero_inicial;
    }
    public Tablero getTableroPartida() {
        return tablero_visual;
    }
    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
    public boolean haGanado() {
        return estado == EstadoPartida.GANADA;
    }
    public boolean haFinalizado() {
        return estado != EstadoPartida.EN_CURSO;
    }


    public void mover(Movimiento mov) {
        movimientos.add(mov);
        tablero_visual.mover(mov);
    }

    public void volverAtras(int cantidad_movimientos) {
        /** Volver al i-ésimo movimiento. */
        restaurarAlInicio();
        if (cantidad_movimientos >= movimientos.size()) 
            throw new IndexOutOfBoundsException("Cantidad de movimientos superior a los existentes.");
        for (int i = 0; i < cantidad_movimientos; ++i) {
            tablero_visual.mover(movimientos.get(i));
        }
    }

    public void restaurarAlFinal() {
        /** Repetir todos los movimientos de la partida para
         * devolverse al estado "final".
         */
        for (Movimiento mov: movimientos) {
            tablero_visual.mover(mov);
        }
    }

    public void restaurarAlInicio() {
        /** El método restaura el tablero al estado inicial de la partida,
         * pero no se olvidan los movimientos realizados, siendo posible
         * llamar a restaurarAlFinal().
        */
        tablero_visual = new Tablero(tablero_inicial.getCuadriculas(), tablero_inicial.getJuegoCartas());
    }

    public void reiniciarPartida() {
        /** Se reinicia la partida completamente, olvidando todo. */
        restaurarAlInicio();
        movimientos.clear();
    }

    public void finalizar() {
        /** Método para marcar una partida como FINALIZADA. */
        restaurarAlFinal();
        if (tablero_visual.esSolucion()) {
            this.estado = EstadoPartida.GANADA;
        } else this.estado = EstadoPartida.PERDIDA;
    }
}
