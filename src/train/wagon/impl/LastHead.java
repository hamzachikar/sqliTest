package train.wagon.impl;

import train.wagon.Wagon;
import static train.config.Configuration.LAST_WAGON;


public class LastHead implements Wagon {
    @Override
    public String print() {
        return LAST_WAGON;
    }
}
