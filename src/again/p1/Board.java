package again.p1;

import java.util.LinkedList;
import java.util.Queue;

public class Board {
    Cell[][] grid;
    int rows, cols;
    public Board(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        grid = new Cell[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Cell(i,j,this);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Cell current = grid[i][j];
                if (current!= null){
                    /*
                    // ICH KANN DAS NICHT SO MACHEN HAHA
                    // (aber es würde gehen)
                    current.setNeighbors(grid[i][j],grid[i][j],grid[i][j],grid[i][j]);
                    // Jetzt wird mit dem Feuer gespielt >:)
                    try {
                        //Norden
                        current.setNeighbors(grid[i-1][j],grid[i][j].getSouth(),grid[i][j].getEast(),grid[i][j].getWest());
                    } catch (Exception e) {}
                    try {
                        //Süden
                        current.setNeighbors(grid[i][j].getNorth(),grid[i+1][j],grid[i][j].getEast(),grid[i][j].getWest());
                    } catch (Exception e) {}
                    try {
                        //Westen
                        current.setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i][j-1],grid[i][j].getWest());
                    } catch (Exception e) {}
                    try {
                        //Osten
                        current.setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i][j].getEast(),grid[i][j+1]);
                    } catch (Exception e) {}
                    */
                    //Besser wäre:
                    Cell north, south, east, west;
                    if(i == 0){
                        north = current;
                    }else north = grid[i-1][j];
                    if (i == grid.length-1) {
                        south = current;
                    } else south = grid[i+1][j];
                    if (j == 0){
                        west = current;
                    } else west = grid[i][j-1];
                    if (j == grid[0].length-1){
                        east = current;
                    } else east = grid[i][j+1];
                    current.setNeighbors(north,south,east,west);
                }
            }
        }
    }
    public int spreadLife(Queue<Cell> startCells){
        if (startCells.isEmpty()) return -1;
        int steps = 1;
        if (allAlive()) return steps;
        for (Cell c : startCells){
            c.setAlive(true);
        }
        Queue<Cell> q = new LinkedList<>();
        while(!allAlive()){
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j].isAlive()){
                        q.offer(grid[i][j]);
                    }
                }
            }
            while(!q.isEmpty()){
                Cell current = q.peek();
                current.getNorth().setAlive(true);
                current.getSouth().setAlive(true);
                current.getEast().setAlive(true);
                current.getWest().setAlive(true);
            }
            steps++;
        }
        return steps;
    }

    public boolean allAlive(){
        boolean b = true;
        outer:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!grid[i][j].isAlive()){
                    b = false;
                    break outer;
                }
            }
        }
        return b;
    }
    public void printBoard(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int b = grid[i][j].isAlive() ? 1 : 0;
                System.out.print(" ["+b+ "] ");
            }
            System.out.println();
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

