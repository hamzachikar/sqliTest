package train.wagon.impl;

import train.wagon.Wagon;
import static  train.config.Configuration.PASSENGER;
public class Passenger implements Wagon {

    @Override
    public String print() {
        return PASSENGER;
    }
}
