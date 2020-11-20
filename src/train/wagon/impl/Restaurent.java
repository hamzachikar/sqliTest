package train.wagon.impl;

import train.wagon.Wagon;
import static train.config.Configuration.RESTAURENT;
public class Restaurent implements Wagon {

    @Override
    public String print() {
        return RESTAURENT;
    }
}
