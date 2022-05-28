package Model;


public abstract class NhanVien {
    private String tenNhanVien;
    private int age;
    public abstract double tinhLuong();
    public abstract void inThongTin();

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
