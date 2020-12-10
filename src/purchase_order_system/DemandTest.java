package purchase_order_system;

import org.junit.Test;
import purchase_order_system.departement.Demand;
import purchase_order_system.departement.IDemand;
import purchase_order_system.departement.observer_budget.Budget;
import purchase_order_system.departement.observer_budget.IBudget;
import purchase_order_system.po_services.ServiceAbstract;
import purchase_order_system.po_services.extend.ComptableService;
import purchase_order_system.po_services.extend.GestionService;

import static org.junit.Assert.assertEquals;

public class DemandTest {
    @Test
    public void testCaseApprovedDemand(){
        ServiceAbstract comptableService=new ComptableService("comptable",new GestionService("gestion"));
        IBudget budget=new Budget(10000.0,0.0);
        IDemand demand=new Demand(budget,9000.0);
        comptableService.requestDemand(demand);
        assertEquals("RESOLVED",demand.getState());
    }
    @Test
    public void testCaseDisapprovedDemand(){
        ServiceAbstract comptableService=new ComptableService("comptable",new GestionService("gestion"));
        IBudget budget=new Budget(8000.0,0.0);
        IDemand demand=new Demand(budget,9000.0);
        comptableService.requestDemand(demand);
        assertEquals("DISAPROVED",demand.getState());
    }
}
