package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ohtu.domain.User;

public class FileUserDao implements UserDao {
    private List<User> users;
	public FileUserDao(String name ) {
	       users = new ArrayList<User>();
		try {
			Scanner sc = new Scanner(new File(name));
			String line;
			
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				String user[] = line.split(" ");
				users.add(new User(user[0], user[1]));
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<User> listAll() {
		return users;
	}

	@Override
	public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
	}

	@Override
	public void add(User user) {
        users.add(user);
	}

}
