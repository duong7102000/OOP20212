package Model;


public abstract class NhanVien {
    private String tenNhanVien;
    private int namSinh;
    public abstract double tinhLuong();
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
}
