package train_decorator_pattern.service_train.impl;

import train_decorator_pattern.service_train.TrainConstructService;

import train_decorator_pattern.wagon_factory.WagonFactory;
import train_decorator_pattern.wagon_factory.WagonFactoryController;
import train_decorator_pattern.wagon_factory.wagons.Wagon;

public class TrainConstructServiceImpl implements TrainConstructService {
    private Wagon wagon;
    public TrainConstructServiceImpl(){
    }
    @Override
    public void constructTheTrainWagons(String[] train) {
        WagonFactory wagonFactory=new WagonFactoryController();
        Wagon wagon=null;
        if(train[0].equalsIgnoreCase("H")){
            wagon=wagonFactory.getWagon("LH",null);
        }
        for(int i=1;i<train.length;i++){
            wagon=wagonFactory.getWagon(train[i],wagon);
        }
        this.wagon=wagon;
    }

    @Override
    public void detatchEnd() {
        this.wagon=this.wagon.detatchEnd();
    }

    @Override
    public void detatchHead() {
        this.wagon=this.wagon.detatchHead();
    }

    @Override
    public boolean fill() {
      return this.wagon.fill();
    }

    @Override
    public String print() {
        return this.wagon.print();
    }
}
