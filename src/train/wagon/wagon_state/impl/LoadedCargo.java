package train.wagon.wagon_state.impl;

import train.wagon.wagon_state.CargoState;
import static train.config.Configuration.LOADED_CARGO;

public class LoadedCargo implements CargoState {
    @Override
    public String print() {
        return LOADED_CARGO;
    }
}
