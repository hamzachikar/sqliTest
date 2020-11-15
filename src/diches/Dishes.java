package diches;

import java.util.ArrayList;
import java.util.List;

public class Dishes {
    List<Dishe> dishes=new ArrayList();
    Satelites satelites=Satelites.getSatelites();
    class Dishe{
        int id;
        String degree;
        public Dishe(){}
        public Dishe(String prop){
            this.id=Integer.valueOf(prop.split(",")[0]);
            this.degree=prop.split(",")[1];
        }
    }

    public Dishes(){
    }
    public Dishes(String ... signalProps){
        this.dishes=new ArrayList<>();
        for(String prop:signalProps){
            this.dishes.add(new Dishe(prop));
        }
    }
    String signal(String signalT){
        String sat=signalT.replace(" ", "").split(",")[1];
        String direction=this.satelites.satelites.get(sat).split("°")[1];
        Double angle=Double.valueOf(this.satelites.satelites.get(sat).split("°")[0]);
        List<String> signals=this.getSignalsDishes(angle,direction);
        return this.getBestSignal(signals);
    }
    List<String> getSignalsDishes(Double angle,String direction) {
        List<String> signals = new ArrayList<>();
        for (Dishe dishe : this.dishes) {
            String signal = "|";
            //System.out.println(dishe.degree.endsWith(direction));
            Double diff = Math.abs(Double.valueOf(angle - Double.valueOf(dishe.degree.substring(0, dishe.degree.length() - 1))));
            if (dishe.degree.endsWith(direction)&&diff >= 1) {
                signal = "No signal !";
               // System.out.println("+++++++ no");
            }
            if(dishe.degree.endsWith(direction)&&diff < 1){

                    for (int i = 1; i <= 10; i++) {
                        if (i <= 10 - (int) (diff * 10.0 + 0.1)) {
                            signal = signal + "*";
                        } else {
                            signal = signal + ".";
                        }
                    //    System.out.println(signal);
                    }
                    signal = signal + "|";
            }
            else {
                signal = "No signal !";
                //System.out.println("-------");

            }
            System.out.println(signal);
            signals.add(signal);
        }
        return signals;
    }

    String getBestSignal(List<String> signals){
        String bstSig="No signal !";
        for(String signal:signals){
           bstSig=this.compareSignalWithAll(signals,signal);
        }
        return bstSig;
    }
    String compareSignalWithAll(List<String>signals,String signal){
        String bstSig=signal;
        for(String sig:signals){
            if(!sig.equals(signal)){
                for(int i=1;i<signal.length()-1;i++){
                    if(sig.split("")[i].equals("*")&&signal.split("")[i].equals(".")) {
                        bstSig= sig;
                    }
                }
            }
        }
    return bstSig;
    }
    void move(String idDishe,String degree){
        int id=Integer.valueOf(idDishe);
        for(Dishe d:this.dishes){
            if(d.id==id){
                d=this.changeDisheDegree(d,degree);
                break;
            }
        }
    }
    Dishe changeDisheDegree(Dishe dishe,String degree){
        char direction=degree.charAt(degree.length()-1);
        Double newDegree=0.0;
        if(dishe.degree.charAt(dishe.degree.length()-1)==direction){
            newDegree=Double.valueOf(dishe.degree.substring(0, dishe.degree.length() - 1))+Double.valueOf(degree.substring(0, degree.length() - 1));
            System.out.println(Double.valueOf(degree.substring(0, degree.length() - 1))+"----------");
        }
        else{
            newDegree=Double.valueOf(dishe.degree.substring(0, dishe.degree.length() - 1))-Double.valueOf(degree.substring(0, degree.length() - 1));
            System.out.println(Double.valueOf(degree.substring(0, degree.length() - 1))+"+++++++");
        }
        if(newDegree<0){
            newDegree=Math.abs(newDegree);
            dishe.degree=newDegree+""+direction;
        }
        else{
            dishe.degree=newDegree+""+dishe.degree.charAt(dishe.degree.length()-1);
        }

        System.out.println(dishe.degree);
        return dishe;
    }
}
