package train.wagon.impl;

import train.wagon.Wagon;
import train.wagon.wagon_state.CargoState;
import train.wagon.wagon_state.impl.EmptyCargo;
import train.wagon.wagon_state.impl.LoadedCargo;

import static  train.config.Configuration.LOADED_CARGO;
import static  train.config.Configuration.EMPTY_CARGO;
public class Cargo implements Wagon {
    private CargoState cargo =new EmptyCargo();

    @Override
    public String print() {
        return this.cargo.print();
    }
    public CargoState getState(){
        return this.cargo;
    }
    public void fill(){
        this.cargo=new LoadedCargo();
    }
    public void empty(){
        this.cargo=new EmptyCargo();
    }
}
