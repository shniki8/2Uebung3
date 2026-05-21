package p1;

public class ToggleRule implements Rule{
    private String ruleName ="Toggle Rule";

    @Override
    public void printRuleName() {
        System.out.println(this.ruleName);
    }
    @Override
    public boolean computeNextState(boolean currentState, int input){
        return !currentState;
    }
}

