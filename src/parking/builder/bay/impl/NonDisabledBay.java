package parking.builder.bay.impl;
import parking.builder.bay.Bay;

import static parking.Config.NON_DISABLED_EMPTY;
public class NonDisabledBay implements Bay {
    private char nonDisabledBayState=NON_DISABLED_EMPTY;

    @Override
    public char print() {
        return this.nonDisabledBayState;
    }
    public char getState() {
        return this.nonDisabledBayState;
    }

    public NonDisabledBay setNotEmptyState(char c){
        this.nonDisabledBayState=c;
        return this;
    }
    public NonDisabledBay setEmptyState(){
        this.nonDisabledBayState=NON_DISABLED_EMPTY;
        return this;
    }
}
