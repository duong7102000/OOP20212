package Model;

public class NhanVienPartTime extends NhanVien{
    private double luongTheoGio;
    private int gioLam;

    @Override
    public double tinhLuong() {
        return luongTheoGio*gioLam;
    }

    public double getLuongTheoGio() {
        return luongTheoGio;
    }

    public void setLuongTheoGio(double luongTheoGio) {
        this.luongTheoGio = luongTheoGio;
    }

    public int getGioLam() {
        return gioLam;
    }

    public void setGioLam(int gioLam) {
        this.gioLam = gioLam;
    }
}
