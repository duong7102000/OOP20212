package Model;

public class Store {
    private Product product;
    private double electricity;
    private double water;
    private double rent;
    public final static int numberOfWorkers=3;
    private Employee Employee1;
    private Employee Employee2;
    private Manager Manager;
    private static double capital;
    private double profit;
    private static double turnover;
    public void calculateTurnover(){
        turnover=turnover+product.profits();
    }
    public void calculateProfit(){
        profit=turnover-electricity-water-rent;
    }
    public void calculatecapital(){
        capital=capital+profit;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
