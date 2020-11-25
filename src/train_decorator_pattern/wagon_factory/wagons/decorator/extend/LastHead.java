package train_decorator_pattern.wagon_factory.wagons.decorator.extend;


import train_decorator_pattern.wagon_factory.wagons.Wagon;
import train_decorator_pattern.wagon_factory.wagons.decorator.AWagonDecorator;

import static train_decorator_pattern.config.Configuration.LAST_WAGON;
public class LastHead extends AWagonDecorator {

    public LastHead(Wagon decoratedWagon) {
        super(decoratedWagon);
    }

    @Override
    public String print() {
        return LAST_WAGON;
    }

    @Override
    public Wagon detatchEnd() {
        return super.getDecoratedWagon();
    }

    @Override
    public Wagon detatchHead() {
        super.detachLastWagons();
        return this;
    }

}
