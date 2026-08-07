import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Collage {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/college";
        String userName="root";
        String password="sohail@25017";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,userName,password);
            Statement s=connection.createStatement();
            System.out.println("Database connected successfully!");

            String table="CREATE TABLE Students(id INT PRIMARY KEY, name VARCHAR(50), age INT)";
            s.executeUpdate(table);

            System.out.println("table created");

            s.executeUpdate("ALTER TABLE Students\n" +
                    "ADD class varchar(10);");

            System.out.println("table altered");



            s.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
