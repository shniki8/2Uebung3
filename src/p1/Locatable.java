package p1;

public interface Locatable {
    public Cell getNorth();
    public Cell getSouth();
    public Cell getWest();
    public Cell getEast();

    public void setNeighbors(Cell north, Cell south, Cell east, Cell west);

}
