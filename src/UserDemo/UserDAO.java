package UserDemo;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    List<User> getAllUser();
    User getUserById(int id);
    void deleteUser(int id);
}
