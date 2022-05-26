package Model;

public class Moviedisc extends Product{
    private String director;
    private String writer;
    private String[] actor;
    private int debutYear;
    private String production;

    public Moviedisc(double price, double purchasePrice, int inStock, String director, String writer, String[] actor, int debutYear, String production) {
        super(price, purchasePrice, inStock);
        this.director = director;
        this.writer = writer;
        this.actor = actor;
        this.debutYear = debutYear;
        this.production = production;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String[] getActor() {
        return actor;
    }

    public void setActor(String[] actor) {
        this.actor = actor;
    }

    public int getDebutYear() {
        return debutYear;
    }

    public void setDebutYear(int debutYear) {
        this.debutYear = debutYear;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
