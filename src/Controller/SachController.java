package Controller;

import Model.Sach;
import Model.SanPham;
import Util.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachController {
    public static List<Sach> getAllSach() {
        Connection connection = ConnectionDB.openConnection();
        List<Sach> listSach = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_sach");
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String tenSach = resultSet.getString("ten");
                String nhaXuatBan = resultSet.getString("nhaXuatBan");
                String tacGia = resultSet.getString("tacGia");
                String theLoaiSach = resultSet.getString("theLoai");
                Sach sach = new Sach(id, 0.0, 0.0, 0, 0, tenSach, nhaXuatBan, tacGia, theLoaiSach);
                SanPham sanPham = SanPhamController.getSanPhamById(id);
                sach.setGiaMua(sanPham.getGiaMua());
                sach.setGiaBan(sanPham.getGiaBan());
                sach.setSoLuong(sanPham.getSoLuong());
                sach.setNamRaMat(sanPham.getNamRaMat());
                listSach.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return listSach;
    }
    public static Sach getSachById(int id){
        for (Sach sach:
             SachController.getAllSach()) {
            if(sach.getId()==id) return sach;
        }
        return null;
    }

    public static boolean insertSach(Sach sach){
        boolean check = SanPhamController.insertSanPham(sach);
        if (!check) return false;
        int id = sach.getId();
        String ten = sach.getTenSach();;
        String tacGia = sach.getTacGia();
        String nhaXuatBan = sach.getNhaXuatBan();
        String theLoai = sach.getTheLoaiSach();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_sach values (%d, N\'%s\', N\'%s\', N\'%s\', N\'%s\')", id, ten, nhaXuatBan, tacGia, theLoai));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean updateSach(Sach sach){
        boolean check = SanPhamController.updateSanPham(sach);
        if (!check) return false;
        int id = sach.getId();
        String ten = sach.getTenSach();;
        String tacGia = sach.getTacGia();
        String nhaXuatBan = sach.getNhaXuatBan();
        String theLoai = sach.getTheLoaiSach();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_sach set ten = N\'%s\', tacGia = N\'%s\', nhaXuatBan = N\'%s\', theLoai = N\'%s\' where id = %d", ten, nhaXuatBan, tacGia, theLoai, id));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean deleteSachById(int id){
        boolean check = SanPhamController.deleteSanPhamById(id);
        if(!check) return false;
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("delete from tbl_sach where id = %d", id));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static void main(String[] args) {
        Sach sach = new Sach(1, 30000, 35000, 100, 2016, "Truyen cuoi", "Kim Đồng", "Văn A", "Truyện");
        System.out.println(SachController.updateSach(sach));
    }
}
