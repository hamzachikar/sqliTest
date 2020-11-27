package ecom.items.item.factory.factory_item;

public class Item {
    private String name;
    private int quantity;
    private int priceUnite;
    public Item(String name, int quantity, int priceUnite){
        this.name=name;
        this.quantity=quantity;
        this.priceUnite=priceUnite;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceUnite() {
        return priceUnite;
    }

    public void setPriceUnite(int priceUnite) {
        this.priceUnite = priceUnite;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
