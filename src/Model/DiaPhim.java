package Model;

public class DiaPhim extends SanPham {
    private String tenDiaPhim;
    private String daoDien;
    private String bienKich;
    private String dienVien;
    private String hangSanXuat;

    public DiaPhim(int id, double giaMua, double giaBan, int soLuong, int namRaMat, String tenDiaPhim, String daoDien, String bienKich, String dienVien, String hangSanXuat) {
        super(id, giaMua, giaBan, soLuong, namRaMat);
        this.tenDiaPhim = tenDiaPhim;
        this.daoDien = daoDien;
        this.bienKich = bienKich;
        this.dienVien = dienVien;
        this.hangSanXuat = hangSanXuat;
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

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }
}
