package Model;


public abstract class NhanVien {
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    private String tenNhanVien;
    private int namSinh;
    public abstract double tinhLuong();
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
}
