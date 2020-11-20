package train.wagon.wagon_state.impl;

import train.wagon.wagon_state.CargoState;
import static train.config.Configuration.EMPTY_CARGO;
public class EmptyCargo implements CargoState {
    @Override
    public String print() {
        return EMPTY_CARGO;
    }
}
