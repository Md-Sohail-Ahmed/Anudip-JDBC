import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    public static void main(String[] args) {
        String sqlUrl="";
        String userName="";
        String password="";

        try(Connection c= DriverManager.getConnection(sqlUrl,userName,password); Statement s=c.createStatement()){

            s.executeUpdate("Delete from employee where id=2");
            System.out.println("deleted");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
