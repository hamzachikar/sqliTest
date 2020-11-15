package ecom;

public class CodeException extends Exception {
    public boolean hasError=false;
    public String errorMessage;
    public CodeException(){}
    public CodeException(String message){
        super(message);
        hasError=true;
        errorMessage=message;
    }
}
