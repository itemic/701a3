package kalah.model;

import java.util.List;

public class Game {
    public static final int SEEDS_PER_PIT = 4;
    public static final int HOUSES_PER_PLAYER = 6;

    private Board board;
    private Player turn;
    private Player player1;
    private Player player2;

    public Game(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
        turn = p1;
    }

    public Player getTurn() {
        return turn;
    }

    public void makeMove(int position) throws InvalidMoveException { // position is 1-6

        Player currentPlayer = getTurn();
        Player otherPlayer = getTurn().equals(player1) ? player2 : player1;
        int seedsToDistribute = currentPlayer.popAt(position);

        if (seedsToDistribute == 0) {throw new InvalidMoveException("House is empty. Move again.");}

        int iterationPosition = position+1;
        Player iterationPlayer = currentPlayer;
        while(seedsToDistribute > 0) {
            if (iterationPosition <= 6) {
                iterationPlayer.houseAt(iterationPosition).addSeeds(1);
                iterationPosition++;
                seedsToDistribute--;
            } else if (iterationPosition == 7) {
                if (iterationPlayer.equals(currentPlayer)) {
                    // add to store
                    currentPlayer.getStore().addSeeds(1);
                    iterationPosition = 1;
                    iterationPlayer = otherPlayer;
                    seedsToDistribute--;
                } else {
                    // dont add to store
                    iterationPosition = 1;
                    iterationPlayer = currentPlayer;
                }
            }
        }
        iterationPosition--;
        if (iterationPosition == 0) {iterationPosition = 7;}

        boolean endingOnHouse = (iterationPosition < 7 && iterationPosition > 0 && currentPlayer.houseAt(iterationPosition).getSeeds() == 1);

        // at this point iterationPlayer and iterationPosition can help us deal with capture
        if (iterationPlayer.equals(currentPlayer) && endingOnHouse && otherPlayer.houseAt(getAcross(iterationPosition)).getSeeds() > 0) {
            //CAPTURE!
            int seedsToPop = currentPlayer.popAt(iterationPosition);
            currentPlayer.getStore().addSeeds(seedsToPop);

            int opponentsPop = otherPlayer.popAt(getAcross(iterationPosition));
            currentPlayer.getStore().addSeeds(opponentsPop);
        }

        if (iterationPosition == 7) {

        } else {
            turn = otherPlayer; // change turns
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getAcross(int position) {
        return Math.abs((HOUSES_PER_PLAYER + 1) - position);
    }
}
