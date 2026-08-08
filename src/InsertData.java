import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        String jdbcUrl="";
        String userName="";
        String password="";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,userName,password);
            Statement s=connection.createStatement();

            s.executeUpdate("INSERT INTO employee (id,name,email) VALUES(2,'mayur','mayur@gmail.com'),(3,'surajit','surajit@gmail.com');");

            System.out.println("Data inserted");

            s.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
