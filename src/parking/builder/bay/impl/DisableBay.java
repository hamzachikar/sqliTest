package parking.builder.bay.impl;

import parking.builder.bay.Bay;

import static parking.Config.DISABLED_ONLY_EMPTY;
import static parking.Config.DISABLED_ONLY_FULL;
public class DisableBay implements Bay {
    private char disabledBayState=DISABLED_ONLY_EMPTY;
    @Override
    public char print(){
        return this.disabledBayState;
    }

    public char getState() {
        return this.disabledBayState;
    }

    public DisableBay setNotEmptyState(){
        this.disabledBayState=DISABLED_ONLY_FULL;
        return this;
    }
    public DisableBay setEmptyState(){
        this.disabledBayState=DISABLED_ONLY_EMPTY;
        return this;
    }
}
