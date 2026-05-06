package p1;

import java.util.LinkedList;
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


                // please dont look at this graveyard of code. Alas, the location was the Problem. Took Hours.
                /*
                if (i == 0 && j == 0 && i+1 <= grid.length && j+1 <= grid[0].length){
                    grid[i][j].setNeighbors(grid[i][j], grid[i][j+1], grid[i+1][j], grid[i][j]);
                } else if (i != 0 && j == 0) {

                } else if (i == 0 && j != 0){

                } else if (i == grid.length) {

                }

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


                    if (i == 0 && j == 0){
                        if(i<grid.length && j <grid[0].length){
                            grid[i][j].setNeighbors(grid[i][j],grid[i][j+1],grid[i][j],grid[i+1][j]);
                        }
                        else if(i+1 == grid.length && j+1 == grid[0].length){
                            grid[i][j].setNeighbors(grid[i][j],grid[i][j],grid[i][j],grid[i][j]);
                        }
                    } else if (i == 0 && j != 0) {
                        if (j < grid[0].length && i< grid.length) {
                            grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j],grid[i+1][j]);
                        }
                    }
                    else if (i != 0 && j == 0){
                        if (j < grid[0].length && i< grid.length) {
                            grid[i][j].setNeighbors(grid[i][j],grid[i][j+1],grid[i][j],grid[i+1][j]);
                        }
                    }


                    grid[i][j].setNeighbors(grid[i][j],grid[i][j],grid[i][j],grid[i][j]);
                    if (i != 0 && i<grid.length){
                        grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i+1][j],grid[i-1][j]);
                    }else{
                        if(i == 0){
                            grid[i][j].setNeighbors(grid[i][j],grid[i][j],grid[i][j],grid[i][j]);
                        }
                        else{

                        }
                    }
                    if (j != 0 && j<grid[0].length){
                        grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j].getEast(),grid[i][j].getWest());
                    }


                    */




            }
        } // end of 2nd for loop :D

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i >0){
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i][j].getEast(),grid[i-1][j]);
                }
                if (i == 0){
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i][j].getEast(),grid[i][j]);
                }
                if(i == grid.length-1){
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i][j],grid[i][j].getWest());
                }
                if(i < grid.length-1){
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j].getSouth(),grid[i+1][j],grid[i][j].getWest());
                }
                if(j>0){
                    grid[i][j].setNeighbors(grid[i][j-1],grid[i][j].getSouth(),grid[i][j].getEast(),grid[i][j].getWest());
                }
                if (j == 0) {
                    grid[i][j].setNeighbors(grid[i][j],grid[i][j].getSouth(),grid[i][j].getEast(),grid[i][j].getWest());
                }
                if(j == grid[0].length-1){
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j],grid[i][j].getEast(),grid[i][j].getWest());
                }
                if(j < grid[0].length-1){
                    grid[i][j].setNeighbors(grid[i][j].getNorth(),grid[i][j+1],grid[i][j].getEast(),grid[i][j].getWest());
                }

                if (i != 0 && i != grid.length-1 && j != 0 && j!= grid[0].length-1){
                    grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i+1][j],grid[i-1][j]);
                }

            }
        }
        //System.out.println("Hello World!");

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
                grid[i][j].printCell();
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
        if (startCells.isEmpty()){
            System.out.println("Queue is empty!");
            return 0;
        }
        if (allAlive()){
            printBoard();
            return 1;

        }
        int count = 1;
        while(!startCells.isEmpty()){
            startCells.element().setAlive(true); // Hoffentlich call by reference
            startCells.remove();
        }
        Queue<Cell> l;
        while(!allAlive()){
            l = getAlive();
            while(!l.isEmpty()){
                if (l.element()!= null) {
                    //System.out.println("C? " + l.element().isCorner() + " E? " + l.element().isEdge());
                    l.element().getNorth().setAlive(true);
                    l.element().getSouth().setAlive(true);
                    l.element().getWest().setAlive(true);
                    l.element().getEast().setAlive(true);
                    l.remove();
                }
            }
            printBoard();
            System.out.println();
            count++;
        }
        //Life prevails!
      return count;
    }





    public Queue<Cell> getAlive(){
        Queue<Cell> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].isAlive()){
                    q.add(grid[i][j]);
                }
            }
        }
        return q;
    }

}
