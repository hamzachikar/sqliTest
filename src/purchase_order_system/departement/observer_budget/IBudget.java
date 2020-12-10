package purchase_order_system.departement.observer_budget;

public interface IBudget {
    public String update(String state,double demandAmount);
    public double getBudget();
}
