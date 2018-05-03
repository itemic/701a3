package kalah.model;

import kalah.util.InvalidMoveException;

import java.util.List;

public class Game {
    public static final int SEEDS_PER_PIT = 4;
    public static final int HOUSES_PER_PLAYER = 6;

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

        int iter = position+1;
        Player iterPlayer = currentPlayer;

        while(seedsToDistribute > 0) {
            if (iter <= 6) {
                iterPlayer.houseAt(iter).addSeeds(1);
                iter++;
                seedsToDistribute--;
            } else if (iter == HOUSES_PER_PLAYER+1) {
                if (iterPlayer.equals(currentPlayer)) {
                    // add to store
                    currentPlayer.getStore().addSeeds(1);
                    iter = 1;
                    iterPlayer = otherPlayer;
                    seedsToDistribute--;
                } else {
                    // dont add to store
                    iter = 1;
                    iterPlayer = currentPlayer;
                }
            }
        }
        iter--;
        if (iter == 0) {iter = HOUSES_PER_PLAYER+1;}

        boolean endingOnHouse = (iter < HOUSES_PER_PLAYER+1 && currentPlayer.houseAt(iter).getSeeds() == 1);

        // at this point iterationPlayer and iter can help us deal with capture
        if (iterPlayer.equals(currentPlayer) && endingOnHouse && otherPlayer.houseAt(getAcross(iter)).getSeeds() > 0) {
            //CAPTURE!
            int seedsToPop = currentPlayer.popAt(iter);
            currentPlayer.getStore().addSeeds(seedsToPop);

            int opponentsPop = otherPlayer.popAt(getAcross(iter));
            currentPlayer.getStore().addSeeds(opponentsPop);
        }

        if (iter != HOUSES_PER_PLAYER+1) {
            turn = otherPlayer; // change turns
        }
    }

    public boolean hasEnded() {
        return getTurn().hasNoMovesLeft();
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
