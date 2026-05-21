package p1;

public class PowerRule implements Rule{
    @Override
    public void printRuleName() {
        System.out.println("Power Rule");
    }

    @Override
    public boolean computeNextState(boolean currentState, int input) {
        for (int i = 0; i <= input; i++) {
            input = input*input;
        }
        return (input>1000);
    }
}
