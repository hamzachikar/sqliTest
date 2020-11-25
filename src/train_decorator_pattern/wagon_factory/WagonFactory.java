package train_decorator_pattern.wagon_factory;

import train_decorator_pattern.wagon_factory.wagons.Wagon;

public interface WagonFactory {
    public Wagon getWagon(String wagonProp,Wagon wagon);
}
