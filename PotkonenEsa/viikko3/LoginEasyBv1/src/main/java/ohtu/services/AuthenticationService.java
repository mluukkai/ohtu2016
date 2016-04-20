package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        // validity check of username and password
    	boolean userOK = false;
    	boolean paswOK = false;
    	boolean notValid = true;
	   if(username != null && username.matches("[a-z]{3,}")) {
		   userOK = true;
	   }
	   Pattern p = Pattern.compile("[^A-Za-z0-9]");
	   Matcher m = p.matcher(password);
	   
	   if(password != null && m.find() && password.length() > 8) {
		   paswOK = true;
	   }
	   if(userOK && paswOK) {
		   notValid = false; 
	   }
       return notValid;
    }
}
