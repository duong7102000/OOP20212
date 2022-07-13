package Model;


public abstract class NhanVien {
    private Account account;

    public Account getAccount() {
        return account;
    }

    public NhanVien(Account account, String tenNhanVien, int namSinh) {
        this.account=account;
        this.tenNhanVien = tenNhanVien;
        this.namSinh = namSinh;
    }
    public NhanVien(String username, String password, String position, String tenNhanVien, int namSinh ){
        this.account = new Account(username,password,position);
        this.tenNhanVien=tenNhanVien;
        this.namSinh=namSinh;
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
