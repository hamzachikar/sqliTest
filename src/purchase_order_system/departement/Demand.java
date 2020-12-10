package purchase_order_system.departement;

import purchase_order_system.departement.observer_budget.IBudget;

public class Demand implements IDemand{
    private IBudget budgetObs;
    private double demandAmount;
    private String state;
    public Demand(IBudget budgetObs,double demandAmount){
        this.budgetObs=budgetObs;
        this.demandAmount=demandAmount;
    }
    @Override
    public void changeState(String state){
        this.state=this.budgetObs.update(state,this.demandAmount);
    }

    @Override
    public boolean checkBudget() {
        if(demandAmount<budgetObs.getBudget()){
            return true;
        }
        return false;
    }

    @Override
    public String getState() {
        return this.state;
    }

}
