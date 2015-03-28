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
 * @author axel
 */
public class FileUserDAO implements UserDao {

    private String filename;

    public FileUserDAO(String filename) {
        this.filename = filename;
    }

    private List<User> readFile() {
        Scanner scanner = null;
        ArrayList<User> users = new ArrayList<User>();
        try {
            scanner = new Scanner(new File(this.filename));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (scanner != null && scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(":");
            User u = new User(data[0], data[1]);
            users.add(u);
        }
        return users;
    }

    private void appendUserToFile(User user) {
        File file = new File(this.filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            writer.append(user.getUsername() + ":" + user.getPassword() + "\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ;

@Override
    public List<User> listAll() {
        return readFile();
    }

    @Override
    public User findByName(String name) {
        List<User> users = readFile();
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        appendUserToFile(user);
    }

}
