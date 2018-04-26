package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
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

	    Player p = new Player();

	    kio.printBoardEdge();
	    kio.printPlayerTwo();
	    kio.printDivider();
	    kio.printPlayerOne(p);
	    kio.printBoardEdge();
	    kio.printPrompt();
//		// Replace what's below with your implementation
//		io.println("+----+-------+-------+-------+-------+-------+-------+----+");
//		io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
//		io.println("|    |-------+-------+-------+-------+-------+-------|    |");
//		io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
//		io.println("+----+-------+-------+-------+-------+-------+-------+----+");
//		io.println("Player 1's turn - Specify house number or 'q' to quit: ");
	}
}
