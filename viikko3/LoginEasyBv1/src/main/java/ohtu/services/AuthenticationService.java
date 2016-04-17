package ohtu.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;
import ohtu.domain.User;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        if(username.length() < 3) {
            return true;
        }
        if(password.length() < 8) {
            return true;
        }
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return true;
        }
        if (!Pattern.compile("[a-z]*").matcher(username).matches()) {
            return true;
        }

        return false;
    }
}
