package purchase_order_system.po_services;

import purchase_order_system.departement.IDemand;

public abstract class ServiceAbstract {
    private String service;
    protected ServiceAbstract nextService;
    public ServiceAbstract(String service){
        this.service=service;
    }
    public ServiceAbstract(String service,ServiceAbstract nextService){
        this.service=service;
        this.nextService=nextService;
    }

    public abstract void requestDemand(IDemand demand);
}
