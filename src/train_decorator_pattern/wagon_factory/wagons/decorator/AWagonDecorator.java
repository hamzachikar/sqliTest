package train_decorator_pattern.wagon_factory.wagons.decorator;


import train_decorator_pattern.wagon_factory.wagons.Wagon;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.Cargo;
import static train_decorator_pattern.config.Configuration.EMPTY_CARGO;

public abstract class AWagonDecorator implements Wagon {
    private Wagon decoratedWagon=null;
    private String wagonString;
    public AWagonDecorator(Wagon decoratedWagon,String wagonString){
        this.wagonString=wagonString;
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
            if(wagon.getDecoratedWagon().getWagonString().equalsIgnoreCase(EMPTY_CARGO)){
                return true;
            }
            else{
                return this.findOtherEmptyCargo(wagon.getDecoratedWagon());
            }
         }
         return false;

    }

    protected void setLoadedWagon(String wagonString){
        this.wagonString=wagonString;
    }
    @Override
    public String getWagonString(){
        return this.wagonString;
    }
}
