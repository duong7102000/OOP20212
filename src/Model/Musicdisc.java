package Model;

public class Musicdisc extends Product{
    private String singerInformation;
    private String kindOfMusic;
    private int debutYear;



    private String album;

    public Musicdisc(double price, double purchasePrice, int inStock, String singerInformation, String kindOfMusic, int debutYear, String album) {
        super(price, purchasePrice, inStock);
        this.singerInformation = singerInformation;
        this.kindOfMusic = kindOfMusic;
        this.debutYear = debutYear;
        this.album = album;
    }

    public String getSingerInformation() {
        return singerInformation;
    }

    public void setSingerInformation(String singerInformation) {
        this.singerInformation = singerInformation;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public int getDebutYear() {
        return debutYear;
    }

    public void setDebutYear(int debutYear) {
        this.debutYear = debutYear;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
