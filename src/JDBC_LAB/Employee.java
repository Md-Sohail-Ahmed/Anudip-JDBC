package JDBC_LAB;

import java.sql.*;

public class Employee {
    public static void main(String[] args) {
        String url="";
        String userName="";
        String password="";

        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            Statement s=connection.createStatement();
            System.out.println("Database connected successfully!");

            String sql="insert into employee(id,name,email)values(6,'sohail','sohail@gmail.com')";
            s.executeUpdate(sql);

            System.out.println("data inserted");
            System.out.println("--------------------------");

            ResultSet rs=s.executeQuery("select * from employee");
            System.out.println("All Employees:");
            while(rs.next()){
                int id= rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");

                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("Email : "+email);
                System.out.println("-------------------------");
            }

            s.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
