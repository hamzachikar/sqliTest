package purchase_order_system.departement;

public interface IDemand {
    public void changeState(String state);
    public boolean checkBudget();

    String getState();
}
