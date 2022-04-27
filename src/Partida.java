package src;
import java.util.ArrayList;

/** @author Daniel Barbera */
public class Partida {
    private Tablero tablero_inicial;
    private Tablero tablero_visual; // TODO: Limpiar Juego de Cartas innecesario (duplicado)
    private ArrayList<Movimiento> movimientos;
    private EstadoPartida estado;
    private enum EstadoPartida {
        EN_CURSO, GANADA, PERDIDA
    }

    public Partida(Tablero tablero) {
        this.tablero_inicial = tablero;
        this.tablero_visual = new Tablero(tablero_inicial.getCuadriculas(), tablero_inicial.getJuegoCartas());
        this.movimientos = new ArrayList<Movimiento>();
        this.estado = EstadoPartida.EN_CURSO;
    }

    public Tablero getTableroInicial() {
        return tablero_inicial;
    }
    public Tablero getTableroPartida() {
        return tablero_visual;
    }
    public boolean haGanado() {
        return estado == EstadoPartida.GANADA;
    }
   
    public ArrayList<Movimiento> getMovimientos() {
         // Con esto se puede hacer la lista de movimientos en la interfaz
        return movimientos;
    }

    public void mover(Movimiento mov) {
        movimientos.add(mov);
        tablero_visual.mover(mov);
    }

    // Volver al i-ésimo movimiento.
    public void volverAtras(int cantidad_movimientos) {
        restaurarAlInicio();
        if (cantidad_movimientos >= movimientos.size()) 
            throw new ArrayIndexOutOfBoundsException("Cantidad de movimientos superior a los existentes.");
        for (int i = 0; i < cantidad_movimientos; ++i) {
            tablero_visual.mover(movimientos.get(i));
        }
    }

    // Dejarlo como estaba antes de visualizar un movimiento.
    public void restaurarAlFinal() {
        for (Movimiento mov: movimientos) {
            tablero_visual.mover(mov);
        }
    }

    // Mostrar el tablero al inicio de la partida.
    public void restaurarAlInicio() {
        tablero_visual = new Tablero(tablero_inicial.getCuadriculas(), tablero_inicial.getJuegoCartas());
    }

    // Reiniciar todo.
    public void reiniciarPartida() {
        restaurarAlInicio();
        movimientos.clear();
    }

    public void finalizar() {
        if (tablero_visual.esSolucion()) {
            this.estado = EstadoPartida.GANADA;
        } else this.estado = EstadoPartida.PERDIDA;
    }
}
