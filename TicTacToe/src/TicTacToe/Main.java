
package TicTacToe;

/**
 *
 * @author www.javadb.com
 */
public class Main {

    public void play() {

        TicTacToe game = new TicTacToe();

        System.out.println("Bienvenido el juego de 3 en Raya "+"\n"+"El juego es para dos jugadores.");
        System.out.print("Escriba el nombre del primer jugador: ");
        game.setPlayer1(game.getPrompt());
        System.out.print("Escriba el nombre del segundo jugador: ");
        game.setPlayer2(game.getPrompt());
        boolean markerOk = false;
        while (!markerOk) {
            System.out.print("Seleccione la letra " + game.getPlayer1()+" con la que va a jugar: ");
            String marker = game.getPrompt();
            if (marker.length() == 1 &&
                    Character.isLetter(marker.toCharArray()[0])) {
                markerOk = true;
                game.setMarker1(marker.toCharArray()[0]);
            } else {
                System.out.println("Letra incorrecta, escriba otra vez");
            }
        }
        markerOk = false;
        while (!markerOk) {
            System.out.print("Seleccione la letra " + game.getPlayer2()+" con la que va a jugar: ");
            String marker = game.getPrompt();
            if (marker.length() == 1 &&
                    Character.isLetter(marker.toCharArray()[0])) {
                markerOk = true;
                game.setMarker2(marker.toCharArray()[0]);
            } else {
                System.out.println("Letra incorrecta, escriba otra vez");
            }
        }

        boolean continuePlaying = true;

        while (continuePlaying) {

            game.init();
            System.out.println();
            System.out.println(game.getRules());
            System.out.println();
            System.out.println(game.drawBoard());
            System.out.println();

            String player = null;
            while (!game.winner() && game.getPlays() < 9) {
                player = game.getCurrentPlayer() == 1 ? game.getPlayer1() : game.getPlayer2();
                boolean validPick = false;
                while (!validPick) {
                    System.out.print("Es el turno de " + player + " Seleccione un cuadro: ");
                    String square = game.getPrompt();
                    if (square.length() == 1 && Character.isDigit(square.toCharArray()[0])) {
                        int pick = 0;
                        try {
                            pick = Integer.parseInt(square);
                        } catch (NumberFormatException e) {
                            //Do nothing here, it'll evaluate as an invalid pick on the next row.
                        }
                        validPick = game.placeMarker(pick);
                    }
                    if (!validPick) {
                        System.out.println("El cuadro no puede ser selccionado");
                    }
                }
                game.switchPlayers();
                System.out.println();
                System.out.println(game.drawBoard());
                System.out.println();
            }
            if (game.winner()) {
                System.out.println("GAME OVER - " +"\n"+ player + " Gana!!!");
            } else {
                System.out.println("GAME OVER - "+"\n"+"Empate");
            }
            System.out.println();
            System.out.print("Desea jugar otra partida? (Y/N): ");
            String choice = game.getPrompt();
            if (!choice.equalsIgnoreCase("Y")) {
                continuePlaying = false;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.play();
    }
}

