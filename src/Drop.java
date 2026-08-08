import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Drop {
    public static void main(String[] args) {
        String sqlUrl="";
        String userName="";
        String password="";

        try(Connection c= DriverManager.getConnection(sqlUrl,userName,password); Statement s=c.createStatement()){

            s.executeUpdate("DROP DATABASE college");

            System.out.println("Database Droped");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
