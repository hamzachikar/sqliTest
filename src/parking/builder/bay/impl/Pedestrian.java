package parking.builder.bay.impl;
import parking.builder.bay.Bay;

import static parking.Config.PEDESTRIAN_EXIT;
public class Pedestrian implements Bay {
    @Override
    public char print(){
        return PEDESTRIAN_EXIT;
    }
}
