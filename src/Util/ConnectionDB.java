package Util;

import java.sql.*;

public class ConnectionDB {
    public static String URL = "jdbc:mysql://localhost:3306/dump20220720";
    public static String USER = "root";
    public static String PASSWORD = "12345678";

    public static Connection openConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if(conn!=null) {
            try {
                conn.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
    }
}