package Model;

public class NhanVienFullTime extends NhanVien {
    private static double luongThang;

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
