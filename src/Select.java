import java.sql.*;

public class Select {
    public static void main(String[] args) {
        String sqlUrl="jdbc:mysql://localhost:3306/jdbcFirstProject";
        String userName="root";
        String password="sohail@25017";

        try(Connection c= DriverManager.getConnection(sqlUrl,userName,password); Statement s=c.createStatement()){

            ResultSet st=s.executeQuery("select * from employee");
            while(st.next()){
                int id=st.getInt("id");
                String name= st.getString("name");
                String email=st.getString("email");

                System.out.println("ID : "+id+", Name : "+name+", Email : "+email);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
