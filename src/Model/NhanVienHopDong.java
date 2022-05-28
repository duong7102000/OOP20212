package Model;

public class NhanVienHopDong extends NhanVien{
    private double luongHopDong;

    @Override
    public double tinhLuong() {
        return luongHopDong;
    }
    public void inThongTin(){
        System.out.println(super.getTenNhanVien());
        System.out.println(super.getAge());
        System.out.println(tinhLuong());
    }
}
