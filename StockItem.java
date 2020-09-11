

public class StockItem {
    private Integer initialQuantity;
    private Integer quantity;
    private String name;
    private Double price;

    public StockItem(String name, Integer initialQuantity, Double price){
        this.quantity = this.initialQuantity = initialQuantity;
        this.name = name;
        this.price = price;
    }

    //Set of get methods to retrive data about vernding machine items
    public String getName(){
        return this.name;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void resetStock(){
        this.quantity = this.initialQuantity;
    }

    public Double getPrice(){
        return this.price;
    }

    public Double getTotal(){
        return this.price * (this.initialQuantity - this.quantity);
    }

    public void decrement(){
        if(this.quantity > 0) 
            this.quantity--;
    }
}
