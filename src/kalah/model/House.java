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


}
