package again.p1;

public class Cell implements Locatable{
    private boolean alive;
    private int row, col;
    Cell north, south, east, west;
    Board board;

    public Cell(int row, int col, Board board){
        this.row = row;
        this.col = col;
        this.board = board;
    }

    public boolean isEdge(){
        if (north == this || south == this || east == this || west == this){
            return true;
        }else return false;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isCorner(){
        int count = 0;
        if (north == this){
            count++;
        }
        if (south == this) {
            count++;
        }
        if (east == this){
            count++;
        }
        if (west == this) {
            count++;
        }
        return (count>=2); // Besteht das board aus nur einem Elem ist es auch eine Ecke und count wäre 4.
    }


    public void setNeighbors(Cell north, Cell south, Cell east, Cell west){
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

    public void printCell(){
        System.out.println(alive ? 1 : 0);
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public Cell getNorth() {
        return null;
    }

    @Override
    public Cell getSouth() {
        return null;
    }

    @Override
    public Cell getEast() {
        return null;
    }

    @Override
    public Cell getWest() {
        return null;
    }
}
