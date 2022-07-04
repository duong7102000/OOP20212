package Model;

import java.util.ArrayList;
import java.util.List;

public class HoaDon {
    private int id;
    private String tenKhachHang;
    private int discount;
    private int soLuongMua;
    private int soLoaiSanPhamMua;
    public List<SanPham> sanPhams;

    public HoaDon() {
        sanPhams = new ArrayList<SanPham>();
    }
    public void themSanPham(SanPham sanPham) {
        sanPhams.add(sanPham);
    }
    public double tinhGiaTriDonHang(){
        double giaTriDonHang=0;
        for (int i = 0; i < sanPhams.size() - 1; i++) {
            double giaSanPham= sanPhams.get(i).getGiaMua()*soLuongMua;
            giaTriDonHang+=giaSanPham;
        }
        return giaTriDonHang;
    }
}
