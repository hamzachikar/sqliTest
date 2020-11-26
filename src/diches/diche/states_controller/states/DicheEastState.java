package diches.diche.states_controller.states;

import diches.config.SatelliteConfig;
import diches.diche.states_controller.DicheState;

public class DicheEastState extends ADicheState {

    public DicheEastState(String degree){
        super(degree);
    }

    @Override
    public DicheState move(String degreeProps) {
        if(degreeProps.endsWith("E")){
            return super.addDegreeDiche(degreeProps);
        }
        else{
            return super.move(degreeProps);
        }
    }

    @Override
    public String signal(String signal) {
        String satellite= SatelliteConfig.getSatellite(signal.split(" ")[1]);
        if(satellite.endsWith("E")){
            float diffSignal=Math.abs(super.degree-Float.valueOf(satellite.substring(0,satellite.length()-1)));
            if(diffSignal>1){
                return "No signal !";
            }
            else{
                return super.printSignal(diffSignal);
            }
        }
        else{
            return "No signal !";
        }
    }


}
