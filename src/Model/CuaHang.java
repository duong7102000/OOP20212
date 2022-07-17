package Model;

import java.util.ArrayList;
import java.util.List;

public class CuaHang {
    public static double doanhThu;
    public List<NhanVien> nhanViens;
    public CuaHang() {
        nhanViens = new ArrayList<NhanVien>();
    }
    public void themNhanVien(NhanVien nhanVien){
        nhanViens.add(nhanVien);
    }
    public void xoaNhanVien(int i){
        nhanViens.remove(i);
    }

    public double tinhTongLuong(){
        double tongLuong=0;
        for(NhanVien nv:this.nhanViens){
            tongLuong += nv.tinhLuong();
        }
        return tongLuong;
    }

    public CuaHang(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
