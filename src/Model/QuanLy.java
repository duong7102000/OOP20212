package Model;

import Util.GetDate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static Controller.HoaDonController.getAllHoaDonTheoThang;
import static Controller.QuanLyController.getAllQuanLy;

public class QuanLy extends NhanVienFullTime {
    public QuanLy(Account account, String tenNhanVien, int namSinh, double luongThang) {
        super(account, tenNhanVien, namSinh, luongThang);
    }

    public QuanLy(String username, String password, String position, String tenNhanVien, int namSinh, double luongThang) {
        super(username, password, position, tenNhanVien, namSinh, luongThang);
    }

    @Override
    public double tinhLuong() {
        double doanhThu = 0;
        Calendar cal = Calendar.getInstance();
        int i =cal.get(Calendar.MONTH)+1;
        int j =cal.get(Calendar.YEAR);
        List<HoaDon> hoaDonList = getAllHoaDonTheoThang(i, j);
        for (HoaDon hd : hoaDonList) {
            double doanhThuHoaDon = hd.tinhGiaTriDonHang();
            doanhThu += doanhThuHoaDon;
        }
        return super.tinhLuong()+0.05*doanhThu;
    }
}
