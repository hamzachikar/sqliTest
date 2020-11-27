package ecom.items.item_service.controller.exceptions_controller;

import ecom.items.item.factory.factory_item.Item;
import ecom.items.item_service.controller.exceptions_controller.exceptions.ExceptionFactory;
import ecom.items.item_service.controller.exceptions_controller.exceptions.OrderException;

import java.util.Map;

public class ExceptionServiceController implements ExceptionService {
    private static String voucherCode="12345";
    private String selectedVoucherCode;
    private ExceptionFactory exceptionFactory;
    public ExceptionServiceController(){
    }

    @Override
    public void order(Map<String, Item> machines, Map<String, Item> capsules) {
        try{
            if(capsules.size()==0){
                if(machines.size()==0) {
                    throw new OrderException("Empty Cart");
                }
                else if(this.selectedVoucherCode!=null&& !voucherCode.equalsIgnoreCase(this.selectedVoucherCode)){
                    throw new OrderException("Invalid voucher code");
                }
            }
            else if(machines.size()==0&&this.selectedVoucherCode!=null){
                throw new OrderException("Voucher requires machine purchase");
            }
            else if(capsules.get("ROMA")!=null&& (capsules.get("ROMA").getQuantity()%5)!=0){
                throw new OrderException("ROMA: Invalid Quantity, must be a multiple of 5");
            }

        }catch (OrderException e){
            this.exceptionFactory=e;
        }
    }

    @Override
    public void voucher(String code) {
       this.selectedVoucherCode=code;
    }

    @Override
    public boolean hasErrors() {
        if(this.exceptionFactory==null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String errors() {
        return this.exceptionFactory.getMessage();
    }
}
