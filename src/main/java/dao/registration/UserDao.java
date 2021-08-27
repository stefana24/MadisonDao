package dao.registration;

import models.User;
import tools.constants.SerenityKeyConstants;
import tools.utils.SerenitySessionUtils;

import java.util.List;

public class UserDao implements UserAbstractDao {
    @Override
    public void saveUser(User user) {
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.REGISTER_USERS_LIST,user);
    }

    @Override
    public List<User> getAllUsers() {
        return SerenitySessionUtils.getFromSession(SerenityKeyConstants.REGISTER_USERS_LIST);
    }

    @Override
    public void removeUser(User user) {
        SerenitySessionUtils.removeObjectFromSerenitySessionList(SerenityKeyConstants.REGISTER_USERS_LIST,user);
    }

    @Override
    public User getUserByEmail(String email) {
        List<User> users = getAllUsers();
        return users.parallelStream().filter(item -> item.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }
}
