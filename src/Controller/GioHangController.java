package Controller;

import Model.*;
import Util.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                SanPham sanPham = null;
                for (Sach s:
                     SachController.getAllSach()) {
                    if(s.getId()==sanPhamId) sanPham = s;
                }
                for (DiaNhac diaNhac:
                     DiaNhacController.getAllDiaNhac()) {
                    if(diaNhac.getId()==sanPhamId) sanPham = diaNhac;
                }
                for (DiaPhim diaPhim:
                     DiaPhimController.getAllDiaPhim()) {
                    if(diaPhim.getId()==sanPhamId) sanPham = diaPhim;
                }
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

    public static boolean insertGioHang(int hoaDonId, SanPham sanPham){
        return false;
    }
}
