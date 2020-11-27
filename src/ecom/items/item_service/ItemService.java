package ecom.items.item_service;

public interface ItemService {
    void addMachine(String name, int quantity, int priceUnit);
    void addCapsule(String name, int quantity, int priceUnit);
    void removeMachine(String nameItem, int quantity);
    void removeCapsule(String nameItem, int quantity);
    String cartContent(String option);
    void order();
    boolean hasErrors();
    String errors();
    void voucher(String code);
}
