package Controller;

import Model.DiaNhac;
import Model.DiaPhim;
import Model.Sach;
import Model.SanPham;
import Util.ConnectionDB;
import Util.NormalizeString;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

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
                String hangSanXuat = resultSet.getString("hangSanXuat");
                DiaPhim diaPhim = new DiaPhim(id, 0.0, 0.0, 0, 0, tenDiaPhim, daoDien, bienKich, dienVien,hangSanXuat);
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
        String hangSanXuat = diaPhim.getHangSanXuat();
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
        String hangSanXuat = diaPhim.getHangSanXuat();
        Connection connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_diaphim set ten = N\'%s\', daoDien = N\'%s\', bienKich = N\'%s\', dienVien = N\'%s\', hangSanXuat= N\'%s\' where id = %d", ten, daoDien, bienKich, dienVien, hangSanXuat,id));
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
    public static List<DiaPhim> searchDiaPhimByName(String tenDiaPhim){
        List<DiaPhim> listDiaPhimResult = new ArrayList<>();
        List<DiaPhim> listDiaPhim = DiaPhimController.getAllDiaPhim();
        if (tenDiaPhim == "") return listDiaPhim;
        for (DiaPhim diaPhim:
                listDiaPhim) {
            if (NormalizeString.normalizeSearchString(diaPhim.getTenDiaPhim()).contains(NormalizeString.normalizeSearchString(tenDiaPhim))){
                listDiaPhimResult.add(diaPhim);
            }
        }
        return listDiaPhimResult;
    }
    public static List<DiaPhim> searchDiaPhimById(String id){
        List<DiaPhim> listDiaPhimResult = new ArrayList<>();
        List<DiaPhim> listDiaPhim = DiaPhimController.getAllDiaPhim();
        if (id == "") return listDiaPhim;
        for (DiaPhim diaPhim:
                listDiaPhim) {
            if (NormalizeString.normalizeSearchString(valueOf(diaPhim.getId())).contains(NormalizeString.normalizeSearchString(id))){
                listDiaPhimResult.add(diaPhim);
            }
        }
        return listDiaPhimResult;
    }
    public static void main(String[] args) {
        DiaPhim s = new DiaPhim(5, 20000, 35000, 100, 2016, "Truyen vui", "Kim Đồng", "Văn A", "Truyện", "abc");
        System.out.println(DiaPhimController.getAllDiaPhim());
    }
}
