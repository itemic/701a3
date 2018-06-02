package kalah.model;

public abstract class Pit {

    private int seeds;
    private int player;

    public Pit(int seeds, int player) {
        this.seeds = seeds;
        this.player = player;
    }

    protected void addSeeds(int seeds) {
        this.seeds += seeds;
    }

    public void addSeeds(int seeds, int player) {
        addSeeds(seeds);
    }

    public int getPitOwner() {
        return player;
    }

    public void emptySeeds() {
        this.seeds = 0;
    }

    public int getSeeds() {
        return seeds;
    }

    public int popSeeds() {
        int returnValue = seeds;
        seeds = 0;
        return returnValue;
    }



    public boolean isOwnedByPlayer(int player) {
        return player == this.player;
    }

    public boolean didDropSeeds(int player) {
        return true;
    }

    public boolean canMoveAgain(int player) {
        return false;
    }
}
