package p1;

public class Cell implements Locatable{
    private boolean alive;
    private int row=0, col=0;
    private Cell north, south, west, east; //lazy, I know. Not even an init.
    private Board board;

    public Cell(int row,int col,Board board){




    }
    public void setAlive(boolean a){
        alive = a;
    }

    public boolean isAlive(){ //check vital signs
        return alive;
    }

    public void printCell(){
        if(alive) System.out.println(1); else System.out.println(0);
    }

    @Override
    public Cell getNorth() {
        return north;
    }

    @Override
    public Cell getSouth() {
        return south;
    }

    @Override
    public Cell getEast() {
        return east;
    }

    @Override
    public Cell getWest() {
        return west;
    }

    @Override
    public void setNeighbors(Cell north, Cell south, Cell east, Cell west) {
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }
    public boolean isCorner(){
       if ((getNorth() == this && getWest() == this) || (getNorth() == this && getEast() == this) || (getSouth() == this && getWest() == this) || (getSouth() == this && getEast() == this) ){
           return true;
       }
       return  false;
    }
    public boolean isEdge(){
        if (getNorth() == this || getSouth() == this || getWest() == this || getEast() == this){
            return true;
        }
        return false;
    }
}
