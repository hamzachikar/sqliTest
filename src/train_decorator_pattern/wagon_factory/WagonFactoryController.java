package train_decorator_pattern.wagon_factory;

import train_decorator_pattern.wagon_factory.wagons.decorator.extend.Cargo;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.FirstHead;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.Passenger;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.Restaurent;
import train_decorator_pattern.wagon_factory.wagons.*;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.LastHead;
import static train_decorator_pattern.config.Configuration.*;

public class WagonFactoryController implements WagonFactory{
    public Wagon getWagon(String wagonProp,Wagon wagon){
        switch (wagonProp){
            case "LH":
                return new LastHead(wagon,LAST_WAGON);
            case "H":
                return new FirstHead(wagon,FIRST_WAGON);
            case "P":
                return new Passenger(wagon,PASSENGER);
            case "R":
                return new Restaurent(wagon,RESTAURENT);
            case "C":
                return new Cargo(wagon,EMPTY_CARGO);
            default:
                return null;
        }
    }
}
