package kalah.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<House> houses;
    private Store store;

    public Player(String name) {
        this.name = name;
        houses = new ArrayList<House>();
        for (int i = 0; i < Game.HOUSES_PER_PLAYER; i++) {
            houses.add(new House(Game.SEEDS_PER_PIT, i+1)); //4, id
        }
        store = new Store(0);
    }

    public int popAt(int position) {
        House h = houses.get(position - 1);
        int originalSeeds = h.getSeeds();
        h.emptySeeds();
        return originalSeeds;
    }
    public House houseAt(int position) {return houses.get(position-1);}

    public int seedsAt(int position) { // 1-6
        return houses.get(position - 1).getSeeds();
    }

    public List<House> getHouses() {
        return houses;
    }

    public int getTotalSeeds() {
        int totalSeeds = 0;
        for (House h: houses) {
            totalSeeds += h.getSeeds();
        }
        return totalSeeds;
    }

    public int getScore() {
        return getTotalSeeds() + store.getSeeds();
    }

    public boolean isOver() {
        return getTotalSeeds() == 0;
    }

    public Store getStore() {
        return store;
    }

    public String getName() {
        return name;
    }


}
