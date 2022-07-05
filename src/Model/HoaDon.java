package Model;

import java.util.ArrayList;
import java.util.List;

public class HoaDon {
    private int id;
    private String tenKhachHang;
    private int discount;
    private int soLuongMua;
    private int soLoaiSanPhamMua;
    public List<SanPham> gioHang;

    public HoaDon() {
        gioHang = new ArrayList<SanPham>();
    }
    public void themSanPhamVaoGioHang(SanPham sanPham) {
        gioHang.add(sanPham);
    }
    public double tinhGiaTriDonHang(){
        double giaTriDonHang=0;
        for (int i = 0; i < gioHang.size() - 1; i++) {
            double giaSanPham= gioHang.get(i).getGiaMua()*soLuongMua;
            giaTriDonHang+=giaSanPham;
        }
        return giaTriDonHang;
    }
}
