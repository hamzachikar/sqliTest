package diches.diche.states_controller.states;

import diches.config.SatelliteConfig;
import diches.diche.states_controller.DicheState;
import diches.diche.states_controller.state_factory.StateFactoryController;

public abstract class ADicheState implements DicheState {
    protected float degree;
    public ADicheState(String degree){
        this.degree=Float.valueOf(degree.substring(0,degree.length()-1));
    }
    protected String printSignal(float diffSignal) {
        String signal="|";
        System.out.println(diffSignal);
        for (int i = 1; i <= 10; i++) {
            if (i <= 10 - (int) (diffSignal * 10.0 + 0.1)) {
                signal = signal + "*";
            } else {
                signal = signal + ".";
            }
            //    System.out.println(signal);
        }
        signal = signal + "|";
        System.out.println(signal);
        return signal;
    }
    public DicheState move(String degreeProps){
        float newDegree=degree-Float.valueOf(degreeProps.substring(0,degreeProps.length()-1));
        if(newDegree<0.0){
            return this.chageDirection(Math.abs(newDegree),degreeProps.substring(degreeProps.length()-1));
        }
        degree=newDegree;
        return this;
    }
    protected DicheState chageDirection(float degree, String direction){
        return StateFactoryController.getDicheState(degree+""+direction);
    };
}
