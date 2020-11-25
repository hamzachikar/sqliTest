package train_decorator_pattern.wagon_factory.wagons.decorator.extend;


import train_decorator_pattern.wagon_factory.wagons.decorator.AWagonDecorator;
import train_decorator_pattern.wagon_factory.wagons.Wagon;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state.CargoStateController;
import static train_decorator_pattern.config.Configuration.CONNECT;
public class Cargo extends AWagonDecorator {
    private CargoStateController cargoStateController;
    public Cargo(Wagon decoratedWagon) {
        super(decoratedWagon);
        this.cargoStateController=new CargoStateController();
    }
    public CargoStateController getCargoStateController(){
        return this.cargoStateController;
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
            return this.cargoStateController.print();
        }
        return super.print()+CONNECT+this.cargoStateController.print();
    }
    @Override
    public boolean fill(){
        if(findOtherEmptyCargo(this)){
            return this.getDecoratedWagon().fill();
        }
        else{
            return this.cargoStateController.fill();
        }
    }
    public void empty(){
        this.cargoStateController.empty();
    }
}
