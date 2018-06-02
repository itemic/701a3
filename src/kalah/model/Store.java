package kalah.model;

public class Store extends Pit {

    public Store(int player) {
        super(0, player);
    }

    @Override
    public void addSeeds(int seeds, int player) {
        if (player == getPitOwner()) {
            super.addSeeds(seeds, player);
        }
    }

    @Override
    public boolean didDropSeeds(int player) {
        return player == getPitOwner();
    }

    @Override
    public boolean canMoveAgain(int player) {
        return player == getPitOwner();
    }
}
