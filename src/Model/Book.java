package Model;

public class Book extends Product{
    private String publishingHouse;
    private String author;
    private String bookCategory;

    public Book(double price, double purchasePrice, int inStock, String publishingHouse, String author, String bookCategory) {
        super(price, purchasePrice, inStock);
        this.publishingHouse = publishingHouse;
        this.author = author;
        this.bookCategory = bookCategory;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
}
