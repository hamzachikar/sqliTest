package ecom.items.item.factory;

import ecom.items.item.factory.factory_item.Item;

public interface ItemFactory {
    Item getItem(String name, int quantity, int priceUnite);
}
