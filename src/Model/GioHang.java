package Model;

public class GioHang {
    private int id;
    private int hoaDonId;
    private SanPham sanPham;
    private int soLuong;

    public GioHang(int id, int hoaDonId, SanPham sanPham, int soLuong) {
        this.id = id;
        this.hoaDonId = hoaDonId;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public int getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(int hoaDonId) {
        this.hoaDonId = hoaDonId;
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
