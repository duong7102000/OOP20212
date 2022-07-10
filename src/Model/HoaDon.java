package Model;

import java.util.ArrayList;
import java.util.List;

import static Model.CuaHang.doanhThu;
import static Model.CuaHang.loiNhuan;

public class HoaDon {
    private int id;
    private String tenKhachHang;
    private int discount;
    public List<GioHang> gioHangList;

    public void themSanPhamVaoGioHang(GioHang gioHang) {
        gioHangList.add(gioHang);
    }
    public void boSanPhamThuIKhoiGioHang(int i){
        gioHangList.remove(i);
    }
    public double tinhGiaTriDonHang(){
        double giaTriDonHang=0;
        for (int i = 0; i < gioHangList.size() - 1; i++) {
            double giaSanPham= gioHangList.get(i).getSanPham().getGiaBan() * gioHangList.get(i).getSoLuong();
            giaTriDonHang+=giaSanPham;
        }
        giaTriDonHang=giaTriDonHang*discount/100;
        return giaTriDonHang;
    }
    public double tinhLoiNhuanDonHang(){
        double loiNhuanDonHang=0;
        for(int i = 0;i< gioHangList.size()-1;i++){
            double loiNhuanSP = (gioHangList.get(i).getSanPham().getGiaBan()-gioHangList.get(i).getSanPham().getGiaMua()) * gioHangList.get(i).getSoLuong();
            loiNhuanDonHang+=loiNhuanSP;
        }
        loiNhuan+=loiNhuanDonHang;
        return loiNhuanDonHang;
    }

    public HoaDon(int id, String tenKhachHang, int discount, List<GioHang> gioHangList) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.discount = discount;
        this.gioHangList = gioHangList;
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

    public List<GioHang> getGioHangList() {
        return gioHangList;
    }

    public void setGioHang(List<GioHang> gioHangList) {
        this.gioHangList = gioHangList;
    }
}
