package train.wagon.impl;

import train.wagon.Wagon;
import static  train.config.Configuration.LOADED_CARGO;
import static  train.config.Configuration.EMPTY_CARGO;
public class Cargo implements Wagon {
    private String gargo=EMPTY_CARGO;
    private boolean loaded=false;

    @Override
    public String print() {
        return this.gargo;
    }
    public boolean getState(){
        return this.loaded;
    }
    public void fill(){
        this.gargo=LOADED_CARGO;
        this.loaded=true;
    }
    public void empty(){
        this.gargo=EMPTY_CARGO;
        this.loaded=false;
    }
}
