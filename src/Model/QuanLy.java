package Model;

public class QuanLy extends NhanVienFullTime {
    public QuanLy(Account account, String tenNhanVien, int namSinh, double luongThang) {
        super(account, tenNhanVien, namSinh, luongThang);
    }

    public QuanLy(String username, String password, String position, String tenNhanVien, int namSinh, double luongThang) {
        super(username, password, position, tenNhanVien, namSinh, luongThang);
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong()+0.05*CuaHang.doanhThu;
    }
}
