package kalah.model;

public abstract class Pit {

    private int seeds;

    public Pit(int seeds) {
        this.seeds = seeds;
    }

    public void addSeeds(int seeds) {
        this.seeds += seeds;
    }

    public void emptySeeds() {
        this.seeds = 0;
    }

    public int getSeeds() {
        return seeds;
    }
}
