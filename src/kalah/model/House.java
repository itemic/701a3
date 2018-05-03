package kalah.model;

public class House extends Pit {
    private int seeds;
    private int id;
    public House(int seeds) {
        super(seeds);
    }

    public House(int seeds, int id) {
        super(seeds);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getAcross() {
        return Math.abs((Game.HOUSES_PER_PLAYER + 1 )- id); 
    }
}
