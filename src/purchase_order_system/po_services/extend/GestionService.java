package purchase_order_system.po_services.extend;

import purchase_order_system.departement.IDemand;
import purchase_order_system.po_services.ServiceAbstract;

public class GestionService extends ServiceAbstract {
    public GestionService(String service) {
        super(service);
    }
    @Override
    public void requestDemand(IDemand demand) {
        demand.changeState("IN PROGRESS");
    }
}
