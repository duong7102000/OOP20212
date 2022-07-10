package Model;

public class GioHang {
    private int id;
    private HoaDon hoaDon;
    private SanPham sanPham;
    private int soLuong;

    public GioHang(int id, HoaDon hoaDon, SanPham sanPham, int soLuong) {
        this.id = id;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
