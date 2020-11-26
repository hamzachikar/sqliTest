package diches.diche.states_controller;

public interface DicheState {
    DicheState move(String degree);
    String signal(String signal);
}
