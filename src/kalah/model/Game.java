package kalah.model;

import kalah.util.InvalidMoveException;

public interface Game {

    int getTurn();
    void switchTurns();
    void makeMove(int position) throws InvalidMoveException;
    boolean hasEnded();
    int getScore(int player);


}
