package Model;

public class SanPham {
    private int id;
    private double giaMua;
    private double giaBan;
    private int soLuong;
    private int namRaMat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SanPham(int id, double giaMua, double giaBan, int soLuong, int namRaMat) {
        this.id = id;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.namRaMat = namRaMat;
    }

    public double getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(double giaMua) {
        this.giaMua = giaMua;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getNamRaMat() {
        return namRaMat;
    }

    public void setNamRaMat(int namRaMat) {
        this.namRaMat = namRaMat;
    }
}
