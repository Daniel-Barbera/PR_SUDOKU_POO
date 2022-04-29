package src;

public class Main {
    public static void main(String[] args) {
        SudokuNino test = new SudokuNino();
        Clase clase = new Clase("Primero", "Antonio");
        
        if (test.anyadirClase(clase)) {
            Nino nino = new Nino("Jose");
            clase.altaNino(nino);
            test.jugarPartidaNino(nino, null);
        } 
    }
}
