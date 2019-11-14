package dsa.utils;

import dsa.models.Item;
import dsa.models.User;

import java.util.HashMap;
import java.util.List;

public interface GameManager {
    List<User> sortByName();

    void addUser(String i, String n, String a);

    void updateUser(User u) throws UserNotFoundException;

    int sizeUsers();

    String seeUser(String u);

    void addItemToUser(String id, Item i2) throws UserNotFoundException;

    String getObjectsUser(User u) throws UserNotFoundException;

    void clear();

    int sizeItemListUser();

    public HashMap<String, User> allUsers();
}
