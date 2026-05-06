package p1;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(16,16);
        //Test Code D:
        Cell[][] grid = board.getGrid();

        grid[3][3].setAlive(true);
        grid[8][8].setAlive(true);

        //board.printBoard();
        Queue<Cell> q = new LinkedList<Cell>();
        Queue<Cell> q2 = new ArrayDeque<Cell>(); //Funktioniert, da ArrayDeque Queue implementiert und ich auf keine spezifischen Methoden von LinkedList bzw. ArrayDeque zugegriffen habe, sondern lediglich auf die Methoden vom Interface Queue.
        q2 = board.getAlive();
        board.spreadLife(q2);
    }
}
