package kalah.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<House> houses;
    private Store store;

    public Player() {
        houses = new ArrayList<House>();
        for (int i = 0; i < Game.HOUSES_PER_PLAYER; i++) {
            houses.add(new House(Game.SEEDS_PER_PIT, i+1)); //4, id
        }
        store = new Store(0);
    }

    public int seedsAt(int position) { // 1-6
        return houses.get(position - 1).getSeeds();
    }

    public List<House> getHouses() {
        return houses;
    }

    public Store getStore() {
        return store;
    }
}
