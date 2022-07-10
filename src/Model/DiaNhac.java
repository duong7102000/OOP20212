package Model;

public class DiaNhac extends SanPham {
    private String tenDiaNhac;
    private String caSy;
    private String theLoaiNhac;
    private String album;

    public DiaNhac(int id, double giaMua, double giaBan, int soLuong, int namRaMat, String tenDiaNhac, String caSy, String theLoaiNhac, String album) {
        super(id, giaMua, giaBan, soLuong, namRaMat);
        this.tenDiaNhac = tenDiaNhac;
        this.caSy = caSy;
        this.theLoaiNhac = theLoaiNhac;
        this.album = album;
    }

    public String getTenDiaNhac() {
        return tenDiaNhac;
    }

    public void setTenDiaNhac(String tenDiaNhac) {
        this.tenDiaNhac = tenDiaNhac;
    }

    public String getCaSy() {
        return caSy;
    }

    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }

    public String getTheLoaiNhac() {
        return theLoaiNhac;
    }

    public void setTheLoaiNhac(String theLoaiNhac) {
        this.theLoaiNhac = theLoaiNhac;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
