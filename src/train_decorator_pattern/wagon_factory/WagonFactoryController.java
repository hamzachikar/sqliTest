package train_decorator_pattern.wagon_factory;

import train_decorator_pattern.wagon_factory.wagons.decorator.extend.Cargo;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.FirstHead;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.Passenger;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.Restaurent;
import train_decorator_pattern.wagon_factory.wagons.*;
import train_decorator_pattern.wagon_factory.wagons.decorator.extend.LastHead;

public class WagonFactoryController implements WagonFactory{
    public Wagon getWagon(String wagonProp,Wagon wagon){
        switch (wagonProp){
            case "LH":
                return new LastHead(wagon);
            case "H":
                return new FirstHead(wagon);
            case "P":
                return new Passenger(wagon);
            case "R":
                return new Restaurent(wagon);
            case "C":
                return new Cargo(wagon);
            default:
                return null;
        }
    }
}
