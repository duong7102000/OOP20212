package Model;

public class NhanVienHopDong extends NhanVien{
    private double luongHopDong;

    @Override
    public double tinhLuong() {
        return luongHopDong;
    }
}
