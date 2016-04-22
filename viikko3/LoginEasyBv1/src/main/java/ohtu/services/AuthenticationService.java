package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

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
        if (userDao.findByName(username) != null) {
            return true;
        }
        
        if (username.length() < 3) {
            return true;
        }

        if (passwordCheck(password)) {
            return true;
        }// validity check of username and password

        return false;
    }

    private boolean passwordCheck(String password) {
        if (password.length() < 8) {
            return true;
        }

        String numbersETC = "01234567890§½!#¤%&/()=?`´+}][{$£@<|>;:.,-_'*ˇ¨~^";
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < numbersETC.length(); j++) {
                if (password.charAt(i) == numbersETC.charAt(j)) {
                    return false;
                }
            }
        }
        return true;

    }
}
