package dsa.utils;

import dsa.models.Item;
import dsa.models.User;

import java.util.List;

public interface GameManager {
    List<User> sortByName();
    void addUser(User u);
    void updateUser(User u) throws UserNotFoundException;
    int sizeUsers();
    List<User> seeUser(User u);
    void addItem(Item i1);
    void clear();
}
