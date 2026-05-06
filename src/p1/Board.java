package p1;

import java.util.Queue;

public class Board {
    private Cell[][] grid;
    private int rows, cols;

    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        grid = new Cell[this.rows][this.cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                grid[i][j] = new Cell(i,j,this);
                /*
                if (i == 0 && j == 0 && i+1 <= grid.length && j+1 <= grid[0].length){
                    grid[i][j].setNeighbors(grid[i][j], grid[i][j+1], grid[i+1][j], grid[i][j]);
                } else if (i != 0 && j == 0) {

                } else if (i == 0 && j != 0){

                } else if (i == grid.length) {

                }
                */
                // oder lieber so?
                if (i == 0){
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i][j].getEast(),grid[i][j]);
                } else if (i == grid.length-1){ //10 Min Fehler gesucht weil AuD mir antrainiert hat das Arrays bei 1 starten und nicht wie hier bei 0
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i][j],grid[i][j].getWest());
                }
                else {
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i-1][j],grid[i+1][j]);
                }

                if (j == 0){
                    grid[i][j].setNeighbors(grid[i][j],grid[i][j].getSouth(),grid[i][j].getEast(),grid[i][j].getWest());
                }
                else if (j == grid[0].length-1){
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j],grid[i][j].getEast(),grid[i][j].getWest());
                }
                else{
                    grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j].getEast(),grid[i][j].getWest());
                }
            }
        } // end of 2nd for loop :D
        System.out.println("Hello World!");

    }

    public boolean allAlive(){
        boolean b = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!grid[i][j].isAlive()){b = false; break;}
            }
            if (!b) {break;}
        }
        return b;
    }

    public void printBoard(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }
    public Cell[][] getGrid(){
        return grid;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int spreadLife(Queue<Cell> startCells){
        int count = 0;
        while(!startCells.isEmpty()){
            startCells.element().setAlive(true); // Hoffentlich call by reference
            startCells.remove();
        }
        while(!allAlive()){

        }
        printBoard();
      return count;
    }

}
