package train_decorator_pattern.main_class;

import train_decorator_pattern.service_train.TrainConstructService;
import train_decorator_pattern.service_train.impl.TrainConstructServiceImpl;
import train_decorator_pattern.wagon_factory.wagons.Wagon;

public class Train {

    TrainConstructService trainConstructService;
    public Train(String train){
        String[] trainWagon=train.split("");
        this.trainConstructService=new TrainConstructServiceImpl();
        this.trainConstructService.constructTheTrainWagons(trainWagon);
    }
    public String print(){
        return trainConstructService.print();
    }

    public void detachEnd() {
        this.trainConstructService.detatchEnd();
    }

    public void detachHead() {
        this.trainConstructService.detatchHead();
    }

    public boolean fill() {
        return this.trainConstructService.fill();
    }
}
