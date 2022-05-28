package Model;

public class NhanVienChinhThuc extends NhanVien {
    private static double luongCoBan ;
    private double heSoLuong;
    public double tinhLuong(){
        return luongCoBan*heSoLuong;
    }
    public void tangHeSoLuong(double heSoLuongTang){
        if(luongCoBan*(heSoLuongTang+heSoLuong)<10000000){
            heSoLuong=heSoLuong+heSoLuongTang;
        }
        else System.out.println("Tăng quá lương tối đa");
    }
    public void inThongTin(){
        System.out.println(super.getTenNhanVien());
        System.out.println(super.getAge());
        System.out.println(tinhLuong());
    }
}
