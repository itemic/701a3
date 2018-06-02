package kalah.model;

import java.util.ArrayList;
import java.util.List;

public class KalahBoard implements Board {
    private List<Pit> pits;

    public KalahBoard() {
        pits = new ArrayList<Pit>() {
            @Override
            public Pit get(int index) {
                return super.get(index % this.size());
            }
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j< 6; j++) {
                pits.add(new House(4, i+1));
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
        return pits.get(-position + 2 * 6);
    }

    public Pit getStore(int player) {
        if (player == 1) {
            return pits.get(6);
        } else {
            return pits.get(6*2 + 1);
        }
    }
}
