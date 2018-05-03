package kalah.model;

import kalah.util.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pit> houses;
    private Store store;

    public Player(String name) {
        this.name = name;
        houses = new ArrayList<Pit>();
        for (int i = 0; i < Game.HOUSES_PER_PLAYER; i++) {
            houses.add(new House(Game.SEEDS_PER_PIT, i+1)); //4, id
        }
        store = new Store();
        houses.add(new Store());
    }

    public int popAt(int position) {
        Pit h = houses.get(position - 1);
        int originalSeeds = h.getSeeds();
        h.emptySeeds();
        return originalSeeds;
    }
    public House houseAt(int position) throws InvalidMoveException {
        Pit house = houses.get(position-1);
        if (house instanceof House) {
            return (House)house;
        }
        throw new InvalidMoveException("This is not a valid house.");
    }

    public List<Pit> getHouses() {
        return houses;
    }


    public int getTotalSeeds() {
        int totalSeeds = 0;
        for (Pit h: houses) {
            if (h instanceof House) {
                totalSeeds += h.getSeeds();
            }
        }
        return totalSeeds;
    }

    public int getScore() {
        return getTotalSeeds() + store.getSeeds();
    }

    public boolean hasNoMovesLeft() {
        return getTotalSeeds() == 0;
    }

    public Store getStore() {
        return store;
    }

    public String getName() {
        return name;
    }


}
