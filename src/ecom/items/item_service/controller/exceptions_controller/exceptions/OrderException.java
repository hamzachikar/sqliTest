package ecom.items.item_service.controller.exceptions_controller.exceptions;

public class OrderException extends Exception implements ExceptionFactory{
    public OrderException(String message){
        super(message);
    }
}
