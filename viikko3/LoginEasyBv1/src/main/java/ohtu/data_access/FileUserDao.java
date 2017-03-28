/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

/**
 *
 * @author Sara ja Laur
 */
public class FileUserDao implements UserDao {

    Scanner scanner;
    String filename;
    File f;

    public FileUserDao(String filename) throws FileNotFoundException, IOException {
        f = new File(filename);
        this.filename = filename;
        if (!f.exists()) {
            f.createNewFile();
        }

    }

    private List<User> getUsers() throws FileNotFoundException, IOException {
        BufferedReader scanner = new BufferedReader(new FileReader(f));
        List<User> users = new ArrayList<User>();
        String line;
        while ((line = scanner.readLine()) != null) {
            String[] lineArray = line.split(";");
        }
        scanner.close();
        return users;
    }

    @Override
    public List<User> listAll() {
        try {
            return getUsers();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private User findUser(String name) throws FileNotFoundException, IOException {
        String line; BufferedReader scanner = new BufferedReader(new FileReader(f));
        while ((line = scanner.readLine()) != null) {
            String[] lineArray = line.split(";");
            if (name.matches(lineArray[0])) {
                return new User(lineArray[0], lineArray[1]);
            }
        }
        scanner.close(); return null;
    }
    

    @Override
    public User findByName(String name) {
        try {
            return findUser(name);
        } catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(User user) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
            writer.write(user.getUsername() + ";" + user.getPassword());
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}