import java.sql.*;

public class Select {
    public static void main(String[] args) {
        String sqlUrl="";
        String userName="";
        String password="";

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
