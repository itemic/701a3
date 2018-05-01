package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
import kalah.model.Game;
import kalah.model.InvalidMoveException;
import kalah.model.KalahIO;
import kalah.model.Player;

/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure.
 */
public class Kalah {
	public static void main(String[] args) {
		new Kalah().play(new MockIO());
	}
	public void play(IO io) {
	    KalahIO kio = new KalahIO(io);

	    Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        Game game = new Game(p1, p2);
        kio.printBoard(game);
	    int test = kio.printPrompt(game);
	    while (test != -1) {
            try {
                game.makeMove(test);
            } catch (InvalidMoveException e) {
                kio.invalidMove();
            }
            kio.printBoard(game);
            if (game.getTurn().isOver()) {
                break;
            }
            test = kio.printPrompt(game);
        }
        kio.printEnd();
        kio.printBoard(game);

        if (p1.isOver() || p2.isOver()) {
            io.println("\tplayer 1:" + p1.getScore());
            io.println("\tplayer 2:" + p2.getScore());

            if (p1.getScore() > p2.getScore()) {
                io.println("Player 1 wins!");
            } else if (p1.getScore() < p2.getScore()) {
                io.println("Player 2 wins!");
            } else {
                io.println("A tie!");
            }
        }

//		// Replace what's below with your implementation
//		io.println("+----+-------+-------+-------+-------+-------+-------+----+");
//		io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
//		io.println("|    |-------+-------+-------+-------+-------+-------|    |");
//		io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
//		io.println("+----+-------+-------+-------+-------+-------+-------+----+");
//		io.println("Player 1's turn - Specify house number or 'q' to quit: ");
	}
}
