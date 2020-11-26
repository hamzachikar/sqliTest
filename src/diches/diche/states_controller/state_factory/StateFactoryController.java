package diches.diche.states_controller.state_factory;

import diches.diche.states_controller.DicheState;
import diches.diche.states_controller.states.DicheEastState;
import diches.diche.states_controller.states.DicheWestState;

public class StateFactoryController {
    public static DicheState getDicheState(String degree){
        if(degree.endsWith("E")){
            return new DicheEastState(degree);
        }
        else if(degree.endsWith("W")){
            return new DicheWestState(degree);
        }
        return null;
    }
}
