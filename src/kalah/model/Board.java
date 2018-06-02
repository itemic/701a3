package kalah.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pit> pits;

    public Board() {
        pits = new ArrayList<Pit>() {
            @Override
            public Pit get(int index) {
                return super.get(index % this.size());
            }
        };

        for (int i = 0; i < 2; i++) {
            for (int j= 0; j< Game.HOUSES_PER_PLAYER; j++) {
                pits.add(new House(Game.SEEDS_PER_PIT, i+1));
            }
            pits.add(new Store(i+1));
        }
    }

    public int size() {
        return pits.size();
    }
    public Pit getPit(int position) {
        return pits.get(position);
    }

    public Pit getOppositePit(int position) {
        return pits.get(-position + 12); // hardcode for now!
    }

    public Pit getStore(int player) { // hardcode for now!
        if (player == 1) {
            return pits.get(6);
        } else {
            return pits.get(13);
        }
    }
}
