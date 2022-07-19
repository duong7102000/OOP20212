package Controller;

import Model.*;
import Util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Controller.SanPhamController.getSanPhamById;
import static java.lang.Integer.parseInt;

public class GioHangController {
    public static List<GioHang> getAllGioHang(){
        Connection connection = ConnectionDB.openConnection();
        List<GioHang> listGioHang = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_giohang");
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                int hoaDonId = Integer.parseInt(resultSet.getString("hoadon_id"));
                int sanPhamId = Integer.parseInt(resultSet.getString("sanpham_id"));
                int soLuong = Integer.parseInt(resultSet.getString("soluong"));
                SanPham sanPham = getSanPhamById(sanPhamId);
                GioHang gioHang = new GioHang(id, hoaDonId, sanPham, soLuong);
                listGioHang.add(gioHang);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return listGioHang;
    }

    public static List<GioHang> getListGioHangByHoaDonId(int id){
        List<GioHang> listGioHang = new ArrayList<>();
        for (GioHang gioHang:
             GioHangController.getAllGioHang()) {
            if(gioHang.getHoaDonId()==id) listGioHang.add(gioHang);
        }
        return listGioHang;
    }
    public static boolean insertGioHang(List<GioHang> gioHangList,HoaDon hoaDon){
        boolean check = HoaDonController.insertHoaDon(hoaDon);
        if (!check) return false;
        List<GioHang> listGioHang = GioHangController.getAllGioHang();
        int firstId = 0;
        if(!listGioHang.isEmpty()){
            firstId = listGioHang.get(listGioHang.size() - 1).getId() + 1;
        }
        for (GioHang gh :gioHangList) {
            gh.setId(firstId);
            firstId++;
            int id = gh.getId();
            int idSanPham = gh.getSanPham().getId();
            int idHoaDon = hoaDon.getId();
            int soLuong = gh.getSoLuong();
            Connection connection = ConnectionDB.openConnection();
            try {
                CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_giohang values (%d, %d,%d,%d)", id, idHoaDon,idSanPham,soLuong));
                check = !callableStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionDB.closeConnection(connection);
            }
        }
        return check;
    }
    public static void main(String[] args) {
        List<GioHang> gioHangList = new ArrayList<>();
        Sach sach = new Sach(5, 20000, 35000, 100, 2016, "Truyen vui", "Kim Đồng", "Văn A", "Truyện");
        GioHang gh = new GioHang(0,0,sach,10);
        GioHang gh1 = new GioHang(0,0,sach,10);
        gioHangList.add(gh);
        gioHangList.add(gh1);
        HoaDon hd = new HoaDon(0,0,gioHangList);
        System.out.println(GioHangController.getListGioHangByHoaDonId(3));
    }
}
