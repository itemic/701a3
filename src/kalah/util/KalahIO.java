package kalah.util;
import com.qualitascorpus.testsupport.IO;
import kalah.model.Board;
import kalah.model.KalahBoard;
import kalah.model.Game;


public class KalahIO {
    private IO io;

    public KalahIO(IO io) {
        this.io = io;
    }



    public void printBoard(Board board) {
        StringBuilder sb = new StringBuilder();
        sb.append("+----+-------+-------+-------+-------+-------+-------+----+");
        io.println(sb.toString());
        /////////////////
        sb = new StringBuilder();
        sb.append("| P2 ");

        for (int i = 6; i > 0; i--) {
            sb.append(String.format("|%2d[%2d] ", i, board.getPit(i+6).getSeeds()));

        }


        sb.append(String.format("| %2d |", board.getPit(6).getSeeds()));
        io.println(sb.toString());
/////////////////
        sb = new StringBuilder();
        sb.append("|    |-------+-------+-------+-------+-------+-------|    |");
        io.println(sb.toString());
/////////////////
        sb = new StringBuilder();
        sb.append(String.format("| %2d ", board.getPit(13).getSeeds()));
        for (int i = 1; i < 7; i++) {
            sb.append(String.format("|%2d[%2d] ", i, board.getPit(i-1).getSeeds()));
        }
        sb.append("| P1 |");
        io.println(sb.toString());
/////////////////
        sb = new StringBuilder();
        sb.append("+----+-------+-------+-------+-------+-------+-------+----+");
        io.println(sb.toString());
    }


    public int printPrompt(Game g) {

        return io.readInteger("Player P"+ g.getTurn() + "'s turn - Specify house number or 'q' to quit: ", 1, 6, -1, "q");
    }

    public void printEnd() {
        io.println("Game over");
    }


}
