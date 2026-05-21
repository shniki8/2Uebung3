package p1;

public class ParityRule implements Rule{
    @Override
    public void printRuleName() {
        System.out.println("Parity Rule");
    }

    @Override
    public boolean computeNextState(boolean currentState, int input) {
        if (input%2 == 0) return true;
        else return false;

    }

}
