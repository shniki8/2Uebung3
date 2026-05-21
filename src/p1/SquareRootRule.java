package p1;

public class SquareRootRule implements Rule{
    @Override
    public void printRuleName() {
        System.out.println("Square Root Rule"); //eigentlich unwahr, die Bedingung ist ob die 2te Wurzel als Ganzzahl gerade ist..
    }

    @Override
    public boolean computeNextState(boolean currentState, int input) {
        return ((int)(Math.sqrt(input)) % 2 == 0);
    }
}
