package Model;

public class DiaNhac extends SanPham {
    private String tenDiaNhac;
    private String caSy;
    private String theLoaiNhac;
    private String album;

    public DiaNhac(double giaMua, double giaBan, double soLuong, int namRaMat, String tenDiaNhac, String caSy, String theLoaiNhac, String album) {
        super(giaMua, giaBan, soLuong, namRaMat);
        this.tenDiaNhac = tenDiaNhac;
        this.caSy = caSy;
        this.theLoaiNhac = theLoaiNhac;
        this.album = album;
    }
}
