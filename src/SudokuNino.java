package src;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** @author Daniel Barbera */
class SudokuNino implements Serializable {
    private TreeMap<Nino, ArrayList<Partida>> partidas;
    private HashSet<Clase> aulasColegio;
    private int siguienteId, siguienteIdUsuario;
    
    public SudokuNino() {
        partidas = new TreeMap<Nino, ArrayList<Partida>>();
        aulasColegio = new HashSet<Clase>();
    }

    public TreeMap<Nino, ArrayList<Partida>> getPartidas() {
        return partidas;
    }
    public HashSet<Clase> getAulasColegio() {
        return aulasColegio;
    }

    public boolean anyadirClase(Clase clase) {
        if (!aulasColegio.add(clase)) {
            return false;
        }
        return true;
    }   

    public void backUp() {
        try {
            // Tratamiento variables estáticas
            this.siguienteId = Tablero.getSiguienteId();
            this.siguienteIdUsuario = Nino.getSiguienteIdUsuario();
            // Crear bck
            String div = System.getProperty("file.separator");
            DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss");
            LocalDateTime fecha = LocalDateTime.now();
            String rutaFichero = "src" + div + "bck" + div + fechaFormatter.format(fecha) + ".bck";
            File file = new File(rutaFichero);
            file.createNewFile();
            ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(rutaFichero));
            objectWriter.writeObject(this);
            objectWriter.close();
        } catch (Exception e) {
            // Manejar fallo de escritura
            e.printStackTrace();
        }
    }

    public void restaurarBck(String filePath) {
        try {
            ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(filePath));
            SudokuNino bck = (SudokuNino) objectReader.readObject();
            objectReader.close();
            this.partidas = bck.partidas;
            this.aulasColegio = bck.aulasColegio;
            this.siguienteId = bck.siguienteId;
            this.siguienteIdUsuario = bck.siguienteIdUsuario;
            Nino.setSiguienteIdUsuario(this.siguienteIdUsuario);
            Tablero.setSiguienteId(this.siguienteId); 
        } catch (Exception e) {
            // TODO: Ajustar esta sección del código para manejar las excepciones por separado
            e.printStackTrace();
        } 
    }
 
    public ArrayList<Partida> getPartidasEnCurso(Nino nino) {
        ArrayList<Partida> partidasEnCurso = new ArrayList<Partida>(), partidasNino = partidas.get(nino);
        for (Partida partida: partidasNino) {
            if (!partida.haFinalizado()) partidasEnCurso.add(partida);
        }
        return partidasEnCurso;
    }

    public Partida jugarPartidaNino(Nino nino, Partida partida) {
        // TODO: Hacer muestra de niños con niveles distintos
        /** Pasar null cuando se desee jugar una partida nueva, o 
         * una instancia de partida cuando se desee jugar a esa.
         */
        if (partida == null || partida.haFinalizado()) {
            nino.incrPartidasJugadas();
            partida = crearPartida(nino.getNivel());
            if (!partidas.keySet().contains(nino)) 
                partidas.put(nino, new ArrayList<>());
            partidas.get(nino).add(partida);
        }
        return partida;
    }


    private Partida crearPartida(int nivel) {
        String div = System.getProperty("file.separator");
        String rutaFichero = "src" + div + "plantillas" + div + "Plantilla" + String.format("%02d", nivel) + ".txt";
        Partida partida = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaFichero));
            String line;

            // Saltarse nivel
            reader.readLine();
            int numFichasCuadricula = Integer.parseInt(reader.readLine());

            // Leer juego de cartas
            line = reader.readLine();
            JuegoCartas jCartas = null; 
            switch(line) {
                case "E,C,R,T":
                    jCartas = new JuegoCartas(TipoConjunto.FIGURAS);
                    break;
                case "1,2,3,4":
                    jCartas = new JuegoCartas(TipoConjunto.NUMEROS);
                    break;
                case "H,R,L,C,P,G":
                    jCartas = new JuegoCartas(TipoConjunto.ANIMALES);
                    break;
            }
            
            // Crear matriz de fichas
            String[] filaFichasLeida;
            ArrayList<ArrayList<Ficha>> matrizFichas = new ArrayList<>();
            TipoConjunto conjunto = jCartas.getConjunto();
            while ((line = reader.readLine()) != null) {
                ArrayList<Ficha> filaFichas = new ArrayList<>();
                filaFichasLeida = line.split(",");
                for (String codificacionFicha: filaFichasLeida) {
                    Ficha ficha = new Ficha(new Carta(codificacionFicha.charAt(0), conjunto));
                    filaFichas.add(ficha);
                }
                matrizFichas.add(filaFichas);
            }

            // Crear matriz de cuadrículas a partir de matriz de fichas
            ArrayList<ArrayList<Cuadricula>> cuadriculas = new ArrayList<>();
            for (int i = 0; i < matrizFichas.size(); i = i + 2) {
                Ficha[][] fichasCuadriculaIzq = new Ficha[2][];
                Ficha[][] fichasCuadriculaDer = new Ficha[2][];
                
                ArrayList<Ficha> filaSuperior = matrizFichas.get(i), filaInferior = matrizFichas.get(i+1);
                fichasCuadriculaIzq[0] = filaSuperior.subList(0, numFichasCuadricula/2).toArray(new Ficha[numFichasCuadricula/2]);
                fichasCuadriculaDer[0] = filaSuperior.subList(numFichasCuadricula, filaSuperior.size()).toArray(new Ficha[numFichasCuadricula/2]);
                fichasCuadriculaIzq[1] = filaInferior.subList(0, numFichasCuadricula/2).toArray(new Ficha[numFichasCuadricula/2]);
                fichasCuadriculaDer[1] = filaInferior.subList(numFichasCuadricula/2, filaInferior.size()).toArray(new Ficha[numFichasCuadricula/2]);
                
                ArrayList<Cuadricula> filaCuadriculas = new ArrayList<>();
                filaCuadriculas.add(new Cuadricula(fichasCuadriculaIzq));
                filaCuadriculas.add(new Cuadricula(fichasCuadriculaDer));
                cuadriculas.add(filaCuadriculas);
            }
            
            // Crear tablero a partir de matriz de cuadrículas y juego de cartas
            Cuadricula[][] cuadricula = cuadriculas.toArray(new Cuadricula[cuadriculas.size()][cuadriculas.get(0).size()]);
            Tablero tablero = new Tablero(cuadricula, jCartas);
            partida = new Partida(tablero);
            reader.close();
        } catch (Exception e) {
            // TODO: Ajustar manejo de excepciones
            e.printStackTrace();
        }
        return partida;
    }

    public void finalizarPartida(Nino nino, Partida partida) {
        /** Se da la partida por finalizada, */
        partida.finalizar();
        if (partida.haGanado()) {
            nino.incrPartidasGanadas();
            nino.incrNivel();   // <- Posible bug al jugar el mismo nivel varias veces
        }
    }
}