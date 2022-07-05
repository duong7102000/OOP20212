package Model;

import java.util.ArrayList;
import java.util.List;

import static Model.CuaHang.doanhThu;
import static Model.CuaHang.loiNhuan;

public class HoaDon {
    private int id;
    private String tenKhachHang;
    private int discount;
    public List<SanPham> gioHang;

    public HoaDon() {
        gioHang = new ArrayList<SanPham>();
    }
    public void themSanPhamVaoGioHang(SanPham sanPham) {
        gioHang.add(sanPham);
    }
    public void boSanPhamThuIKhoiGioHang(int i){
        gioHang.remove(i);
    }
    public double tinhGiaTriDonHang(){
        double giaTriDonHang=0;
        for (int i = 0; i < gioHang.size() - 1; i++) {
            double giaSanPham= gioHang.get(i).getGiaMua();
            giaTriDonHang+=giaSanPham;
        }
        giaTriDonHang=giaTriDonHang*discount/100;
        return giaTriDonHang;
    }
    public double tinhLoiNhuanDonHang(){
        double loiNhuanDonHang=0;
        for(int i = 0;i< gioHang.size()-1;i++){
            double loiNhuanSP= gioHang.get(i).getGiaMua()-gioHang.get(i).getGiaBan();
            loiNhuanDonHang+=loiNhuanSP;
        }
        loiNhuan+=loiNhuanDonHang;
        return loiNhuanDonHang;
    }

    public HoaDon(int id, String tenKhachHang, int discount, List<SanPham> gioHang) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.discount = discount;
        this.gioHang = gioHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public List<SanPham> getGioHang() {
        return gioHang;
    }

    public void setGioHang(List<SanPham> gioHang) {
        this.gioHang = gioHang;
    }
}
