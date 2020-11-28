package train_decorator_pattern.wagon_factory.wagons.decorator.extend;


import train_decorator_pattern.wagon_factory.wagons.decorator.AWagonDecorator;
import train_decorator_pattern.wagon_factory.wagons.Wagon;

import static train_decorator_pattern.config.Configuration.*;

public class Cargo extends AWagonDecorator {
    public Cargo(Wagon decoratedWagon,String wagonString) {
        super(decoratedWagon,wagonString);
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
    @Override
    public String print() {
        if(super.getDecoratedWagon()==null){
            return super.getWagonString() ;
        }
        return super.print()+CONNECT+super.getWagonString();
    }
    @Override
    public boolean fill(){
        if(super.getWagonString().equalsIgnoreCase(EMPTY_CARGO)){
            if(findOtherEmptyCargo(this)){
                return this.getDecoratedWagon().fill();
            }
            else{
                super.setLoadedWagon(LOADED_CARGO);
                return true;
            }
        }
        return false;
    }
}
