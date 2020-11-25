package train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state.state;

import train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state.ICargoState;
import static train_decorator_pattern.config.Configuration.LOADED_CARGO;
public class FullCargoState implements ICargoState {
    @Override
    public String print() {
        return LOADED_CARGO;
    }
}
