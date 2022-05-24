package Model;

public class Product {
    private double price;
    private double purchaseprice;
    private int inStock;
    private int amount;
    public double invoice(double price,double amount){
        return price * amount;
    }
    public double profits(){
        return (price - purchaseprice)*amount;
    }
}
