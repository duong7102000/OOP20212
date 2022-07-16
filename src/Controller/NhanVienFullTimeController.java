package Controller;

import Model.Account;
import Model.NhanVienFullTime;
import Model.Sach;
import Model.SanPham;
import Util.ConnectionDB;
import Util.NormalizeString;

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
                NhanVienFullTime nhanVienFullTime = new NhanVienFullTime(username,"password","position",ten,namSinh,luongThang);
                Account account = AccountController.getAccountByUsername(username);
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

    public static boolean updateNhanVienFullTime(NhanVienFullTime nhanVienFullTime){
        boolean check = AccountController.updateAccount(nhanVienFullTime.getAccount());
        if (!check) return false;
        String username = nhanVienFullTime.getAccount().getUsername();
        String password = nhanVienFullTime.getAccount().getPassword();
        String position = nhanVienFullTime.getAccount().getPosition();
        String ten = nhanVienFullTime.getTenNhanVien();
        int namSinh = nhanVienFullTime.getNamSinh();
        double luongThang = nhanVienFullTime.getLuongThang();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_nhanvienfulltime set ten = N\'%s\', namSinh = %d, luongThang = %f where username = \'%s\'", ten, namSinh, luongThang, username));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }
    public static List<NhanVienFullTime> searchNvftByName(String tenNhanVien){
        List<NhanVienFullTime> listNvftResult = new ArrayList<>();
        List<NhanVienFullTime> listNvft = NhanVienFullTimeController.getAllNhanVienFullTime();
        if (tenNhanVien == "") return listNvft;
        for (NhanVienFullTime nvft:
                listNvft) {
            if (NormalizeString.normalizeSearchString(nvft.getTenNhanVien()).contains(NormalizeString.normalizeSearchString(tenNhanVien))){
                listNvftResult.add(nvft);
            }
        }
        return listNvftResult;
    }
    public static void main(String[] args) {
        NhanVienFullTime s = new NhanVienFullTime("hadimsc3","12345678","employee full time", "Nguyễn Hà dinoman", 2002,50000);
        System.out.println(NhanVienFullTimeController.insertNhanVienFullTime(s));
    }
}
