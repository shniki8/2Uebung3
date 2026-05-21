package p1;

public class ConwayRule implements Rule{ //The Game of Life tm
    @Override
    public void printRuleName() {
        System.out.println("Conway Rule");
    }

    @Override
    public boolean computeNextState(boolean currentState, int input) {
        if (currentState == true){
            return input == 2 || input == 3;
        } else return input == 3;
    }
}
