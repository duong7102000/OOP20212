package Controller;

import Model.Sach;
import Util.ConnectionDB;
import Util.NormalizeString;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Util.ConnectionDB;

public class SachController {
    public static List<Sach> getAllBook() {
        Connection connection = ConnectionDB.openConnection();
        List<Sach> listSach = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_sach");
            while (resultSet.next()) {
                double giaMua = Double.parseDouble(resultSet.getString("giaMua"));
                double giaBan = Double.parseDouble(resultSet.getString("giaBan"));
                double soLuong = Double.parseDouble(resultSet.getString("soluong"));
                int namRaMat= Integer.parseInt(resultSet.getString("namramat"));
                String tenSach = resultSet.getString("tensach");
                String nhaXuatBan = resultSet.getString("nhaxuatban");
                String tacGia = resultSet.getString("tacgia");
                String theLoaiSach = resultSet.getString("theloaisach");
                Sach sach = new Sach(giaMua, giaBan, soLuong,namRaMat, tenSach, nhaXuatBan, tacGia, theLoaiSach);
                listSach.add(Sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return listSach;
    }
    public static Sach getSachByTen(String tenSach){
        Connection connection = ConnectionDB.openConnection();
        Sach sach = null;
        try {
            Statement statement = connection.createStatement();

        }
    }
}
