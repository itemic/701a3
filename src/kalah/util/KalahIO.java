package kalah.util;
import com.qualitascorpus.testsupport.IO;
import kalah.model.Game;
import kalah.model.House;
import kalah.model.Pit;

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

        for (int i = 6; i > 0; i--) {
            sb.append(String.format("|%2d[%2d] ", i, game.getBoard().getPit(i+6).getSeeds()));

        }


        sb.append(String.format("| %2d |", game.getBoard().getPit(6).getSeeds()));
        io.println(sb.toString());
/////////////////
        sb = new StringBuilder();
        sb.append("|    |-------+-------+-------+-------+-------+-------|    |");
        io.println(sb.toString());
/////////////////
        sb = new StringBuilder();
        sb.append(String.format("| %2d ", game.getBoard().getPit(13).getSeeds()));
        for (int i = 1; i < 7; i++) {
            sb.append(String.format("|%2d[%2d] ", i, game.getBoard().getPit(i-1).getSeeds()));
        }
        sb.append("| P1 |");
        io.println(sb.toString());
/////////////////
        sb = new StringBuilder();
        sb.append("+----+-------+-------+-------+-------+-------+-------+----+");
        io.println(sb.toString());
    }


    public int printPrompt(Game g) {

        return io.readInteger("Player P"+ g.getTurn() + "'s turn - Specify house number or 'q' to quit: ", 1, Game.HOUSES_PER_PLAYER, -1, "q");
    }

    public void printEnd() {
        io.println("Game over");
    }


}
