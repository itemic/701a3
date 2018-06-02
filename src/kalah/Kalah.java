package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
import kalah.model.Board;
import kalah.model.KalahBoard;
import kalah.model.Game;
import kalah.model.KalahGame;
import kalah.util.InvalidMoveException;
import kalah.util.KalahIO;

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
        Board board64 = new KalahBoard();
        Game game = new KalahGame(board64);

        boolean gameHasEnded = false;
        int userInput;

        while (!gameHasEnded) {
            kio.printBoard(board64);
            userInput = kio.printPrompt(game);
            if (userInput == -1) {break;}
            try {
                game.makeMove(userInput);
            } catch (InvalidMoveException e) {
                io.println("House is empty. Move again.");
            }
            if (game.hasEnded()) {
                gameHasEnded = true;
                kio.printBoard(board64);
            }
        }

        kio.printEnd();
        kio.printBoard(board64);

        if (gameHasEnded) {
            io.println("\tplayer 1:" + game.getScore(1));
            io.println("\tplayer 2:" + game.getScore(2));

            if (game.getScore(1) > game.getScore(2)) {
                io.println("Player 1 wins!");
            } else if (game.getScore(1) < game.getScore(2)) {
                io.println("Player 2 wins!");
            } else {
                io.println("A tie!");
            }
        }
	}
}
