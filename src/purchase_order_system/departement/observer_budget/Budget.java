package purchase_order_system.departement.observer_budget;

public class Budget  implements IBudget{
    private double budget;
    private double blockedAmount;
    public Budget(double budget,double blockedAmount){
        this.budget=budget;
        this.blockedAmount=blockedAmount;
    }
    @Override
    public String update(String state,double demandAmount) {
        switch (state){
            case "APPROVED":
                this.blockedAmount=demandAmount;
                return state;
            case "IN PROGRESS":
                this.budget=this.budget-this.blockedAmount;
                this.blockedAmount=0;
                return "RESOLVED";
            default:
                return state;
        }
    }

    @Override
    public double getBudget() {
        return this.budget;
    }
}
