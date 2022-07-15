package View;

import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static Controller.DiaNhacController.*;
import static Controller.DiaPhimController.*;
import static Controller.NhanVienFullTimeController.getAllNhanVienFullTime;
import static Controller.NhanVienFullTimeController.searchNvftByName;
import static Controller.NhanVienPartTimeController.getAllNhanVienPartTime;
import static Controller.NhanVienPartTimeController.searchNvptByName;
import static Controller.SachController.*;

public class QuanLyForm extends JDialog{
    private JTabbedPane tabbedPane1;
    private JButton đăngXuấtButton;
    private JTextField tìmSảnPhẩm;
    private JButton thêmSảnPhẩmButton;
    private JButton searchButton;
    private JButton sửaSảnPhẩmButton;
    private JButton xóaSảnPhẩmButton;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTextField textField1;
    private JButton searchButton1;
    private JButton sửaNhânViênButton;
    private JButton thêmNhânViênButton;
    private JTable table4;
    private JTable table5;

    public QuanLyForm(JFrame parent, QuanLy quanLy){
        super(parent);
        setTitle("Quản lý MediaOne");
        setMinimumSize(new Dimension(1500, 800));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        đăngXuấtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login(null);
            }
        });
        DefaultTableModel defaultTableModel1 = new DefaultTableModel();
        table1.setModel(defaultTableModel1);
        defaultTableModel1.addColumn("Id");
        defaultTableModel1.addColumn("Tên sách");
        defaultTableModel1.addColumn("Tác giả");
        defaultTableModel1.addColumn("Thể loại sách");
        defaultTableModel1.addColumn("Nhà xuất bản");
        defaultTableModel1.addColumn("Năm ra mắt");
        defaultTableModel1.addColumn("Số lượng");
        defaultTableModel1.addColumn("Giá bán");
        defaultTableModel1.addColumn("Giá mua");
        List<Sach> listSach = getAllSach();
        for (Sach sach :
                listSach) {
            int id = sach.getId();
            String tenSach = sach.getTenSach();
            String tacGia = sach.getTacGia();
            String theLoaiSach = sach.getTheLoaiSach();
            String nhaXuatBan = sach.getNhaXuatBan();
            int namRaMat = sach.getNamRaMat();
            int soLuong = sach.getSoLuong();
            double giaBan = sach.getGiaBan();
            double giaMua = sach.getGiaMua();
            Object[] row = new Object[]{id, tenSach, tacGia, theLoaiSach, nhaXuatBan, nhaXuatBan, namRaMat, soLuong, giaBan, giaMua};
            defaultTableModel1.addRow(row);
        }
        DefaultTableModel defaultTableModel2 = new DefaultTableModel();
        table2.setModel(defaultTableModel2);
        defaultTableModel2.addColumn("Id");
        defaultTableModel2.addColumn("Tên đĩa nhạc");
        defaultTableModel2.addColumn("Ca sỹ");
        defaultTableModel2.addColumn("Thể loại nhạc");
        defaultTableModel2.addColumn("Album");
        defaultTableModel2.addColumn("Năm ra mắt");
        defaultTableModel2.addColumn("Số lượng");
        defaultTableModel2.addColumn("Giá bán");
        defaultTableModel2.addColumn("Giá mua");
        List<DiaNhac> listDiaNhac = getAllDiaNhac();
        for (DiaNhac diaNhac :
                listDiaNhac) {
            int id = diaNhac.getId();
            String tenDiaNhac = diaNhac.getTenDiaNhac();
            String caSy = diaNhac.getCaSy();
            String theLoaiNhac = diaNhac.getTheLoaiNhac();
            String album = diaNhac.getAlbum();
            int namRaMat = diaNhac.getNamRaMat();
            int soLuong = diaNhac.getSoLuong();
            double giaBan = diaNhac.getGiaBan();
            double giaMua = diaNhac.getGiaMua();
            Object[] row = new Object[]{id, tenDiaNhac, caSy, theLoaiNhac, album, namRaMat, soLuong, giaBan, giaMua};
            defaultTableModel2.addRow(row);
        }
        DefaultTableModel defaultTableModel3 = new DefaultTableModel();
        table3.setModel(defaultTableModel3);
        defaultTableModel3.addColumn("Id");
        defaultTableModel3.addColumn("Tên đĩa phim");
        defaultTableModel3.addColumn("Đạo diễn");
        defaultTableModel3.addColumn("Biên kịch");
        defaultTableModel3.addColumn("Diễn viên");
        defaultTableModel3.addColumn("Hãng sản xuất");
        defaultTableModel3.addColumn("Năm ra mắt");
        defaultTableModel3.addColumn("Số lượng");
        defaultTableModel3.addColumn("Giá bán");
        defaultTableModel3.addColumn("Giá mua");
        List<DiaPhim> listDiaPhim = getAllDiaPhim();
        for (DiaPhim diaPhim :
                listDiaPhim) {
            int id = diaPhim.getId();
            String tenDiaPhim = diaPhim.getTenDiaPhim();
            String daoDien = diaPhim.getDaoDien();
            String bienKich = diaPhim.getBienKich();
            String dienVien = diaPhim.getDienVien();
            String hangSanXuat = diaPhim.getHangXanSuat();
            int namRaMat = diaPhim.getNamRaMat();
            int soLuong = diaPhim.getSoLuong();
            double giaBan = diaPhim.getGiaBan();
            double giaMua = diaPhim.getGiaMua();
            Object[] row = new Object[]{id, tenDiaPhim, daoDien, bienKich, dienVien, hangSanXuat, namRaMat, soLuong, giaBan, giaMua};
            defaultTableModel2.addRow(row);
        }
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String sanPhamSearch = tìmSảnPhẩm.getText();
                List<Sach> listSach = searchSachByName(sanPhamSearch);
                List<DiaNhac> listDiaNhac = searchDiaNhacByName(sanPhamSearch);
                List<DiaPhim> listDiaPhim = searchDiaPhimByName(sanPhamSearch);
                if ((listSach.size() == 0) && (listDiaPhim.size() == 0) && (listDiaNhac.size() == 0)) {
                    JOptionPane.showMessageDialog(QuanLyForm.this, "Không có sản phẩm bạn tìm kiếm!");
                } else {
                    int rows = defaultTableModel1.getRowCount();
                    for (int i = rows - 1; i >= 0; i--) {
                        defaultTableModel1.removeRow(i);
                    }
                    for (Sach sach :
                            listSach) {
                        int id = sach.getId();
                        String tenSach = sach.getTenSach();
                        String tacGia = sach.getTacGia();
                        String theLoaiSach = sach.getTheLoaiSach();
                        String nhaXuatBan = sach.getNhaXuatBan();
                        int namRaMat = sach.getNamRaMat();
                        int soLuong = sach.getSoLuong();
                        double giaBan = sach.getGiaBan();
                        double giaMua = sach.getGiaMua();
                        Object[] row = new Object[]{id, tenSach, tacGia, theLoaiSach, nhaXuatBan, namRaMat, soLuong, giaBan, giaMua};
                        defaultTableModel1.addRow(row);
                    }
                    int rows1 = defaultTableModel2.getRowCount();
                    for (int i = rows1 - 1; i >= 0; i--) {
                        defaultTableModel2.removeRow(i);
                    }
                    for (DiaNhac diaNhac :
                            listDiaNhac) {
                        int id = diaNhac.getId();
                        String tenDiaNhac = diaNhac.getTenDiaNhac();
                        String caSy = diaNhac.getCaSy();
                        String theLoaiNhac = diaNhac.getTheLoaiNhac();
                        String album = diaNhac.getAlbum();
                        int namRaMat = diaNhac.getNamRaMat();
                        int soLuong = diaNhac.getSoLuong();
                        double giaBan = diaNhac.getGiaBan();
                        double giaMua = diaNhac.getGiaMua();
                        Object[] row = new Object[]{id, tenDiaNhac, caSy, theLoaiNhac, album, namRaMat, soLuong, giaBan, giaMua};
                        defaultTableModel2.addRow(row);
                    }
                    int rows2 = defaultTableModel3.getRowCount();
                    for (int i = rows2 - 1; i >= 0; i--) {
                        defaultTableModel3.removeRow(i);
                    }
                    for (DiaPhim diaPhim :
                            listDiaPhim) {
                        int id = diaPhim.getId();
                        String tenDiaPhim = diaPhim.getTenDiaPhim();
                        String daoDien = diaPhim.getDaoDien();
                        String bienKich = diaPhim.getBienKich();
                        String dienVien = diaPhim.getDienVien();
                        String hangXanSuat = diaPhim.getHangXanSuat();
                        int namRaMat = diaPhim.getNamRaMat();
                        int soLuong = diaPhim.getSoLuong();
                        double giaBan = diaPhim.getGiaBan();
                        double giaMua = diaPhim.getGiaMua();
                        Object[] row = new Object[]{id, tenDiaPhim, daoDien, bienKich, dienVien, hangXanSuat, namRaMat, soLuong, giaBan, giaMua};
                        defaultTableModel3.addRow(row);
                    }
                }
            }
        });
        thêmSảnPhẩmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ThemSanPham(null);
            }
        });
        xóaSảnPhẩmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int Id = Integer.parseInt(JOptionPane.showInputDialog("Mời bạn nhập Id sách muốn xóa:"));
                if ((deleteSachById(Id)) || (deleteDiaPhimById(Id)) || (deleteDiaNhacById(Id))) {
                    JOptionPane.showMessageDialog(QuanLyForm.this, "Xóa sản phẩm thành công!");
                } else {
                    JOptionPane.showMessageDialog(QuanLyForm.this, "Không thể xóa sản phẩm do có lỗi gì đó!");
                }
            }
        });
        sửaSảnPhẩmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SuaSanPham(null);
            }
        });
        DefaultTableModel defaultTableModel4 = new DefaultTableModel();
        table4.setModel(defaultTableModel2);
        defaultTableModel4.addColumn("Họ và tên");
        defaultTableModel4.addColumn("Năm sinh");
        defaultTableModel4.addColumn("Username");
        defaultTableModel4.addColumn("Password");
        defaultTableModel4.addColumn("Position");
        defaultTableModel4.addColumn("Lương tháng");
        List<NhanVienFullTime> listNhanVienFullTime = getAllNhanVienFullTime();
        for (NhanVienFullTime nvft :
                listNhanVienFullTime) {
            String ten = nvft.getTenNhanVien();
            int namSinh = nvft.getNamSinh();
            String username = nvft.getAccount().getUsername();
            String password = nvft.getAccount().getPassword();
            String position = nvft.getAccount().getPosition();
            double luong = nvft.tinhLuong();
            Object[] row = new Object[]{ten, namSinh, username, password, position, luong};
            defaultTableModel4.addRow(row);
        }
        DefaultTableModel defaultTableModel5 = new DefaultTableModel();
        table5.setModel(defaultTableModel5);
        defaultTableModel5.addColumn("Họ và tên");
        defaultTableModel5.addColumn("Năm sinh");
        defaultTableModel5.addColumn("Username");
        defaultTableModel5.addColumn("Password");
        defaultTableModel5.addColumn("Position");
        defaultTableModel5.addColumn("Lương theo giờ");
        defaultTableModel5.addColumn("Giờ làm");
        defaultTableModel5.addColumn("Lương tháng");
        List<NhanVienPartTime> listNhanVienPartTime = getAllNhanVienPartTime();
        for (NhanVienPartTime nvpt :
                listNhanVienPartTime) {
            String ten = nvpt.getTenNhanVien();
            int namSinh = nvpt.getNamSinh();
            String username = nvpt.getAccount().getUsername();
            String password = nvpt.getAccount().getPassword();
            String position = nvpt.getAccount().getPosition();
            int gioLam = nvpt.getGioLam();
            double luongTheoGio = nvpt.getLuongTheoGio();
            double luong = nvpt.tinhLuong();
            Object[] row = new Object[]{ten, namSinh, username, password, position, luongTheoGio, gioLam, luong};
            defaultTableModel5.addRow(row);
        }
        thêmNhânViênButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ThemNhanVien(null);
            }
        });
        searchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nhanVienSearch = textField1.getText();
                List<NhanVienFullTime> listnvft = searchNvftByName(nhanVienSearch);
                List<NhanVienPartTime> listnvpt = searchNvptByName(nhanVienSearch);
                if ((listnvft.size() == 0) && (listnvpt.size() == 0)) {
                    JOptionPane.showMessageDialog(QuanLyForm.this, "Không có nhân viên bạn tìm kiếm!");
                } else {
                    int rows = defaultTableModel4.getRowCount();
                    for (int i = rows - 1; i >= 0; i--) {
                        defaultTableModel4.removeRow(i);
                    }
                    for (NhanVienFullTime nvft :
                            listNhanVienFullTime) {
                        String ten = nvft.getTenNhanVien();
                        int namSinh = nvft.getNamSinh();
                        String username = nvft.getAccount().getUsername();
                        String password = nvft.getAccount().getPassword();
                        String position = nvft.getAccount().getPosition();
                        double luong = nvft.tinhLuong();
                        Object[] row = new Object[]{ten, namSinh, username, password, position, luong};
                        defaultTableModel4.addRow(row);
                    }
                    int rows1 = defaultTableModel5.getRowCount();
                    for (int i = rows1 - 1; i >= 0; i--) {
                        defaultTableModel5.removeRow(i);
                    }
                    for (NhanVienPartTime nvpt :
                            listNhanVienPartTime) {
                        String ten = nvpt.getTenNhanVien();
                        int namSinh = nvpt.getNamSinh();
                        String username = nvpt.getAccount().getUsername();
                        String password = nvpt.getAccount().getPassword();
                        String position = nvpt.getAccount().getPosition();
                        int gioLam = nvpt.getGioLam();
                        double luongTheoGio = nvpt.getLuongTheoGio();
                        double luong = nvpt.tinhLuong();
                        Object[] row = new Object[]{ten, namSinh, username, password, position, luongTheoGio, gioLam, luong};
                        defaultTableModel5.addRow(row);
                    }
                }
            }
        });
        sửaNhânViênButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SuaNhanVien(null);
            }
        });
    }
    public static void main(String[] args) {
        QuanLy ql = new QuanLy("hadimsctn", "12345678", "Quản Lý", "Nguyễn Hà", 2002, 0);
        new QuanLyForm(null, ql);
    }
}
