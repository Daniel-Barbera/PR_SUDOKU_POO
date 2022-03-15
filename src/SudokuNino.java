package src;
import java.util.ArrayList;
import java.io.*;

// Autores: Daniel Barbera

class SudokuNino {
    private ArrayList<Partida> partidas;
    private ArrayList<Clase> aulasColegio;
    
    public SudokuNino() {
        partidas = new ArrayList<>();
        aulasColegio = new ArrayList<>();
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
            /* Ajustar esta sección del código para manejar las excepciones por separado */
            e.printStackTrace();
        } 
    }

    public void jugarPartidaNino(Nino nino, Partida partida) {
        // Posible idea
        if (partida == null) {
            partida = new Partida(nino);
            partidas.add(partida);
        }
        partida.jugar();
    }
}