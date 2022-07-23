package Model;

import java.sql.Date;
import java.util.List;




public class HoaDon {
    private int id;
    private int discount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;
    public List<GioHang> gioHangList;
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
        for(int i = 0;i< gioHangList.size();i++){
            double loiNhuanSP = (gioHangList.get(i).getSanPham().getGiaBan()-gioHangList.get(i).getSanPham().getGiaMua()) * gioHangList.get(i).getSoLuong();
            loiNhuanDonHang+=loiNhuanSP;
        }
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
