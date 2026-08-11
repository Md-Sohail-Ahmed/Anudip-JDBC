package UserDemo;

import com.sun.tools.javac.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Open o=new Open();
            while(true){
                System.out.println("1.Add User");
                System.out.println("2.View All Users");
                System.out.println("3.Search User");
                System.out.println("4.Delete User");
                System.out.println("0.exit");
                Scanner sc=new Scanner(System.in);
                int choice=sc.nextInt();
                switch (choice){
                    case 1 :
                        sc.nextLine();
                        System.out.println("Enter User Name:");
                        String name=sc.nextLine();
                        System.out.println("Enter Email");
                        String email=sc.nextLine();

                        User user=new User(name,email);
                        o.addUser(user);
                        break;
                    case 2 :
                        List<User> u=o.getAllUser();
                        for(User ue:u){
                            System.out.println(ue);
                        }
                        break;
                    case 3 :
                        sc.nextLine();
                        System.out.println("Enter ID");
                        int id=sc.nextInt();
                        User got=o.getUserById(id);
                        System.out.println(got);
                        break;
                    case 4 :
                        sc.nextLine();
                        System.out.println("Enter ID");
                        int deleteId=sc.nextInt();
                        o.getUserById(deleteId);
                        System.out.println("User Deleted");
                        break;
                    case 0 :
                        return;
                }
            }

    }
}

class Open implements UserDAO{
    private String sqlUrl="";
    private String userName="";
    private String password="";
    Test t=new Test();
    @Override
    public void addUser(User user) {
        String sql="insert into user(name,email) values(?,?)";
        try(Connection c=DriverManager.getConnection(sqlUrl,userName,password);
        PreparedStatement ps =c.prepareStatement(sql)){
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            int rowsAffected=ps.executeUpdate();

            if(rowsAffected>0){
                System.out.println("User Created");
            }else{
                System.out.println("User Creation Failed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUser() {
        ArrayList<User> userLsit=new ArrayList<>();
        String sql="select * from user";
        try(Connection c=DriverManager.getConnection(sqlUrl,userName,password);
        PreparedStatement ps=c.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User user=new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                userLsit.add(user);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return userLsit;
    }

    @Override
    public User getUserById(int id) {
        String sql="select * from user where id=?;";
        try(Connection c=DriverManager.getConnection(sqlUrl,userName,password);
            PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteUser(int id) {
           String sql="delete from user where id=?";
           try(Connection c=DriverManager.getConnection(sqlUrl,userName,password);
           PreparedStatement ps=c.prepareStatement(sql)){
               ps.setInt(1,id);
               ps.executeUpdate();
           }catch (SQLException e){
               e.printStackTrace();
           }
    }
}
