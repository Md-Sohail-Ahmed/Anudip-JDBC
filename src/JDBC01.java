import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC01 {
    public static void main(String[] args) {
        String jdbcUrl="";
        String userName="";
        String password="";

        try (Connection connection = DriverManager.getConnection(jdbcUrl,userName,password)){
            System.out.println("Database connected successfully!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
