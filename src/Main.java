package src;

public class Main {
    public static void main(String[] args) {
        SudokuNino test = new SudokuNino();
        Clase clase = new Clase("Primero", "Antonio");
        
        if (test.anyadirClase(clase)) {
            Nino nino = new Nino("Jose");
            clase.altaNino(nino);
            Partida partida = test.jugarPartidaNino(nino, null);

            for(int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    partida.mover(new Movimiento(i, j, new Ficha(new Carta(TipoCarta.ESTRELLA))));
                    System.out.println(i + " " + j);
                }
            }

            System.out.println();
            for (Cuadricula[] c: partida.getTableroVisual().getCuadriculas()) {
                for (Cuadricula cuadricula : c) {
                    for (Ficha[] fichas: cuadricula.getFichas()) {
                        for (Ficha ficha: fichas) {
                            System.out.println(ficha.getCarta().getTipoCarta().toString());
                        }
                    }
                }
            }
            System.out.println("fin");
        } 
    }
}
