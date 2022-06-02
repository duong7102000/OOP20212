package Model;

public class DiaPhim extends SanPham {
    private String tenDiaPhim;
    private String daoDien;
    private String bienKich;
    private String[] dienVien;
    private int hangXanSuat;

    public DiaPhim(double giaMua, double giaBan, double soLuong, int namRaMat, String tenDiaPhim, String daoDien, String bienKich, String[] dienVien, int hangXanSuat) {
        super(giaMua, giaBan, soLuong, namRaMat);
        this.tenDiaPhim = tenDiaPhim;
        this.daoDien = daoDien;
        this.bienKich = bienKich;
        this.dienVien = dienVien;
        this.hangXanSuat = hangXanSuat;
    }
}
