package train_decorator_pattern.service_train;

import train_decorator_pattern.wagon_factory.wagons.Wagon;

public interface TrainConstructService {
    void constructTheTrainWagons(String[] train);

    void detatchEnd();

    void detatchHead();

    boolean fill();

    String print();
}
