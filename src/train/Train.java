package train;

import train.wagon.Wagon;
import train.wagon.WagonFactory;
import train.wagon.impl.*;

import java.util.ArrayList;
import java.util.List;
import static train.config.Configuration.CONNECT;
public class Train {
    List<Wagon> wagons=new ArrayList<>();
    WagonFactory wagonFactory=new WagonFactory();
    public Train(String train){
        String[]wagons=train.split("");
        for(int i=0;i<wagons.length;i++){
            if(i==0&&wagons[i].equalsIgnoreCase("H")){
                this.addWagon('h');
            }
            else if(i==wagons.length-1&&wagons[i].equalsIgnoreCase("H")){
                this.addWagon('H');
            }
            else{
                this.addWagon(wagons[i].charAt(0));
            }
        }
    }

    private void addWagon(char wagon) {
        this.wagons.add(this.wagonFactory.getWagon(wagon));
    }
    public String print(){
        String train="";
        for(Wagon wagon:this.wagons){
            train+=wagon.print();
            if(this.wagons.indexOf(wagon)!=this.wagons.size()-1){
                train+=CONNECT;
            }

        }

        return train;
    }

    public void detachEnd() {
        this.wagons.remove(this.wagons.size()-1);
    }

    public void detachHead() {
        this.wagons.remove(0);
    }

    public boolean fill() {
        for(Wagon wagon:this.wagons){
            if(wagon.getClass()==Cargo.class){
                if(!((Cargo) wagon).getState()) {
                    ((Cargo) wagon).fill();
                    return true;
                }
            }
        }
        return false;
    }
}
