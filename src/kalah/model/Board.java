package kalah.model;

public interface Board {
    public int size();
    public Pit getPit(int position);
    public Pit getOppositePit(int position);
    public Pit getStore(int Player);
}
