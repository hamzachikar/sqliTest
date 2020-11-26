package diches.diche.siches_service;


import diches.diche.diche_factory.Diche;
import diches.diche.diche_factory.DicheFactory;
import diches.diche.diche_factory.controller.DicheFactoryController;

import java.util.HashMap;
import java.util.Map;

public class DichesServiceController implements DichesService{
    Map<String, Diche> diches;
    DicheFactory dicheFactory;
    public DichesServiceController(String[] dichesProps){
        this.diches=new HashMap<>();
        this.dicheFactory=new DicheFactoryController();
        for(String prop:dichesProps){
            Diche diche=this.dicheFactory.getDiche(prop);
            this.diches.put(diche.getId(),diche);
        }
    }

    @Override
    public String signal(String signal) {
        String sig="No signal !";

        for(Diche diche:this.diches.values()){
            sig=this.compareSignals(sig,diche.signal(signal));
        }
        return sig;
    }

    @Override
    public void move(String idDiche, String degreeProp) {
        this.diches.get(idDiche).move(degreeProp);
    }

    private String compareSignals(String signal1,String signal2) {
        if(signal1.equalsIgnoreCase("No signal !")){
            return signal2;
        }
        else if(signal2.equalsIgnoreCase("No signal !")){
            return signal1;
        }
        else{
            String[] sig1=signal1.split("");
            String[]sig2=signal2.split("");
            for(int i=0;i<signal1.length();i++){
                if(sig1[i].equalsIgnoreCase(sig2[i])){
                    if(sig1[i].equalsIgnoreCase("*")){
                        return signal1;
                    }
                    else{
                        return signal2;
                    }
                }
            }
        }
    return null;
    }
}

