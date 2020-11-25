package train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state;


import train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state.state.EmptyCargoState;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state.state.FullCargoState;

public class CargoStateController {
    private ICargoState cargoState;
    public CargoStateController(){
        this.cargoState=new EmptyCargoState();
    }
    public ICargoState getCargoState(){
        return this.cargoState;
    }
    public boolean fill(){
        if(this.cargoState instanceof EmptyCargoState){
            this.cargoState=new FullCargoState();
            System.out.println("fill");
            return true;
        }
        return false;
    }
    public void empty(){
        this.cargoState=new EmptyCargoState();
    }

    public String print() {
        return this.cargoState.print();
    }
}
