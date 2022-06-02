package Model;

public class QuanLy extends NhanVienChinhThuc{
    @Override
    public double tinhLuong() {
        return super.tinhLuong()+0.05* CuaHang.loiNhuan;
    }
}
