package kalah.model;
import com.qualitascorpus.testsupport.IO;


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

    public void printPlayerOne(Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        sb.append(player.getStore().getSeeds());
        sb.append("  ");
        for (House house: player.getHouses()) {
            sb.append("| "+ house.getId() +"[ " + house.getSeeds() + "] ");
        }
        sb.append("| P1 |");
        io.println(sb.toString());
    }

    public void printPrompt() {
        io.readInteger("Player 1's turn - Specify house number or 'q' to quit: ", 1, 6, -1, "q");
    }
}
