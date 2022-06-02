package Model;

public class Sach extends SanPham {
    private String tenSach;
    private String nhaXuatBan;
    private String tacGia;
    private String theLoaiSach;

    public Sach(double giaMua, double giaBan, double soLuong, int namRaMat, String tenSach, String nhaXuatBan, String tacGia, String theLoaiSach) {
        super(giaMua, giaBan, soLuong, namRaMat);
        this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.tacGia = tacGia;
        this.theLoaiSach = theLoaiSach;
    }
}
