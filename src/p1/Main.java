package p1;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ClassInfo c = new ClassInfo(new Cell(0,0,null));
        System.out.println(c.getClassName());
        c = new ClassInfo(new ArrayDeque<>());
        System.out.println(c.isInSamePackage(new Board(1,1)));

        Board board = new Board(16,16);
        //Test Code D:
        Cell[][] grid = board.getGrid();

        grid[3][3].setAlive(true);
        grid[8][8].setAlive(true);
        grid[0][0].setAlive(true);

        //board.printBoard();
        Queue<Cell> q = new LinkedList<Cell>();
        Queue<Cell> q2 = new ArrayDeque<Cell>(); //Funktioniert, da ArrayDeque Queue implementiert und ich auf keine spezifischen Methoden von LinkedList bzw. ArrayDeque zugegriffen habe, sondern lediglich auf die Methoden vom Interface Queue.
        q2 = board.getAlive();
        //board.spreadLife(q2);

        Board board2 = new Board(16,16, new ConwayRule());
        //Test Code D:
        Cell[][] grid2 = board2.getGrid();

        grid2[3][3].setAlive(true);
        grid2[8][8].setAlive(true);
        grid2[0][0].setAlive(true);
        q = board2.getAlive();
        board2.spreadLife(q);
        board2.nextGeneration();
        board2.printBoard();
        //Seems to work.
    }
}
