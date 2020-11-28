package train_decorator_pattern.wagon_factory.wagons.decorator.extend;

import train_decorator_pattern.wagon_factory.wagons.Wagon;
import train_decorator_pattern.wagon_factory.wagons.decorator.AWagonDecorator;

import static train_decorator_pattern.config.Configuration.PASSENGER;
import static train_decorator_pattern.config.Configuration.CONNECT;
public class Passenger extends AWagonDecorator{
    public Passenger(Wagon decoratedWagon,String wagonString) {
        super(decoratedWagon,wagonString);
    }
    @Override
    public String print() {
        if(super.getDecoratedWagon()==null){
            return PASSENGER;
        }
        return super.print()+CONNECT+PASSENGER;
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
