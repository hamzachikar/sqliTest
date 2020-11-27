package ecom.items.item_service.controller.functions;

import ecom.items.item.factory.factory_item.Item;

import java.util.Map;

public interface FunctionService  {
    void removeItem(String nameItem, int quantity, Map<String, Item> items);
    void checkAndAddItem(String name, int quantity, int priceUnit, Map<String,Item> items);
    String toStringContentItems(Map<String, Item>items,String option);

    int getTotalPrice();
}
