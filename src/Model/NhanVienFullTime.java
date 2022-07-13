package Model;

public class NhanVienFullTime extends NhanVien {
    private static double luongThang;

    public NhanVienFullTime(Account account, String tenNhanVien, int namSinh,double luongThang) {
        super(account, tenNhanVien, namSinh);
        this.luongThang=luongThang;
    }

    public NhanVienFullTime(String username, String password, String position, String tenNhanVien, int namSinh,double luongThang) {
        super(username, password, position, tenNhanVien, namSinh);
        this.luongThang=luongThang;
    }

    @Override
    public double tinhLuong() {
        return luongThang;
    }

    public static double getLuongThang() {
        return luongThang;
    }

    public static void setLuongThang(double luongThang) {
        NhanVienFullTime.luongThang = luongThang;
    }
}
