package Model;

public class QuanLy extends NhanVienFullTime {
    @Override
    public double tinhLuong() {
        return super.tinhLuong()+0.05*CuaHang.doanhThu;
    }
}
