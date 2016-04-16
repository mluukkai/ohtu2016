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

    private boolean checkForLength(String username, String password) {
        if (username.length() < 3) {
            System.out.println("username must contain atleast 3 chars");
            return true;
        }

        if (password.length() < 8) {
            System.out.println("password must contain atleast 8 chars");
            return true;
        }
        return false;
    }

    public boolean checkForAlphaNumerics(String username, String password) {
        boolean passwordHasANumber = false;
        boolean passwordHasANonAlphaNumeric = false;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                passwordHasANumber = true;
            } else if (password.charAt(i) < 'a' || password.charAt(i) > 'z') {
                passwordHasANonAlphaNumeric = true;
            }
        }
        if (!passwordHasANumber || !passwordHasANonAlphaNumeric) {
            return false;
        }
        return true;
    }

    private boolean invalid(String username, String password) {
      
        if (checkForLength(username, password)) {
            return true;
        }

        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) < 'a' || username.charAt(i) > 'z') {
                System.out.println("username can only contain chars a-z");
                return true;
            }
        }

        if (!checkForAlphaNumerics(username, password)) {
            System.out.println("password must contain atleast one number and one non-alpha-numeric char");
            return true;
        }
        return false;
    }
}
