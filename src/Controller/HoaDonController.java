package Controller;

import Model.GioHang;
import Model.HoaDon;
import Model.SanPham;
import Util.ConnectionDB;
import Util.GetDate;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
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
                Date date = resultSet.getDate("date");
                HoaDon hoaDon = new HoaDon(id, discount, GioHangController.getListGioHangByHoaDonId(id));
                hoaDon.setDate(date);
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
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_hoadon values (%d, %d, %f, \'%s\')", id ,discount,giaTriDonHang, GetDate.getCurrentDate()));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static List<HoaDon> getAllHoaDonTheoThang(int month, int year){
        Calendar cal = Calendar.getInstance();
        List<HoaDon> hoaDonList = new ArrayList<>();
        for (HoaDon hd:
             HoaDonController.getAllHoaDon()) {
            if(hd.getDate()==null) continue;
            cal.setTime(hd.getDate());
            if(cal.get(Calendar.MONTH)==(month-1) && cal.get(Calendar.YEAR)==year){
                hoaDonList.add(hd);
            }
        }
        return hoaDonList;
    }
    public static void main(String[] args) {
        List<GioHang> gioHangList = new ArrayList<>();
        HoaDon hd = new HoaDon(12, 50,gioHangList);
        hd.setDate(GetDate.getCurrentDate());
        for (HoaDon hd1:
             HoaDonController.getAllHoaDonTheoThang(7,2022)) {
            System.out.println(hd1.getId());
        }
    }
}
