package kalah.model;

import kalah.util.InvalidMoveException;

public class KalahGame implements Game{

    private Board board;

    private int currentTurn = 1;

    public KalahGame(Board board) {
         this.board = board;
    }

    public int getTurn() {
        return currentTurn;
    }
    public void switchTurns() {
        currentTurn = currentTurn == 1 ?  2 :  1;
    }



    public void makeMove(int position) throws InvalidMoveException { // position is 1-6

        int seedsPosition = getTurn() == 1 ? position - 1 : position + 6;
        int seedsToDistribute = board.getPit(seedsPosition).popSeeds();

        if (seedsToDistribute == 0) {throw new InvalidMoveException("House is empty. Move again.");}

        int iter = seedsPosition+1;

        while (seedsToDistribute > 0) {
            board.getPit(iter).addSeeds(1, currentTurn);
            if(board.getPit(iter).didDropSeeds(currentTurn)) {
                seedsToDistribute--;
            }
            iter++;
        }

        // now we check if we are on our house


        iter--;

        // Even if we have circular list we still want to reset
        iter = iter % board.size();
        if (board.getPit(iter).isOwnedByPlayer(currentTurn) && board.getPit(iter) instanceof House) {
            if (board.getOppositePit(iter).getSeeds() > 0 && board.getPit(iter).getSeeds() == 1) {
                // CAPTURE!
                board.getStore(currentTurn).addSeeds(board.getPit(iter).popSeeds());
                board.getStore(currentTurn).addSeeds(board.getOppositePit(iter).popSeeds());
            }
        }

        if (!board.getPit(iter).canMoveAgain(currentTurn)) {
            switchTurns(); // change turns
        }
    }

    public boolean hasEnded() {
        boolean allEmpty = true;
        if (currentTurn == 1) {
            for (int i = 0; i < 6; i++) {
                allEmpty = allEmpty && board.getPit(i).getSeeds() == 0;
            }
        } else {
            for (int i = 7; i < 13; i++) {
                allEmpty = allEmpty && board.getPit(i).getSeeds() == 0;
            }
        }
        return allEmpty;
    }

    public int getScore(int player) {
        int score = 0;
        if (player == 1) {
            for (int i = 0; i < 7; i++) {
                score += board.getPit(i).getSeeds();
            }
        } else {
            for (int i = 7; i < 14; i++) {
                score += board.getPit(i).getSeeds();
            }
        }
        return score;
    }





}
