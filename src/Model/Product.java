package Model;

public abstract class Product {
    private double price;
    private double purchasePrice;
    private int inStock;
    public double invoice(int amount){
        return price * amount;
    }
    public double profits(int amount){
        return (price - purchasePrice)*amount;
    }

    public Product(double price, double purchasePrice, int inStock) {
        this.price = price;
        this.purchasePrice = purchasePrice;
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
