package Controller;

import Model.HoaDon;
import Model.SanPham;
import Util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonController {
    public static List<HoaDon> getAllHoaDon(){
        Connection connection = ConnectionDB.openConnection();
        List<HoaDon> listHoaDon = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_hoadon");
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                int discount = Integer.parseInt(resultSet.getString("discount"));
                double giaTriDonHang= Double.parseDouble(resultSet.getString("giaTriDonHang"));
                HoaDon hoaDon = new HoaDon(id, discount, GioHangController.getListGioHangByHoaDonId(id));
                listHoaDon.add(hoaDon);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return listHoaDon;
    }
    public static boolean insertHoaDon(HoaDon hoaDon){
        Connection connection = ConnectionDB.openConnection();
        boolean check = false;
        List<HoaDon> listHoaDon = HoaDonController.getAllHoaDon();
        if(listHoaDon.size()==0) hoaDon.setId(1);
        else hoaDon.setId(listHoaDon.get(listHoaDon.size()-1).getId() + 1);
        int id = hoaDon.getId();
        int discount = hoaDon.getDiscount();
        double giaTriDonHang= hoaDon.tinhGiaTriDonHang();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_hoadon values (%d, %d, %f)", id ,discount,giaTriDonHang));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

}
