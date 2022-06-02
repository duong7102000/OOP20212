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
}
