package Model;

public class Sach extends SanPham {
    private String tenSach;
    private String nhaXuatBan;
    private String tacGia;
    private String theLoaiSach;

    public Sach(int id, double giaMua, double giaBan, int soLuong, int namRaMat, String tenSach, String nhaXuatBan, String tacGia, String theLoaiSach) {
        super(id, giaMua, giaBan, soLuong, namRaMat);
        this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.tacGia = tacGia;
        this.theLoaiSach = theLoaiSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoaiSach() {
        return theLoaiSach;
    }

    public void setTheLoaiSach(String theLoaiSach) {
        this.theLoaiSach = theLoaiSach;
    }
}
