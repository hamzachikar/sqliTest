package diches.diche.diche_factory;


import diches.diche.states_controller.DicheState;
import diches.diche.states_controller.state_factory.StateFactoryController;

public class Diche {
    private String id;
    private DicheState dicheState;
    public Diche(String dicheProp){
        String[] props=dicheProp.split(",");
        this.id=props[0];
        this.dicheState= StateFactoryController.getDicheState(props[1]);
    }

    public String getId() {
        return id;
    }

    public String signal(String signal) {

        return this.dicheState.signal(signal);
    }

    public void move(String degreeProp) {
        this.dicheState=this.dicheState.move(degreeProp);
    }
}
