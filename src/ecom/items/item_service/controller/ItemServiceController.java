package ecom.items.item_service.controller;

import ecom.items.item.factory.ItemFactory;
import ecom.items.item.factory.ItemFactoryController;
import ecom.items.item.factory.factory_item.Item;
import ecom.items.item_service.ItemService;
import ecom.items.item_service.controller.exceptions_controller.ExceptionService;
import ecom.items.item_service.controller.exceptions_controller.ExceptionServiceController;
import ecom.items.item_service.controller.functions.FunctionService;
import ecom.items.item_service.controller.functions.FunctionServiceController;

import java.util.*;

public class ItemServiceController implements ItemService {
    private Map<String,Item> machines;
    private Map<String,Item> capsules;
    private FunctionService functionService;
    private ExceptionService exceptionService;
    public ItemServiceController(){
        this.capsules=new TreeMap<>();
        this.machines=new TreeMap<>();
        this.functionService= FunctionServiceController.getInstance();
        this.exceptionService= new ExceptionServiceController();
    }

    @Override
    public void addMachine(String name, int quantity, int priceUnit) {
        this.functionService.checkAndAddItem(name,quantity,priceUnit,this.machines);
    }
    @Override
    public void addCapsule(String name, int quantity, int priceUnit) {
       this.functionService.checkAndAddItem(name,quantity,priceUnit,this.capsules);
    }
    @Override
    public void removeMachine(String nameItem, int quantity) {
        this.functionService.removeItem(nameItem,quantity,this.machines);
    }
    @Override
    public void removeCapsule(String nameItem, int quantity) {
        this.functionService.removeItem(nameItem,quantity,this.capsules);
    }

    @Override
    public String cartContent(String option) {
        String cart="";
        if(this.capsules.size()!=0){
            cart=cart+"Capsule\n"+this.functionService.toStringContentItems(this.capsules,option);
        }
        if(this.machines.size()!=0){
            cart=cart+"Machine\n"+this.functionService.toStringContentItems(this.machines,option);
        }
        if(option.equalsIgnoreCase("summary")){
            cart=cart+"Total Price: "+this.functionService.getTotalPrice()+"\n";
        }
        return cart;
    }

    @Override
    public void order() {
        this.exceptionService.order(this.machines,this.capsules);
    }

    @Override
    public boolean hasErrors() {
        return this.exceptionService.hasErrors();
    }

    @Override
    public String errors() {
        return this.exceptionService.errors();
    }

    @Override
    public void voucher(String code) {
        this.exceptionService.voucher(code);
    }


}
