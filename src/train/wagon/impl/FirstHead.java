package train.wagon.impl;

import train.wagon.Wagon;
import static train.config.Configuration.FIRST_WAGON;
public class FirstHead implements Wagon {
    @Override
    public String print() {
        return FIRST_WAGON;
    }
}
