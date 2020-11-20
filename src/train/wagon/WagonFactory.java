package train.wagon;

import train.wagon.impl.*;

public class WagonFactory {
    public WagonFactory(){}
    public Wagon getWagon(char wagon){
        Wagon wag=null;
        switch (wagon){
            case 'h':
                wag= new LastHead();
                break;
            case 'H':
                wag= new FirstHead();
                break;
            case 'P':
                wag= new Passenger();
                break;
            case 'R':
                wag= new Restaurent();
                break;
            case 'C':
                wag= new Cargo();
                break;
        }
        return wag;
    }
}
