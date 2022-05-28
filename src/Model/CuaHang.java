package Model;

public class CuaHang {
    public static double loiNhuan;
    private NhanVien[] nhanViens;
    private double tienDien;
    private double chiPhiMatBang;
    public static double doanhThu;
    private int soNhanVien;
    public double tinhTongLuong(){
        double tongLuong=0;
        for(NhanVien nv:this.nhanViens){
            tongLuong += nv.tinhLuong();
        }
        return tongLuong;
    }
    public void tinhLoiNhuan(){
        loiNhuan=doanhThu-tinhTongLuong()-this.chiPhiMatBang-this.tienDien;
    }
}
