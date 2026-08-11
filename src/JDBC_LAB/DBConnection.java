package JDBC_LAB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static void main(String[] args) {
        String url="";
        String userName="";
        String password="";

        try(Connection c= DriverManager.getConnection(url,userName,password);){
            System.out.println("DB connected");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
