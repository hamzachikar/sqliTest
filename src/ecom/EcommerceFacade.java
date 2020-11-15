package ecom;


import java.util.ArrayList;
import java.util.List;


public class EcommerceFacade {
    CodeException codeException = new CodeException();
    OrderException orderException=new OrderException();
    String codeVoucher;
    List<Product> machines;
    List<Product> capsules;

    public EcommerceFacade(){
        this.machines=new ArrayList<>();
        this.capsules=new ArrayList<>();
    }
    class Product{
        String name;
        int quantity;
        int price;
        public Product(String name,int quantity,int price){
            this.name=name;
            this.quantity=quantity;
            this.price=price;
        }
    }
    void addMachine(String name,int quantity,int price){
        this.addProduct('M',new Product(name,quantity,price));

    }
    void addCapsule(String name,int quantity,int price){
        this.addProduct('C',new Product(name,quantity,price));
    }
    void addProduct(char option,Product product){
        List<Product> products=new ArrayList<>();
        switch (option){
            case 'M':
                products=this.machines;
                break;
            case 'C':
                products=this.capsules;
                break;
        }
        if(products.size()==0){
            products.add(product);
        }
        else{
            double index=0;
            boolean exist=false;
            for(Product p:products){
                boolean flag=false;
                for(int i=0;i<Math.min(product.name.length(),p.name.length());i++){
                    if(Character.compare(p.name.charAt(i),product.name.charAt(i))>0){
                        index=products.indexOf(p);
                        flag=true;
                        break;
                    }
                    if(Character.compare(p.name.charAt(i),product.name.charAt(i))<0){
                        break;
                    }

                if(i==Math.min(product.name.length(),p.name.length())-1&&Character.compare(p.name.charAt(i),product.name.charAt(i))==0){
                    index=products.indexOf(p);
                    this.setProps(option,(int)index,product);
                    exist=true;
                    flag=true;
                    break;
                }
                }
                if(flag){
                    break;
                }
            }
            if(index>=0&&!exist){
                products.add((int)index,product);
            }
        }
       this.checkProductProps();

    }
    void checkProductProps(){
        if(this.machines.size()!=0){
            if(this.codeVoucher!=null){
                this.voucher(this.codeVoucher);
            }

        }
        if(this.capsules.size()!=0){
            for(Product product:this.capsules){
                try{
                    switch (product.name){
                        case "ROMA":
                            if(product.quantity%5!=0){
                                this.orderException=new OrderException("ROMA: Invalid Quantity, must be a multiple of 5");
                                throw this.orderException;
                            }
                            break;
                    }
                }catch (OrderException e){}

            }
        }

    }
    void voucher(String code){
        this.codeVoucher=code;
        try{
            if(!code.equals("12345")){
                this.codeException= new CodeException("Invalid voucher code");
                throw this.codeException;
            }
            if(this.machines.size()==0){
                this.codeException= new CodeException("Voucher requires machine purchase");
                throw this.codeException;
            }
            this.codeException=new CodeException();
        }catch (CodeException e){
            System.out.println(e.getMessage());
        }

    }
    void setProps(char option,int index,Product product){
        switch(option){
            case 'M':
                this.machines.get(index).quantity=this.machines.get(index).quantity+product.quantity;
                break;
            case 'C':
                this.capsules.get(index).quantity=this.capsules.get(index).quantity+product.quantity;
                break;
        }

    }
    void removeProduct(char option,String name,int quantity){
        List<Product>products=new ArrayList<>();
        switch (option){
            case 'M':
                products=this.machines;
                break;
            case 'C':
                products=this.capsules;
                break;
        }
        for(Product product:products){
            if(product.name.equals(name)){
                if(products.get(products.indexOf(product)).quantity-quantity>0){
                    products.get(products.indexOf(product)).quantity=products.get(products.indexOf(product)).quantity-quantity;
                }
                else{
                    products.remove(products.indexOf(product));
                }
                break;
            }
        }
    }
    void removeMachine(String name,int quantite){
      this.removeProduct('M',name,quantite);
    }
    void removeCapsule(String name,int quantite){
        this.removeProduct('C',name,quantite);
    }
    void order(){
        try{
            if(this.machines.size()==0&&this.capsules.size()==0){
                this.orderException=new OrderException("Empty Cart");
                throw this.orderException;
            }
        }
        catch (OrderException e){
            System.out.println(e.getMessage());
        }

    }
    boolean hasErrors(){
        boolean error=false;
        if(this.codeException.hasError|| this.orderException.hasError){
            error=true;
        }
        return error;
    }
    String errors(){
        String error="";
        if(this.orderException.hasError){
            error=orderException.errorMessage;
        }
       if(this.codeException.hasError){
           error=codeException.errorMessage;
       }
       return error;
    }

    String cartContent(){
        String cart="";
        if(this.capsules.size()!=0){
            cart="Capsule\n";
            for(Product machine:this.capsules){
                cart=cart+"\tName: "+machine.name+"\tQuantity: "+machine.quantity+"\tPrice: "+(machine.quantity*machine.price)+"\n";
            }
        }
        if(this.machines.size()!=0){
            cart=cart+"Machine\n";
            for(Product machine:this.machines){
                cart=cart+"\tName: "+machine.name+"\tQuantity: "+machine.quantity+"\tPrice: "+(machine.quantity*machine.price)+"\n";
            }
        }

        return cart;
    }
    String summary(){
        String s="";
        int totalPriceS=0;
        if(this.capsules.size()!=0){
            s="Capsule\n";
            int quantity=0;
            int totalPrice=0;
            for(Product product:this.capsules){
               quantity=quantity+product.quantity;
               totalPrice=totalPrice+(product.price*product.quantity);
            }
            totalPriceS=totalPriceS+totalPrice;
            s=s+"\tQuantity: "+quantity+"\tPrice: "+totalPrice+"\n";
        }
        if(this.machines.size()!=0){
            s=s+"Machine\n";
            int quantity=0;
            int totalPrice=0;
            for(Product product:this.machines){
                quantity=quantity+product.quantity;
                totalPrice=totalPrice+(product.price*product.quantity);
            }
            totalPriceS=totalPriceS+totalPrice;
            s=s+"\tQuantity: "+quantity+"\tPrice: "+totalPrice+"\n";
        }
        s=s+"Total Price: "+totalPriceS+"\n";
        return s;
    }
}
