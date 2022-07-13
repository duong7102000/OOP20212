package Model;

public class NhanVienPartTime extends NhanVien{
    private double luongTheoGio;
    private int gioLam;

    public NhanVienPartTime(Account account, String tenNhanVien, int namSinh, double luongTheoGio, int gioLam) {
        super(account, tenNhanVien, namSinh);
        this.luongTheoGio = luongTheoGio;
        this.gioLam = gioLam;
    }

    public NhanVienPartTime(String username, String password, String position, String tenNhanVien, int namSinh, double luongTheoGio, int gioLam) {
        super(username, password, position, tenNhanVien, namSinh);
        this.luongTheoGio = luongTheoGio;
        this.gioLam = gioLam;
    }

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
