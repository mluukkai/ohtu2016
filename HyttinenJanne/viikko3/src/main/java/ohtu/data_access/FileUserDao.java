/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
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
 * @author hyttijan
 */
public class FileUserDao implements UserDao{
    private String fileStr;

    public FileUserDao(String fileStr) throws FileNotFoundException{
      this.fileStr = fileStr;
    }
    @Override
    public List<User> listAll() {
        
        try {
        Scanner scanner = new Scanner(new File(fileStr));
        
        ArrayList<User> users = new ArrayList<User>();
        while(scanner.hasNextLine()){
            String username = scanner.nextLine();
            String password = scanner.nextLine();
            users.add(new User(username,password));
        }
        return users;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public User findByName(String name) {
       
        try {
        Scanner scanner = new Scanner(new File(fileStr));
       
       while(scanner.hasNextLine()){
            String username = scanner.nextLine();
            String password = scanner.nextLine();
           if(name.equals(username)){
               return new User(username,password);
           }
           
       }
       } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }

    @Override
    public void add(User user) {
        try {
            FileWriter pw = new FileWriter(this.fileStr,true);
            
            pw.append(user.getUsername()+"\n");
            pw.append(user.getPassword());
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
