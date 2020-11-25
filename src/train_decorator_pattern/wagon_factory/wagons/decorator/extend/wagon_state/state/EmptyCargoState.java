package train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state.state;

import train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state.ICargoState;
import static train_decorator_pattern.config.Configuration.EMPTY_CARGO;
public class EmptyCargoState implements ICargoState {
    @Override
    public String print() {
        return EMPTY_CARGO;
    }
}
