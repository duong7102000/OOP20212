package Controller;

import Model.Account;
import Model.NhanVienFullTime;
import Model.Sach;
import Model.SanPham;
import Util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienFullTimeController {
    public static List<NhanVienFullTime> getAllNhanVienFullTime(){
        Connection connection = ConnectionDB.openConnection();
        List<NhanVienFullTime> listNhanVienFullTime = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_nhanvienfulltime");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String ten = resultSet.getString("ten");
                int namSinh = Integer.parseInt(resultSet.getString("namSinh"));
                double luongThang = Double.parseDouble(resultSet.getString("luongThang"));
                Account account = AccountController.getAccountByUsername(username);
                NhanVienFullTime nhanVienFullTime = new NhanVienFullTime();
                nhanVienFullTime.setAccount(account);
                nhanVienFullTime.setTenNhanVien(ten);
                nhanVienFullTime.setNamSinh(namSinh);
                nhanVienFullTime.setLuongThang(luongThang);
                listNhanVienFullTime.add(nhanVienFullTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return listNhanVienFullTime;
    }

    public static NhanVienFullTime getNhanVienFullTimeByUsername(String username){
        List<NhanVienFullTime> nhanVienFullTimeList = NhanVienFullTimeController.getAllNhanVienFullTime();
        for (NhanVienFullTime nv:
             nhanVienFullTimeList) {
            if(username.equals(nv.getAccount().getUsername())) return nv;
        }
        return null;
    }
    public static boolean insertNhanVienFullTime(NhanVienFullTime nhanVienFullTime){
        boolean check = AccountController.insertAccount(nhanVienFullTime.getAccount());
        if (!check) return false;
        String username = nhanVienFullTime.getAccount().getUsername();
        String ten = nhanVienFullTime.getTenNhanVien();
        int namSinh = nhanVienFullTime.getNamSinh();
        double luongThang = nhanVienFullTime.getLuongThang();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_nhanvienfulltime values (\'%s\', N\'%s\', %d, %f)", username, ten, namSinh, luongThang));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    private static boolean updateNhanVienFullTime(NhanVienFullTime nhanVienFullTime){
        boolean check = AccountController.updateAccount(nhanVienFullTime.getAccount());
        if (!check) return false;
        String username = nhanVienFullTime.getAccount().getUsername();
        String ten = nhanVienFullTime.getTenNhanVien();
        int namSinh = nhanVienFullTime.getNamSinh();
        double luongThang = nhanVienFullTime.getLuongThang();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_nhanvienfulltime set ten = N\'%s\', namSinh = %d, luongThang = %f where usename = \'%s\'", ten, namSinh, luongThang, username));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }
}
