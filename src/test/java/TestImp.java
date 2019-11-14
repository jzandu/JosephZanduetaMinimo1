import dsa.models.Item;
import dsa.models.User;
import dsa.utils.GameManagerImp;
import dsa.utils.GameManager;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class TestImp {
    static GameManager p1;

    @Before
    public void setUp() {
        User u1;
        Item i1;

        GameManager p1 = GameManagerImp.getInstance();
        i1 = new Item("Escudo", 2);
        p1.addItem(i1);
        i1 = new Item("Arma", 1);
        p1.addItem(i1);
        i1 = new Item("Moneda", 4);
        p1.addItem(i1);

        u1 = new User("1234", "Pedro", "Lopez");
        p1.addUser(u1);
        u1 = new User("1345","Juan", "Lopez");
        p1.addUser(u1);


    }
    @Test
    public void tearDown(){
        p1.clear();
    }
    @Test
    public void sortByName() {
        List<User> list1 = this.p1.sortByName();
        assertEquals(list1.get(0).getName(), "Juan", "Pedro");
        assertEquals(list1.get(1).getName(), "Pedro", "Juan");
    }

    @Test
    public void sizeUsers() {
    }

    @Test
    public void seeUser() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void updateUser() {
    }


}
