package p1;

public class RandomRule implements Rule{ //Commit name: "Added gambling."
    @Override
    public void printRuleName() {
        System.out.println("Random Rule");
    }

    @Override
    public boolean computeNextState(boolean currentState, int input) {
        if ((int)(Math.random()*101) %2 == 0) return false; else return true;
    }
}
