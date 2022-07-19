package Model;

import java.util.ArrayList;
import java.util.List;

import static Model.CuaHang.doanhThu;


public class HoaDon {
    private int id;
    private int discount;
    public List<GioHang> gioHangList;
    public void boSanPhamThuIKhoiGioHang(int i){
        gioHangList.remove(i);
    }
    public double tinhGiaTriDonHang(){
        double giaTriDonHang=0;
        if (gioHangList.size()==0){return 0;}
        else {
            for (int i = 0; i < gioHangList.size() ; i++) {
                giaTriDonHang+= gioHangList.get(i).getSanPham().getGiaBan() * gioHangList.get(i).getSoLuong();
            }
            giaTriDonHang = giaTriDonHang - giaTriDonHang * discount / 100;
            return giaTriDonHang;
        }
    }
    public double tinhLoiNhuanDonHang(){
        double loiNhuanDonHang=0;
        for(int i = 0;i< gioHangList.size()-1;i++){
            double loiNhuanSP = (gioHangList.get(i).getSanPham().getGiaBan()-gioHangList.get(i).getSanPham().getGiaMua()) * gioHangList.get(i).getSoLuong();
            loiNhuanDonHang+=loiNhuanSP;
        }
        doanhThu+=loiNhuanDonHang;
        return loiNhuanDonHang;
    }

    public HoaDon(int id, int discount, List<GioHang> gioHangList) {
        this.id = id;
        this.discount = discount;
        this.gioHangList = gioHangList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
