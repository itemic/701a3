package kalah.model;

public class Game {
    public static final int SEEDS_PER_PIT = 4;
    public static final int PLAYER_COUNT = 2;
    public static final int HOUSES_PER_PLAYER = 6;

    private Board board;

    public Game(Board board) {
        this.board = board;
    }
}
