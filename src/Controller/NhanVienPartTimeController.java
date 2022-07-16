package Controller;

import Model.*;
import Util.ConnectionDB;
import Util.NormalizeString;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienPartTimeController {
    public static List<NhanVienPartTime> getAllNhanVienPartTime(){
        Connection connection = ConnectionDB.openConnection();
        List<NhanVienPartTime> listNhanVienPartTime = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_nhanvienparttime");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String ten = resultSet.getString("ten");
                int namSinh = Integer.parseInt(resultSet.getString("namSinh"));
                double luongTheoGio = Double.parseDouble(resultSet.getString("luongTheoGio"));
                int gioLam = Integer.parseInt(resultSet.getString("gioLam"));
                NhanVienPartTime nhanVienPartTime = new NhanVienPartTime(username,"password","position",ten,namSinh,luongTheoGio,gioLam);
                Account account = AccountController.getAccountByUsername(username);
                nhanVienPartTime.setTenNhanVien(ten);
                nhanVienPartTime.setNamSinh(namSinh);
                nhanVienPartTime.setLuongTheoGio(luongTheoGio);
                nhanVienPartTime.setGioLam(gioLam);
                listNhanVienPartTime.add(nhanVienPartTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return listNhanVienPartTime;
    }

    public static NhanVienPartTime getNhanVienPartTimeByUsername(String username){
        List<NhanVienPartTime> nhanVienPartTimeList = NhanVienPartTimeController.getAllNhanVienPartTime();
        for (NhanVienPartTime nv:
                nhanVienPartTimeList) {
            if(username.equals(nv.getAccount().getUsername())) return nv;
        }
        return null;
    }
    public static boolean insertNhanVienPartTime(NhanVienPartTime nhanVienPartTime){
        boolean check = AccountController.insertAccount(nhanVienPartTime.getAccount());
        if (!check) return false;
        String username = nhanVienPartTime.getAccount().getUsername();
        String ten = nhanVienPartTime.getTenNhanVien();
        int namSinh = nhanVienPartTime.getNamSinh();
        double luongTheoGio = nhanVienPartTime.getLuongTheoGio();
        int gioLam = nhanVienPartTime.getGioLam();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_nhanvienparttime values (\'%s\', N\'%s\', %d, %f, %d)", username, ten, namSinh, luongTheoGio, gioLam));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean updateNhanVienPartTime(NhanVienPartTime nhanVienPartTime){
        boolean check = AccountController.updateAccount(nhanVienPartTime.getAccount());
        if (!check) return false;
        String username = nhanVienPartTime.getAccount().getUsername();
        String ten = nhanVienPartTime.getTenNhanVien();
        int namSinh = nhanVienPartTime.getNamSinh();
        double luongTheoGio = nhanVienPartTime.getLuongTheoGio();
        int gioLam = nhanVienPartTime.getGioLam();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_nhanvienparttime set ten = N\'%s\', namSinh = %d, luongTheoGio = %f, gioLam=%d where username = \'%s\'", ten, namSinh, luongTheoGio,gioLam, username));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }
    public static List<NhanVienPartTime> searchNvptByName(String tenNhanVien){
        List<NhanVienPartTime> listNvptResult = new ArrayList<>();
        List<NhanVienPartTime> listNvpt = NhanVienPartTimeController.getAllNhanVienPartTime();
        if (tenNhanVien == "") return listNvpt;
        for (NhanVienPartTime nvpt:
                listNvpt) {
            if (NormalizeString.normalizeSearchString(nvpt.getTenNhanVien()).contains(NormalizeString.normalizeSearchString(tenNhanVien))){
                listNvptResult.add(nvpt);
            }
        }
        return listNvptResult;
    }
    public static void main(String[] args) {
        NhanVienPartTime s = new NhanVienPartTime("Dinoman1","12345678","admin", "Nguyễn Hà pro", 2002,50000,5);
        System.out.println(NhanVienPartTimeController.searchNvptByName("duong gay"));
    }
}