package diches;


import diches.diche.siches_service.DichesService;
import diches.diche.siches_service.DichesServiceController;

public class Dishes {
    private DichesService dichesService;
    public Dishes(String ... diches){
        this.dichesService=new DichesServiceController(diches);
    }

    public String signal(String signal) {
        return this.dichesService.signal(signal);
    }

    public void move(String idDiche, String degreeProp) {
        this.dichesService.move(idDiche,degreeProp);
    }
}
