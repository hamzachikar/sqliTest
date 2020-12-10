package purchase_order_system.po_services.extend;

import purchase_order_system.departement.IDemand;
import purchase_order_system.po_services.ServiceAbstract;

public class ComptableService extends ServiceAbstract {
    public ComptableService(String service, ServiceAbstract nextService) {
        super(service, nextService);
    }

    @Override
    public void requestDemand(IDemand demand) {
        if(demand.checkBudget()){
            demand.changeState("APPROVED");
            super.nextService.requestDemand(demand);
        }
        else{
            demand.changeState("DISAPROVED");
        }
    }
}
