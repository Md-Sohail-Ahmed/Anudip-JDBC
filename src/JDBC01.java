import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC01 {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/jdbcFirstProject";
        String userName="root";
        String password="sohail@25017";

        try (Connection connection = DriverManager.getConnection(jdbcUrl,userName,password)){
            System.out.println("Database connected successfully!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
