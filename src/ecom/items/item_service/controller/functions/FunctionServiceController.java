package ecom.items.item_service.controller.functions;

import ecom.items.item.factory.ItemFactory;
import ecom.items.item.factory.ItemFactoryController;
import ecom.items.item.factory.factory_item.Item;

import java.util.Map;

public class FunctionServiceController implements FunctionService{
    private ItemFactory itemFactory;
    private int totalPriceItem=0;
    private static FunctionServiceController instance=new FunctionServiceController();
    private FunctionServiceController(){
        this.itemFactory=ItemFactoryController.getInstance();
    }
    @Override
    public void removeItem(String nameItem, int quantity, Map<String, Item> items) {
        Item item=items.get(nameItem);
        if(item!=null){
            if(item.getQuantity()-quantity>0){
                item.setQuantity(item.getQuantity()-quantity);
            }
            else{
                items.remove(nameItem);
            }
        }
    }

    @Override
    public void checkAndAddItem(String name, int quantity, int priceUnit, Map<String, Item> items) {
        Item item=items.get(name);
        if(item==null){
            items.put(name,itemFactory.getItem(name,quantity,priceUnit));
        }
        else{
            item.setQuantity(item.getQuantity()+quantity);
        }
    }

    @Override
    public String toStringContentItems(Map<String, Item> items, String option) {
        String cart="";
        switch (option){
            case "content":
                for(Item item:items.values()){
                    cart=cart+"\tName: "+item.getName()+"\tQuantity: "+item.getQuantity()+"\tPrice: "+(item.getQuantity()*item.getPriceUnite())+"\n";
                }
                break;
            case "summary":
                int quantity=0;
                int price=0;
                for(Item item:items.values()){
                    quantity=quantity+item.getQuantity();
                    price=price+(item.getQuantity()*item.getPriceUnite());
                }
                cart=cart+"\tQuantity: "+quantity+"\tPrice: "+price+"\n";
                this.totalPriceItem=this.totalPriceItem+price;
        }

        return cart;
    }

    @Override
    public int getTotalPrice() {
        return this.totalPriceItem;
    }

    public static FunctionService getInstance() {
        return instance;
    }
}
