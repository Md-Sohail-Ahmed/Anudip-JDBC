import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        String sqlUrl="";
        String userName="";
        String password="";

        try(Connection c= DriverManager.getConnection(sqlUrl,userName,password); Statement s=c.createStatement()){

//            s.execute("CREATE TABLE employee(id INT PRIMARY KEY, name VARCHAR(50), email VARCHAR(50));");
//            System.out.println("table created");
//
//            s.executeUpdate("INSERT INTO employee(id,name,email)VALUES(1,'sohail','sohail@gmail.com'),"+
//                    "(2,'mayur','mayur@gmail.com'),(3,'surajit','surajit@gmail.com');");
//
//            System.out.println("data inserted");
            s.executeUpdate("update employee set email='sohailmj333@gmail' where id=1;");
            System.out.println("updated");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
