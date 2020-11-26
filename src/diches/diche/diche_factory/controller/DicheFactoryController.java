package diches.diche.diche_factory.controller;

import diches.diche.diche_factory.Diche;
import diches.diche.diche_factory.DicheFactory;

public class DicheFactoryController implements DicheFactory {
     public Diche getDiche(String dicheProp){
        return new Diche(dicheProp);
    }
}
