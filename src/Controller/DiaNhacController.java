package Controller;

import Model.DiaNhac;
import Model.Sach;
import Model.SanPham;
import Util.ConnectionDB;
import Util.NormalizeString;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class DiaNhacController {
    public static List<DiaNhac> getAllDiaNhac() {
        Connection connection = ConnectionDB.openConnection();
        List<DiaNhac> listDiaNhac = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_dianhac");
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String tenDiaNhac = resultSet.getString("ten");
                String theLoaiNhac = resultSet.getString("theLoaiNhac");
                String caSy = resultSet.getString("caSy");
                String album = resultSet.getString("album");
                DiaNhac diaNhac = new DiaNhac(id, 0.0, 0.0, 0, 0, tenDiaNhac, caSy, theLoaiNhac, album);
                SanPham sanPham = SanPhamController.getSanPhamById(id);
                diaNhac.setGiaMua(sanPham.getGiaMua());
                diaNhac.setGiaBan(sanPham.getGiaBan());
                diaNhac.setSoLuong(sanPham.getSoLuong());
                diaNhac.setNamRaMat(sanPham.getNamRaMat());
                listDiaNhac.add(diaNhac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return listDiaNhac;
    }
    public static DiaNhac getDiaNhacById(int id){
        for (DiaNhac diaNhac:
                DiaNhacController.getAllDiaNhac()) {
            if(diaNhac.getId()==id) return diaNhac;
        }
        return null;
    }

    public static boolean insertDiaNhac(DiaNhac diaNhac){
        boolean check = SanPhamController.insertSanPham(diaNhac);
        if (!check) return false;
        int id = diaNhac.getId();
        String ten = diaNhac.getTenDiaNhac();;
        String caSy = diaNhac.getCaSy();
        String theLoaiNhac = diaNhac.getTheLoaiNhac();
        String album = diaNhac.getAlbum();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_dianhac values (%d, N\'%s\', N\'%s\', N\'%s\', N\'%s\')", id, ten, caSy, theLoaiNhac, album));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean updateDiaNhac(DiaNhac diaNhac){
        boolean check = SanPhamController.updateSanPham(diaNhac);
        if (!check) return false;
        int id = diaNhac.getId();
        String ten = diaNhac.getTenDiaNhac();;
        String caSy = diaNhac.getCaSy();
        String theLoaiNhac = diaNhac.getTheLoaiNhac();
        String album = diaNhac.getAlbum();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_dianhac set ten = N\'%s\', caSy = N\'%s\', theLoaiNhac = N\'%s\', album = N\'%s\' where id = %d", ten, caSy, theLoaiNhac, album, id));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean deleteDiaNhacById(int id){
        boolean check = false;
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("delete from tbl_dianhac where id = %d", id));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        check = SanPhamController.deleteSanPhamById(id);
        return check;
    }
    public static List<DiaNhac> searchDiaNhacByName(String tenDiaNhac){
        List<DiaNhac> listDiaNhacResult = new ArrayList<>();
        List<DiaNhac> listDiaNhac = DiaNhacController.getAllDiaNhac();
        if (tenDiaNhac == "") return listDiaNhac;
        for (DiaNhac diaNhac:
                listDiaNhac) {
            if (NormalizeString.normalizeSearchString(diaNhac.getTenDiaNhac()).contains(NormalizeString.normalizeSearchString(tenDiaNhac))){
                listDiaNhacResult.add(diaNhac);
            }
        }
        return listDiaNhacResult;
    }
    public static List<DiaNhac> searchDiaNhacById(String id){
        List<DiaNhac> listDiaNhacResult = new ArrayList<>();
        List<DiaNhac> listDiaNhac = DiaNhacController.getAllDiaNhac();
        if (id == "") return listDiaNhac;
        for (DiaNhac diaNhac:
                listDiaNhac) {
            if (NormalizeString.normalizeSearchString(valueOf(diaNhac.getId())).contains(NormalizeString.normalizeSearchString(id))){
                listDiaNhacResult.add(diaNhac);
            }
        }
        return listDiaNhacResult;
    }

    public static void main(String[] args) {
        DiaNhac diaNhac = new DiaNhac(6, 20000, 35000, 100, 2020, "Truyen vui", "Kim Đồng", "Văn A", "Truyện");
        System.out.println(DiaNhacController.insertDiaNhac(diaNhac));
    }
}

