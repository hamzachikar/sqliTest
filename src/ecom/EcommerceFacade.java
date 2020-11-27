package ecom;


import ecom.items.item_service.ItemService;
import ecom.items.item_service.controller.ItemServiceController;

import java.util.ArrayList;
import java.util.List;


public class EcommerceFacade {
    private ItemService itemService;
    public EcommerceFacade(){
        this.itemService=new ItemServiceController();
    }

    public void addMachine(String name, int quantity, int priceUnit){
        this.itemService.addMachine(name,quantity,priceUnit);
    }

    public void addCapsule(String name, int quantity, int priceUnit) {
        this.itemService.addCapsule(name,quantity,priceUnit);
    }

    public void removeMachine(String nameItem, int quantity) {
        this.itemService.removeMachine(nameItem,quantity);
    }

    public void removeCapsule(String nameItem, int quantity) {
        this.itemService.removeCapsule(nameItem,quantity);
    }

    public String cartContent() {
        return this.itemService.cartContent("content");
    }

    public String summary() {
        return this.itemService.cartContent("summary");
    }

    public void order() {
        this.itemService.order();
    }

    public boolean hasErrors() {
       return this.itemService.hasErrors();
    }

    public String errors() {
        return this.itemService.errors();
    }

    public void voucher(String code) {
        this.itemService.voucher(code);
    }
}
