import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/college";
        String userName="root";
        String password="sohail@25017";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,userName,password);
            Statement s=connection.createStatement();

            s.executeUpdate("INSERT INTO Students (id,name,age,class) VALUES(1,'sohail',23,'CSE-B'),(2,'mayur',22,'CSE-B'),(3,'surajit',22,'CSE-C');");

            System.out.println("Data inserted");

            s.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
