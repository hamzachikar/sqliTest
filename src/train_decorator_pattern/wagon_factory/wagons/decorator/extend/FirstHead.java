package train_decorator_pattern.wagon_factory.wagons.decorator.extend;

import train_decorator_pattern.wagon_factory.wagons.Wagon;
import train_decorator_pattern.wagon_factory.wagons.decorator.AWagonDecorator;

import static train_decorator_pattern.config.Configuration.FIRST_WAGON;
import static train_decorator_pattern.config.Configuration.CONNECT;
public class FirstHead extends AWagonDecorator {
    public FirstHead(Wagon decoratedWagon) {
        super(decoratedWagon);
    }
    @Override
    public String print() {
        if(super.getDecoratedWagon()==null){
            return FIRST_WAGON;
        }
        return super.print()+CONNECT+FIRST_WAGON;
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
