package ecom;

public class OrderException extends Exception {
    public boolean hasError=false;
    public String errorMessage;
    public OrderException(){}
    public OrderException(String message){
        super(message);
        hasError=true;
        errorMessage=message;
    }
}
