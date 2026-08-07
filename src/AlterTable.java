import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterTable {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/college";
        String userName="root";
        String password="sohail@25017";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,userName,password);
            Statement s=connection.createStatement();

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
