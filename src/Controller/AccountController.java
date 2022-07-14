package Controller;

import Model.Account;
import Model.QuanLy;
import Util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountController {
    public static List<Account> getAllAccount(){
        Connection connection = ConnectionDB.openConnection();
        List<Account> listAccount = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_taikhoan");
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String position = resultSet.getString("position");
                Account account = new Account(username, password, position);
                listAccount.add(account);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return listAccount;
    }

    public static Account getAccountByUsername(String username){
        Connection connection = ConnectionDB.openConnection();
        Account account = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("select * from tbl_taikhoan where username = \'%s\'", username));
            if (resultSet.next()){
                String password = resultSet.getString("password");
                String position = resultSet.getString("position");
                account = new Account(username, password, position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return account;
    }

    public static boolean updateAccount(Account account){
        Connection connection = ConnectionDB.openConnection();
        boolean check = false;
        String username = account.getUsername();
        String password = account.getPassword();
        String position = account.getPosition();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("update tbl_taikhoan set password = \'%s\', position = \'%s\' where username = \'%s\'", password, position, username));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean insertAccount(Account account){
        Connection connection = ConnectionDB.openConnection();
        boolean check = false;
        String username = account.getUsername();
        String password = account.getPassword();
        String position = account.getPosition();
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("insert into tbl_taikhoan values (\'%s\', \'%s\', \'%s\')", username, password, position));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static boolean deleteAccountByUsername(String username){
        Connection connection = ConnectionDB.openConnection();
        boolean check = false;
        try {
            CallableStatement callableStatement = connection.prepareCall(String.format("delete from tbl_taikhoan where username = %s", username));
            check = !callableStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    public static Account logIn(String username, String password){
        Account account = AccountController.getAccountByUsername(username);
        if (account == null) return null;
        if (account.getPassword().equals(password)) return account;
        else return null;
    }

    public static boolean changePassword(String username, String oldPass, String newPass){
        Account account = AccountController.getAccountByUsername(username);
        if (account == null) return false;
        if (oldPass != account.getPassword()) return false;
        else {
            account.setPassword(newPass);
            return updateAccount(account);
        }
    }
    public static void main(String[] args) {
        for (Account a:
                AccountController.getAllAccount()) {
            System.out.println(a.getUsername());
        }
    }

}