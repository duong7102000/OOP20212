package Controller;
import Model.SanPham;
import Util.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamController {
    public static List<SanPham> getAllSanPham(){
        Connection connection = ConnectionDB.openConnection();
        List<SanPham> listSanPham = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_sanpham");
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                double giaMua = Double.parseDouble(resultSet.getString("giaMua"));
                double giaBan = Double.parseDouble(resultSet.getString("giaBan"));
                int soLuong = Integer.parseInt(resultSet.getString("soLuong"));
                int namRaMat = Integer.parseInt(resultSet.getString("namRaMat"));
                SanPham sanPham = new SanPham(id, giaMua, giaBan, soLuong, namRaMat);
                listSanPham.add(sanPham);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return listSanPham;
    }

    public static SanPham getSanPhamById(int id){
        for (SanPham sanPham:
             SanPhamController.getAllSanPham()) {
            if(sanPham.getId()==id) return sanPham;
        }
        return null;
    }

    public static boolean updateSanPham(SanPham sanPham){
        Connection connection = ConnectionDB.openConnection();
        boolean check = false;
        int id = sanPham.getId();
        Double giaMua = sanPham.getGiaMua();
        Double giaBan = sanPham.getGiaBan();
        int soLuong = sanPham.getSoLuong();
        int namRaMat = sanPham.getNamRaMat();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_sanpham set giaMua = %f, giaBan = %f, soLuong = %d, namRaMat = %d where id = %d", giaMua, giaBan, soLuong, namRaMat, id));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean insertSanPham(SanPham sanPham){
        Connection connection = ConnectionDB.openConnection();
        boolean check = false;
        List<SanPham> listSanPham = SanPhamController.getAllSanPham();
        if(listSanPham.size()==0) sanPham.setId(1);
        else sanPham.setId(listSanPham.get(listSanPham.size()-1).getId() + 1);
        int id = sanPham.getId();
        Double giaMua = sanPham.getGiaMua();
        Double giaBan = sanPham.getGiaBan();
        int soLuong = sanPham.getSoLuong();
        int namRaMat = sanPham.getNamRaMat();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_sanpham values (%d, %f, %f, %d, %d)", id, giaMua, giaBan, soLuong, namRaMat));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean deleteSanPhamById(int id){
        Connection connection = ConnectionDB.openConnection();
        boolean check = false;
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("delete from tbl_sanpham where id = %d", id));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static void main(String[] args) {
        SanPham s = new SanPham(4, 30000, 35000, 100, 2015);
        System.out.println(getSanPhamById(13));
    }
}
