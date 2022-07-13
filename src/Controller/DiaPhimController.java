package Controller;

import Model.DiaNhac;
import Model.DiaPhim;
import Model.SanPham;
import Util.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiaPhimController {
    public static List<DiaPhim> getAllDiaPhim() {
        Connection connection = ConnectionDB.openConnection();
        List<DiaPhim> listDiaPhim = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_diaphim");
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String tenDiaPhim = resultSet.getString("ten");
                String daoDien = resultSet.getString("daoDien");
                String bienKich = resultSet.getString("bienKich");
                String dienVien = resultSet.getString("dienVien");
                String hangXanSuat = resultSet.getString("hangXanSuat");
                DiaPhim diaPhim = new DiaPhim(id, 0.0, 0.0, 0, 0, tenDiaPhim, daoDien, bienKich, dienVien,hangXanSuat);
                SanPham sanPham = SanPhamController.getSanPhamById(id);
                diaPhim.setGiaMua(sanPham.getGiaMua());
                diaPhim.setGiaBan(sanPham.getGiaBan());
                diaPhim.setSoLuong(sanPham.getSoLuong());
                diaPhim.setNamRaMat(sanPham.getNamRaMat());
                listDiaPhim.add(diaPhim);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return listDiaPhim;
    }
    public static DiaPhim getDiaPhimById(int id){
        for (DiaPhim diaPhim:
                DiaPhimController.getAllDiaPhim()) {
            if(diaPhim.getId()==id) return diaPhim;
        }
        return null;
    }

    public static boolean insertDiaPhim(DiaPhim diaPhim){
        boolean check = SanPhamController.insertSanPham(diaPhim);
        if (!check) return false;
        int id = diaPhim.getId();
        String ten = diaPhim.getTenDiaPhim();
        String daoDien= diaPhim.getDaoDien();
        String bienKich= diaPhim.getBienKich();
        String dienVien=diaPhim.getDienVien();
        String hangSanXuat = diaPhim.getHangXanSuat();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_diaphim values (%d, N\'%s\', N\'%s\', N\'%s\', N\'%s\',N\'%s\')", id, ten, daoDien, bienKich, dienVien,hangSanXuat));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean updateDiaPhim(DiaPhim diaPhim){
        boolean check = SanPhamController.updateSanPham(diaPhim);
        if (!check) return false;
        int id = diaPhim.getId();
        String ten = diaPhim.getTenDiaPhim();
        String daoDien = diaPhim.getDaoDien();
        String bienKich = diaPhim.getBienKich();
        String dienVien = diaPhim.getDienVien();
        String hangXanSuat = diaPhim.getHangXanSuat();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_diaphim set ten = N\'%s\', daoDien = N\'%s\', bienKich = N\'%s\', dienVien = N\'%s\', hangSanXuat= N\'%s\' where id = %d", ten, daoDien, bienKich, dienVien, hangXanSuat));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean deleteDiaPhimById(int id){
        boolean check = false;
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("delete from tbl_diaphim where id = %d", id));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        check = SanPhamController.deleteSanPhamById(id);
        return check;
    }
}
