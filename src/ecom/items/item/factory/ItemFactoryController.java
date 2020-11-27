package ecom.items.item.factory;

import ecom.items.item.factory.factory_item.Item;

public class ItemFactoryController implements ItemFactory {

    private static ItemFactoryController itemFactoryController=new ItemFactoryController();
    private ItemFactoryController(){}

    public static ItemFactory getInstance(){
        return itemFactoryController;
    }

    @Override
    public Item getItem(String name, int quantity, int priceUnite) {
        return new Item(name,quantity,priceUnite);
    }
}
