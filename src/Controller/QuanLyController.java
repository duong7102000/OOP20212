package Controller;

import Model.Account;
import Model.NhanVienFullTime;
import Model.QuanLy;
import Util.ConnectionDB;
import Util.NormalizeString;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Controller.AccountController.deleteAccountByUsername;

public class QuanLyController {
    public static List<QuanLy> getAllQuanLy(){
        Connection connection = ConnectionDB.openConnection();
        List<QuanLy> listQuanLy = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_quanly");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String ten = resultSet.getString("ten");
                int namSinh = Integer.parseInt(resultSet.getString("namSinh"));
                double luongThang = Double.parseDouble(resultSet.getString("luongThang"));
                Account account = AccountController.getAccountByUsername(username);
                QuanLy quanLy = new QuanLy(account,ten,namSinh,luongThang);
                quanLy.setAccount(account);
                quanLy.setTenNhanVien(ten);
                quanLy.setNamSinh(namSinh);
                quanLy.setLuongThang(luongThang);
                listQuanLy.add(quanLy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return listQuanLy;
    }

    public static QuanLy getQuanLyByUsername(String username){
        List<QuanLy> quanLyList = QuanLyController.getAllQuanLy();
        for (QuanLy nv:
                quanLyList) {
            if(username.equals(nv.getAccount().getUsername())) return nv;
        }
        return null;
    }
    public static boolean insertQuanLy(QuanLy quanLy){
        boolean check = AccountController.insertAccount(quanLy.getAccount());
        if (!check) return false;
        String username = quanLy.getAccount().getUsername();
        String ten = quanLy.getTenNhanVien();
        int namSinh = quanLy.getNamSinh();
        double luongThang = quanLy.getLuongThang();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_quanly values (\'%s\', N\'%s\', %d, %f)", username, ten, namSinh, luongThang));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean updateQuanLy(QuanLy quanLy){
        boolean check = AccountController.updateAccount(quanLy.getAccount());
        if (!check) return false;
        String username = quanLy.getAccount().getUsername();
        String password = quanLy.getAccount().getPassword();
        String position = quanLy.getAccount().getPosition();
        String ten = quanLy.getTenNhanVien();
        int namSinh = quanLy.getNamSinh();
        double luongThang = quanLy.getLuongThang();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_quanly set ten = N\'%s\', namSinh = %d, luongThang = %f where username = \'%s\'", ten, namSinh, luongThang, username));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }
    public static boolean deleteQuanLyByUsername(String username){
        deleteAccountByUsername(username);
        boolean check = false;
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("delete from tbl_quanly where username = \'%s\'", username));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        check = deleteAccountByUsername(username);
        return check;
    }
    public static List<QuanLy> searchQuanLyByName(String tenNhanVien){
        List<QuanLy> listQuanLyResult = new ArrayList<>();
        List<QuanLy> listQuanLy = QuanLyController.getAllQuanLy();
        if (tenNhanVien == "") return listQuanLy;
        for (QuanLy ql: listQuanLy) {
            if (NormalizeString.normalizeSearchString(ql.getTenNhanVien()).contains(NormalizeString.normalizeSearchString(tenNhanVien))){
                listQuanLyResult.add(ql);
            }
        }
        return listQuanLyResult;
    }
    public static void main(String[] args) {
        List<QuanLy> listQuanLy = getAllQuanLy();
        for (QuanLy ql:
                listQuanLy) {
            System.out.println(ql.getAccount().getUsername());
        }
    }
}