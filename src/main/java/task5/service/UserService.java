package task5.service;

import task5.dao.User;
import task5.utility.ValidationUtils;

import java.io.*;
import java.util.UUID;

public class UserService {

    public synchronized void createUser(User user) {
        var actualFile = getActualFile(user.getId());
        ValidationUtils.validateUser(actualFile.exists(), false, "User with id %s already exists".formatted(user.getId()));
        try (FileOutputStream fos = new FileOutputStream(actualFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createUsers(User... users) {
        for (User user1 : users) {
            this.createUser(user1);
        }
    }

    public synchronized void writeUser(User user) {
        var actualFile = getActualFile(user.getId());
        ValidationUtils.validateUser(actualFile.exists(), true, "User with id %s does not exists".formatted(user.getId()));
        try (FileOutputStream fos = new FileOutputStream(actualFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public User readUser(UUID id) {
        User user;
        var actualFile = getActualFile(id);
        ValidationUtils.validateUser(actualFile.exists(), true, "User with id %s does not exists".formatted(id));
        try (FileInputStream fos = new FileInputStream(actualFile);
             ObjectInputStream oos = new ObjectInputStream(fos)) {
            user = (User) oos.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return user;
    }

    private File getActualFile(UUID id) {
        String dirName = System.getProperty("user.dir") + "\\src\\main\\resources\\users";
        String fileName = id + ".txt";
        File dir = new File(dirName);
        return new File(dir, fileName);
    }
}
