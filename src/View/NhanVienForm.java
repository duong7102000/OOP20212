package View;

import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static Controller.DiaNhacController.*;
import static Controller.DiaPhimController.*;
import static Controller.GioHangController.insertGioHang;
import static Controller.SachController.*;
import static Controller.SanPhamController.getSanPhamById;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class NhanVienForm extends JDialog {
    private JPanel panel1;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private JTextField textField1;
    private JButton searchButton;
    private JButton đăngXuấtButton;
    private JButton tínhGiáTrịĐơnButton;
    private JButton thanhToánButton;
    private JTabbedPane tabbedPane1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel giaTriDonHang;

    public NhanVienForm(JFrame parent){
        super(parent);
        setContentPane(panel1);
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
        table2.setModel(defaultTableModel1);
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
        table3.setModel(defaultTableModel2);
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
        table4.setModel(defaultTableModel3);
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
            String hangSanXuat = diaPhim.getHangSanXuat();
            int namRaMat = diaPhim.getNamRaMat();
            int soLuong = diaPhim.getSoLuong();
            double giaBan = diaPhim.getGiaBan();
            double giaMua = diaPhim.getGiaMua();
            Object[] row = new Object[]{id, tenDiaPhim, daoDien, bienKich, dienVien, hangSanXuat, namRaMat, soLuong, giaBan, giaMua};
            defaultTableModel3.addRow(row);
        }
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String sanPhamSearch = textField1.getText();
                List<Sach> listSach = searchSachByName(sanPhamSearch);
                List<DiaNhac> listDiaNhac = searchDiaNhacByName(sanPhamSearch);
                List<DiaPhim> listDiaPhim = searchDiaPhimByName(sanPhamSearch);
                if ((listSach.size() == 0) && (listDiaPhim.size() == 0) && (listDiaNhac.size() == 0)) {
                    JOptionPane.showMessageDialog(NhanVienForm.this, "Không có sản phẩm bạn tìm kiếm!");
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
                        String hangXanSuat = diaPhim.getHangSanXuat();
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

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sanPhamSearch = textField1.getText();
                List<Sach> listSach = searchSachById(textField1.getText());
                List<DiaNhac> listDiaNhac = searchDiaNhacById(textField1.getText());
                List<DiaPhim> listDiaPhim = searchDiaPhimById(textField1.getText());
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
                        String hangXanSuat = diaPhim.getHangSanXuat();
                        int namRaMat = diaPhim.getNamRaMat();
                        int soLuong = diaPhim.getSoLuong();
                        double giaBan = diaPhim.getGiaBan();
                        double giaMua = diaPhim.getGiaMua();
                        Object[] row = new Object[]{id, tenDiaPhim, daoDien, bienKich, dienVien, hangXanSuat, namRaMat, soLuong, giaBan, giaMua};
                        defaultTableModel3.addRow(row);
                    }
                }
        });
        DefaultTableModel defaultTableModel4 = new DefaultTableModel();
        table1.setModel(defaultTableModel4);
        defaultTableModel4.addColumn("Id");
        defaultTableModel4.addColumn("Loại sản phẩm");
        defaultTableModel4.addColumn("Tên sản phẩm");
        defaultTableModel4.addColumn("Giá bán");
        defaultTableModel4.addColumn("Số lượng mua");
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel defaultTableModel1 = (DefaultTableModel) table2.getModel();
                int id = parseInt(defaultTableModel1.getValueAt(table2.getSelectedRow(), 0).toString());
                String loaiSanPham = "Sách";
                String tenSanPham = defaultTableModel1.getValueAt(table2.getSelectedRow(), 1).toString();
                double giaBan = Double.parseDouble(defaultTableModel1.getValueAt(table2.getSelectedColumn(), 8).toString());
                String soLuongMua = textField3.getText();
                Sach sach = getSachById(id);
                Object[] row = new Object[]{id,tenSanPham,loaiSanPham,giaBan,soLuongMua};
                defaultTableModel4.addRow(row);
            }
        });
        table3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel defaultTableModel2 = (DefaultTableModel) table3.getModel();
                int id = parseInt(defaultTableModel2.getValueAt(table3.getSelectedRow(), 0).toString());
                String loaiSanPham = "Đĩa nhạc";
                String tenSanPham = defaultTableModel2.getValueAt(table3.getSelectedRow(), 1).toString();
                double giaBan = Double.parseDouble(defaultTableModel2.getValueAt(table3.getSelectedColumn(), 8).toString());
                String soLuongMua = textField3.getText();
                DiaNhac diaNhac = getDiaNhacById(id);
                Object[] row = new Object[]{id,tenSanPham,loaiSanPham,giaBan,soLuongMua};
                defaultTableModel4.addRow(row);
            }
        });
        table4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel defaultTableModel3 = (DefaultTableModel) table4.getModel();
                int id = parseInt(defaultTableModel3.getValueAt(table4.getSelectedRow(), 0).toString());
                String loaiSanPham = "Đĩa phim";
                String tenSanPham = defaultTableModel3.getValueAt(table4.getSelectedRow(), 2).toString();
                double giaBan = Double.parseDouble(defaultTableModel3.getValueAt(table4.getSelectedColumn(), 9).toString());
                String soLuongMua = textField3.getText();
                Sach sach = getSachById(id);
                Object[] row = new Object[]{id,tenSanPham,loaiSanPham,giaBan,soLuongMua};
                defaultTableModel4.addRow(row);
            }
        });

        tínhGiáTrịĐơnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<GioHang> gioHangList = new ArrayList<>();;
                int rows = defaultTableModel4.getRowCount();
                System.out.println(rows);
                for(int i = rows - 1; i >= 0; i--){
                    int idSanPham = parseInt(defaultTableModel4.getValueAt(i, 0).toString());
                    SanPham sanPham = getSanPhamById(idSanPham);
                    int soLuong = parseInt(defaultTableModel4.getValueAt(i,4).toString());
                    GioHang gh = new GioHang(0,0,sanPham,soLuong);
                    gioHangList.add(gh);
                }
                HoaDon hd = new HoaDon(0,parseInt(textField2.getText()),gioHangList);
                giaTriDonHang.setText(valueOf(hd.tinhGiaTriDonHang()));
            }
        });
        thanhToánButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<GioHang> gioHangList = new ArrayList<>();
                int rows = defaultTableModel4.getRowCount();
                for(int i = rows - 1; i >= 0; i--){
                    int idSanPham = parseInt(defaultTableModel4.getValueAt(i, 0).toString());
                    SanPham sanPham = getSanPhamById(idSanPham);
                    int soLuong = parseInt(defaultTableModel4.getValueAt(i,4).toString());
                    GioHang gh = new GioHang(0,0,sanPham,soLuong);
                    gioHangList.add(gh);
                }
                HoaDon hd = new HoaDon(0,parseInt(textField2.getText()),gioHangList);
                insertGioHang(gioHangList,hd);
                giaTriDonHang.setText("0");
                int rows1 = defaultTableModel4.getRowCount();
                for (int i = rows1 - 1; i >= 0; i--) {
                    defaultTableModel4.removeRow(i);
                }
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        NhanVienForm a = new NhanVienForm(null);
    }
}

