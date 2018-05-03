package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
import kalah.model.Game;
import kalah.util.InvalidMoveException;
import kalah.util.KalahIO;
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

        boolean gameHasEnded = false;
        int userInput = -1;

        while (!gameHasEnded) {
            kio.printBoard(game);
            userInput = kio.printPrompt(game);
            if (userInput == -1) {break;}
            try {
                game.makeMove(userInput);
            } catch (InvalidMoveException e) {
                io.println("House is empty. Move again.");
            }
            if (game.hasEnded()) {
                gameHasEnded = true;
                kio.printBoard(game);
            }
        }

        kio.printEnd();
        kio.printBoard(game);

        if (gameHasEnded) {
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
	}
}
