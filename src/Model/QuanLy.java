package Model;

public class QuanLy extends NhanVienChinhThuc{
    @Override
    public double tinhLuong() {
        return super.tinhLuong()+0.05* CuaHang.loiNhuan;
    }
    public void inThongTin(){
        System.out.println(super.getTenNhanVien());
        System.out.println(super.getAge());
        System.out.println(tinhLuong());
    }
}
