package train_decorator_pattern.wagon_factory.wagons.decorator;



import train.wagon.wagon_state.impl.EmptyCargo;
import train_decorator_pattern.wagon_factory.wagons.Wagon;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.Cargo;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state.state.EmptyCargoState;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.wagon_state.state.FullCargoState;

public abstract class AWagonDecorator implements Wagon {
    private Wagon decoratedWagon=null;
    public AWagonDecorator(Wagon decoratedWagon){
        this.decoratedWagon=decoratedWagon;
    }
    public String print(){
        return this.decoratedWagon.print();
    }

    public void detachLastWagons(){
        if(this.decoratedWagon.getDecoratedWagon()==null){
            this.decoratedWagon=null;
        }
        else{
            this.decoratedWagon.detatchHead();
        }
    }
    public Wagon getDecoratedWagon(){
        return this.decoratedWagon;
    }

    @Override
    public boolean fill() {
      return this.decoratedWagon.fill();
    }
    public boolean findOtherEmptyCargo(Wagon wagon){
         if(wagon!=null&&wagon.getDecoratedWagon()!=null){
             System.out.println(wagon.print());
            if(wagon.getDecoratedWagon() instanceof Cargo){
                System.out.println("Founded");
                if(((Cargo)(wagon.getDecoratedWagon())).getCargoStateController().getCargoState() instanceof EmptyCargoState){
                    return true;
                }
                else {
                    return false;
                }
            }
            else{
                System.out.println("other");
                return this.findOtherEmptyCargo(wagon.getDecoratedWagon());
            }
        }
        return false;
    }
}
