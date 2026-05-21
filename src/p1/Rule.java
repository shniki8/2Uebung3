package p1;

public interface Rule {
    boolean computeNextState(boolean currentState, int input);
    void printRuleName();
}
