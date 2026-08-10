import java.sql.*;

public class PreparedStat {
    public static void main(String[] args){
        String sqlUrl="";
        String userName="";
        String password="";
        String query="insert into employee(id,name,email) values(?,?,?)";
        try(Connection c= DriverManager.getConnection(sqlUrl,userName,password);
            PreparedStatement ps= c.prepareStatement(query)){
            ps.setInt(1,4);
            ps.setString(2,"ahmed");
            ps.setString(3,"ahmed@gmail.com");
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
