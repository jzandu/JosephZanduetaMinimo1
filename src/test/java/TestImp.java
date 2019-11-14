import dsa.models.Item;
import dsa.models.User;
import dsa.utils.GameManagerImp;
import dsa.utils.GameManager;

import dsa.utils.UserNotFoundException;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class TestImp {

    static GameManager p1;

    @Before
    public void setUp() throws UserNotFoundException {

        GameManager p1 = GameManagerImp.getInstance();

        Item i1;

        p1.addUser("1234", "Pedro", "Lopez");
        p1.addUser("1345","Juan", "Lopez");
        p1.addUser("1125","Ana", "Lopez");


        i1 = new Item("Escudo", 2);
        p1.addItemToUser("1234",i1);
        i1 = new Item("Arma", 1);
        p1.addItemToUser("1345",i1);
        i1 = new Item("Moneda", 4);
        p1.addItemToUser("1125",i1);




    }
    @AfterClass
    public static void tearDown(){
        p1.clear();
    }

    @Test
    public void sortByName() {
        List<User> list1 = new LinkedList<>();
        list1=this.p1.sortByName();
        assertEquals(list1.get(0).getName(), "Ana", "Ana");
        assertEquals(list1.get(1).getName(), "Juan", "Juan");
        assertEquals(list1.get(2).getName(), "Pedro", "Pedro");

    }


    @Test
    public void addUserTest() {
        p1.addUser("1111", "Ignacio", "Lopez");
        Assert.assertEquals(4, this.p1.sizeUsers());
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
