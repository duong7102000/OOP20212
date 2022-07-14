package Controller;

import Model.HoaDon;
import Util.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
                String tenKhachHang = resultSet.getString("tenKhachHang");
                int discount = Integer.parseInt(resultSet.getString("position"));
                HoaDon hoaDon = new HoaDon(id, tenKhachHang, discount, GioHangController.getListGioHangByHoaDonId(id));
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

    public static int insertHoaDon(HoaDon hoaDon){
        return 0;
    }
}
