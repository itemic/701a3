package kalah.model;
import com.qualitascorpus.testsupport.IO;

import java.util.Collections;
import java.util.List;


public class KalahIO {
    private IO io;

    public KalahIO(IO io) {
        this.io = io;
    }

    public void printBoardEdge() {
        io.println("+----+-------+-------+-------+-------+-------+-------+----+");
    }

    public void printDivider() {
        io.println("|    |-------+-------+-------+-------+-------+-------|    |");
    }

    public void printPlayerOne() {
        io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
    }

    public void printPlayerTwo() {
        io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
    }

    public void printBoard(Game game) {
        StringBuilder sb = new StringBuilder();
        sb.append("+----+-------+-------+-------+-------+-------+-------+----+");
        io.println(sb.toString());
        /////////////////
        sb = new StringBuilder();
        sb.append("| P2 ");
        for (int i = Game.HOUSES_PER_PLAYER; i > 0; i--) {
            sb.append(String.format("|%2d[%2d] ", game.getPlayer2().houseAt(i).getId(), game.getPlayer2().houseAt(i).getSeeds()));
        }
        sb.append(String.format("| %2d |", game.getPlayer1().getStore().getSeeds()));
        io.println(sb.toString());
/////////////////
        sb = new StringBuilder();
        sb.append("|    |-------+-------+-------+-------+-------+-------|    |");
        io.println(sb.toString());
/////////////////
        sb = new StringBuilder();
        sb.append(String.format("| %2d ", game.getPlayer2().getStore().getSeeds()));
        for (House house: game.getPlayer1().getHouses()) {
            sb.append(String.format("|%2d[%2d] ", house.getId(), house.getSeeds()));
        }
        sb.append("| P1 |");
        io.println(sb.toString());
/////////////////
        sb = new StringBuilder();
        sb.append("+----+-------+-------+-------+-------+-------+-------+----+");
        io.println(sb.toString());
    }


    public int printPrompt(Game g) {

        return io.readInteger("Player "+ g.getTurn().getName() + "'s turn - Specify house number or 'q' to quit: ", 1, 6, -1, "q");
    }

    public void printEnd() {
        io.println("Game over");
    }

    public void invalidMove() {
        io.println("House is empty. Move again.");
    }
}
