package train_decorator_pattern.wagon_factory.wagons.decorator.extend;

import train_decorator_pattern.wagon_factory.wagons.Wagon;
import train_decorator_pattern.wagon_factory.wagons.decorator.AWagonDecorator;

import static train_decorator_pattern.config.Configuration.CONNECT;
import static train_decorator_pattern.config.Configuration.RESTAURENT;
public class Restaurent extends AWagonDecorator{
    public Restaurent(Wagon decoratedWagon,String wagonString) {
        super(decoratedWagon,wagonString);
    }

    @Override
    public String print() {
        if(super.getDecoratedWagon()==null){
            return RESTAURENT;
        }
        return super.print()+CONNECT+RESTAURENT;
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
