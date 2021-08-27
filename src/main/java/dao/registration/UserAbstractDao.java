package dao.registration;

import com.google.inject.ImplementedBy;
import models.User;

import java.util.List;
@ImplementedBy(UserDao.class)
public interface UserAbstractDao {
    public void saveUser(User user);
    public List<User> getAllUsers();
    public void removeUser(User user);
    public User getUserByEmail(String email);
}
