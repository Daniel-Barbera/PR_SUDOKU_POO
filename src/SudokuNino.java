package src;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

import java.io.*;

/** @author Daniel Barbera */
class SudokuNino implements Serializable {
    // TODO: Preguntar a Estefanía si se pueden almacenar varias partidas por niño.
    // TODO: Preguntar a Estefanía si los niños pueden tener más de una partida pendiente.
    // Podría pasar a ser TreeMap<Nino, ArrayList<Partida>> si se requiere almacenar
    // varias partidas por niño. 
    private TreeMap<Nino, Partida> partidas;
    private HashSet<Clase> aulasColegio;
    
    public SudokuNino() {
        partidas = new TreeMap<Nino, Partida>();
        aulasColegio = new HashSet<Clase>();
    }

    public TreeMap<Nino, Partida> getPartidas() {
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
            ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream("/rutaMiFicheroBackup/nombreFich.bck"));
            objectWriter.writeObject(this);
            objectWriter.close();
        } catch (Exception e) {
            // Manejar fallo de escritura
            e.printStackTrace();
        }
    }

    public void restaurarBck(String file) {
        try {
            ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(file));
            SudokuNino bck = (SudokuNino) objectReader.readObject();
            objectReader.close();
            this.partidas = bck.partidas;
            this.aulasColegio = bck.aulasColegio; 
        } catch (Exception e) {
            // TODO: Ajustar esta sección del código para manejar las excepciones por separado
            e.printStackTrace();
        } 
    }

    public Partida jugarPartidaNino(Nino nino, Partida partida) {
        // TODO: Preguntar a Estefanía si los niños pueden escoger nivel
        if (partida == null || partida.haFinalizado()) {
            nino.incrPartidasJugadas();
            partida = crearPartida(nino.getNivel());
            partidas.put(nino, partida);
        }
        return partida;
    }

    private Partida crearPartida(int nivel) {
        String rutaFichero = "rutaPlantillas/plantilla_" + String.format("%0d", nivel) + ".txt";
        Partida partida = null;
        try {
            // TODO: Preguntar a Estefanía si se necesita el nombre para algo
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
            // TODO: Preguntar a Estefanía / Decidir qué hacer cuando el niño llega al nivel máximo
            nino.incrNivel();
        }
        partida = null;
    }

    public void guardarPartida() {
        /** Éste método existe por semántica. No hace nada. */
        return;
    }
}