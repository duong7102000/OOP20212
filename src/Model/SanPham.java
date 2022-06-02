package Model;

public class SanPham {
    private double giaMua;
    private double giaBan;
    private double soLuong;
    private int namRaMat;
    public double thanhToan (int soLuongMua){
        soLuong = soLuong - soLuongMua;
        CuaHang.doanhThu+=((giaBan-giaMua)*soLuongMua);
        return giaBan*soLuongMua;
    }

    public SanPham(double giaMua, double giaBan, double soLuong, int namRaMat) {
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.namRaMat = namRaMat;
    }
}
