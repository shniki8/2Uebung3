package p1;

public class Cell implements Locatable{
    private boolean alive;
    private boolean nextAlive;
    private int row=0, col=0;
    private Cell north, south, west, east; //lazy, I know. Not even an init.
    private Board board;
    private Rule rule;

    public Cell(int row,int col,Board board){
        this.row = row;
        this.col = col;
        this.board = board;

    }
    public Cell(int row, int col, Board board, Rule rule){
        this.row = row;
        this.col = col;
        this.board = board;
        this.rule = rule;
    }
    public void setRule(Rule r){
        rule = r;
    }
    private int countLivingNeighbours(){
        int count = 0; // haha die Lesbarkeit ist ja super wenn ich alles inline mache
        if (this.getNorth()!=this) if (this.getNorth().isAlive()) count++;
        if (this.getSouth()!=this) if (this.getSouth().isAlive()) count++;
        if (this.getEast()!=this) if (this.getEast().isAlive()) count++;
        if (this.getWest()!=this) if (this.getWest().isAlive()) count++;
        return count;
    }
    public void computeNextAlive(){
        int u = countLivingNeighbours();
        nextAlive = rule.computeNextState(this.isAlive(),u);
    }
    public void updateAlive(){
        alive = nextAlive;
    }
    public void setAlive(boolean a){
        alive = a;
    }

    public boolean isAlive(){ //check vital signs
        return alive;
    }

    public void printCell(){
        if(alive) System.out.print(1 + " "); else System.out.print(0 + " ");
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
