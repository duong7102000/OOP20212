package Model;

public class DiaPhim extends SanPham {
    private String tenDiaPhim;
    private String daoDien;
    private String bienKich;
    private String[] dienVien;
    private int hangXanSuat;

    public DiaPhim(double giaMua, double giaBan, double soLuong, int namRaMat, String tenDiaPhim, String daoDien, String bienKich, String[] dienVien, int hangXanSuat) {
        super();
        this.tenDiaPhim = tenDiaPhim;
        this.daoDien = daoDien;
        this.bienKich = bienKich;
        this.dienVien = dienVien;
        this.hangXanSuat = hangXanSuat;
    }

    public String getTenDiaPhim() {
        return tenDiaPhim;
    }

    public void setTenDiaPhim(String tenDiaPhim) {
        this.tenDiaPhim = tenDiaPhim;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getBienKich() {
        return bienKich;
    }

    public void setBienKich(String bienKich) {
        this.bienKich = bienKich;
    }

    public String[] getDienVien() {
        return dienVien;
    }

    public void setDienVien(String[] dienVien) {
        this.dienVien = dienVien;
    }

    public int getHangXanSuat() {
        return hangXanSuat;
    }

    public void setHangXanSuat(int hangXanSuat) {
        this.hangXanSuat = hangXanSuat;
    }
}
